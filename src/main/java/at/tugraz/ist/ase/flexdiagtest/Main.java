package at.tugraz.ist.ase.flexdiagtest;

import at.tugraz.ist.ase.cacdr.algorithms.FastDiagV2;
import at.tugraz.ist.ase.cacdr.algorithms.FlexDiag;
import at.tugraz.ist.ase.cacdr.algorithms.QuickXPlain;
import at.tugraz.ist.ase.cacdr.algorithms.hsdag.HSDAG;
import at.tugraz.ist.ase.cacdr.algorithms.hsdag.labeler.FastDiagV2Labeler;
import at.tugraz.ist.ase.cacdr.algorithms.hsdag.labeler.FlexDiagLabeler;
import at.tugraz.ist.ase.cacdr.algorithms.hsdag.labeler.QuickXPlainLabeler;
import at.tugraz.ist.ase.cacdr.algorithms.hsdag.parameters.FastDiagV2Parameters;
import at.tugraz.ist.ase.cacdr.algorithms.hsdag.parameters.FlexDiagParameters;
import at.tugraz.ist.ase.cacdr.algorithms.hsdag.parameters.QuickXPlainParameters;
import at.tugraz.ist.ase.cacdr.checker.ChocoConsistencyChecker;
import at.tugraz.ist.ase.cacdr.eval.CAEvaluator;
import at.tugraz.ist.ase.knowledgebases.core.Constraint;
import at.tugraz.ist.ase.knowledgebases.core.KB;

import java.util.List;
import java.util.Set;

import static at.tugraz.ist.ase.cacdr.algorithms.FastDiagV2.TIMER_FASTDIAGV2;
import static at.tugraz.ist.ase.cacdr.algorithms.FlexDiag.TIMER_FLEXDIAG;
import static at.tugraz.ist.ase.cacdr.algorithms.QuickXPlain.TIMER_QUICKXPLAIN;
import static at.tugraz.ist.ase.cacdr.algorithms.hsdag.AbstractHSConstructor.TIMER_CONFLICT;
import static at.tugraz.ist.ase.cacdr.eval.CAEvaluator.TIMER_SOLVER;
import static at.tugraz.ist.ase.cacdr.eval.CAEvaluator.printPerformance;
import static at.tugraz.ist.ase.common.ConstraintUtils.convertToStringWithMessage;
import static at.tugraz.ist.ase.eval.evaluator.PerformanceEvaluator.getTimer;

/**
 * Main class for the FlexDiag testing.
 */
public class Main {
    public static void main(String[] args) {
        // uncomment one of the following KBs to choose a KB to use
//        KB kb = new NOK1_1KB(); // initialize the knowledge base model_1_nok_1
//        KB kb = new NOK1_2KB(); // initialize the knowledge base model_1_nok_2
        KB kb = new NOK1_3KB(); // initialize the knowledge base model_1_nok_3
//        KB kb = new NOK2KB(); // initialize the knowledge base model_2_nok
//        KB kb = new NOK3KB(); // initialize the knowledge base model_2_nok

        // print the KB
        // uncomment to print the KB's constraints
//        System.out.println(kb);
//        for (Constraint c : kb.getConstraintList()) { // print all constraints
//            System.out.println(c);
//            c.getChocoConstraints().forEach(System.out::println);
//            System.out.println();
//        }

        // create an object of the conflict detection and resolution model
        NOKModel model = new NOKModel(kb);
        // initialize the model, i.e. set the KB's constraints to the model's two sets - the set of possibly faulty constraints (C)
        // and the set of correct constraints (background knowledge - B)
        model.initialize();
        // create a consistency checker, which is used to check the consistency of a given set of constraints
        ChocoConsistencyChecker checker = new ChocoConsistencyChecker(model);

        Set<Constraint> C = model.getPossiblyFaultyConstraints();
        Set<Constraint> B = model.getCorrectConstraints();
        Set<Constraint> AC = model.getAllConstraints();

        // QUICKXPLAIN
        QuickXPlain quickXplain = new QuickXPlain(checker); // create a QuickXPlain object

        CAEvaluator.reset(); // reset the timers, the counters
        Set<Constraint> firstConflictSet = quickXplain.findConflictSet(C, B); // identify one conflict set

        if (firstConflictSet.isEmpty()) {
            System.out.println("=========================================");
            System.out.println("No conflict");
        } else {
            System.out.println("=========================================");
            System.out.println("First conflict set found by QuickXplain:");
            System.out.println(firstConflictSet);
            System.out.println("Time for QuickXPlain: " + ((double) getTimer(TIMER_QUICKXPLAIN).total() / 1_000_000_000.0));
            System.out.println("Time for solver: " + ((double) getTimer(TIMER_SOLVER).total() / 1_000_000_000.0));
//            printPerformance();

            // HSDAG + QUICKXPLAIN
            QuickXPlainParameters qxParams = new QuickXPlainParameters(C, B);
            // create a labeler, which is used to label the HSDAG's nodes (label - a conflict set or a diagnosis)
            QuickXPlainLabeler qxLabeler = new QuickXPlainLabeler(checker, qxParams);

            HSDAG hsdag = new HSDAG(qxLabeler, checker); // create an HSDAG object with the QuickXPlainLabeler and the consistency checker

            // reset the timers, the counters
            CAEvaluator.reset();
            hsdag.construct(); // construct the HSDAG

            List<Set<Constraint>> allConflictSets = hsdag.getConflicts(); // get all conflict sets
            List<Set<Constraint>> allDiagnoses = hsdag.getDiagnoses(); // get all diagnoses

            if (!allConflictSets.isEmpty()) {
                System.out.println("=========================================");
                System.out.println("Conflict sets found by QuickXPlain:");
                System.out.println(convertToStringWithMessage(allConflictSets, "Conflict set"));
//                printPerformance();

                for (int i = 0; i < allConflictSets.size(); i++) {
                    System.out.println("Time for conflict " + (i + 1) + ": " + ((double) getTimer(TIMER_CONFLICT).getTimings().get(i) / 1_000_000_000.0));
                    System.out.println("Time for solver: " + ((double) getTimer(TIMER_SOLVER).getTimings().get(i) / 1_000_000_000.0));
                }
            }
        }

        // FLEXDIAG
        FlexDiag flexDiag = new FlexDiag(checker); // create a FlexDiag object

        CAEvaluator.reset(); // reset the timers, the counters
        Set<Constraint> diagnosis = flexDiag.findDiagnosis(C, AC, 1); // identify one diagnosis

        if (diagnosis.isEmpty()) {
            System.out.println("=========================================");
            System.out.println("No diagnosis found");
        } else {
            System.out.println("=========================================");
            System.out.println("One diagnosis found by FlexDiag:");
            System.out.println(diagnosis);
            System.out.println("Time for FlexDiag: " + ((double) getTimer(TIMER_FLEXDIAG).total() / 1_000_000_000.0));
            System.out.println("Time for solver: " + ((double) getTimer(TIMER_SOLVER).total() / 1_000_000_000.0));
//            printPerformance();

            // HSDAG + FLEXDIAG - all diagnoses
            // create parameters for the HSDAG algorithm
            FlexDiagParameters parameters = new FlexDiagParameters(C, AC, 1);
            // create a labeler, which is used to label the HSDAG's nodes (label - a conflict set or a diagnosis)
            FlexDiagLabeler flexDiagLabeler = new FlexDiagLabeler(checker, parameters);

            HSDAG hsdag = new HSDAG(flexDiagLabeler, checker); // create an HSDAG object

            // reset the timers, the counters
            CAEvaluator.reset();
            hsdag.construct(); // construct the HSDAG

            List<Set<Constraint>> allConflictSets = hsdag.getDiagnoses(); // get all conflict sets
            List<Set<Constraint>> allDiagnoses = hsdag.getConflicts(); // get all diagnoses

            if (!allDiagnoses.isEmpty()) {
                System.out.println("=========================================");
                System.out.println("Diagnoses found by FlexDiag:");
                System.out.println(convertToStringWithMessage(allDiagnoses, "Diagnosis"));
//                printPerformance();

                for (int i = 0; i < allDiagnoses.size(); i++) {
                    System.out.println("Time for diagnosis " + (i + 1) + ": " + ((double) getTimer(TIMER_CONFLICT).getTimings().get(i) / 1_000_000_000.0));
                    System.out.println("Time for solver: " + ((double) getTimer(TIMER_SOLVER).getTimings().get(i) / 1_000_000_000.0));
                }
            }
        }

        // FASTDIAG
        // run the fastDiag to find diagnoses
        FastDiagV2 fastDiag = new FastDiagV2(checker);

        CAEvaluator.reset();
        Set<Constraint> firstDiag = fastDiag.findDiagnosis(C, AC);

        if (firstDiag.isEmpty()) {
            System.out.println("=========================================");
            System.out.println("No diagnosis found");
        } else {
            System.out.println("=========================================");
            System.out.println("One diagnosis found by FastDiag:");
            System.out.println(firstDiag);
            System.out.println("Time for FastDiag: " + ((double) getTimer(TIMER_FASTDIAGV2).total() / 1_000_000_000.0));
            System.out.println("Time for solver: " + ((double) getTimer(TIMER_SOLVER).total() / 1_000_000_000.0));
//            printPerformance();

            // HSDAG + FASTDIAG - all diagnoses
            // create parameters for the HSDAG algorithm
            FastDiagV2Parameters fastdiag_parameters = new FastDiagV2Parameters(C, AC);
            // create a labeler, which is used to label the nodes of the HSDAG
            FastDiagV2Labeler fastDiagLabeler = new FastDiagV2Labeler(checker, fastdiag_parameters);

            HSDAG hsdag = new HSDAG(fastDiagLabeler, checker); // create an HSDAG object

            // reset the timers, the counters
            CAEvaluator.reset();
            hsdag.construct(); // construct the HSDAG

            List<Set<Constraint>> allConflictSets = hsdag.getDiagnoses(); // get all conflict sets
            List<Set<Constraint>> allDiagnoses = hsdag.getConflicts(); // get all diagnoses

            if (!allDiagnoses.isEmpty()) {
                System.out.println("=========================================");
                System.out.println("Diagnoses found by FastDiag:");
                System.out.println(convertToStringWithMessage(allDiagnoses, "Diagnosis"));
//                printPerformance();

                for (int i = 0; i < allDiagnoses.size(); i++) {
                    System.out.println("Time for diagnosis " + (i+1) + ": " + ((double) getTimer(TIMER_CONFLICT).getTimings().get(i) / 1_000_000_000.0));
                    System.out.println("Time for solver: " + ((double) getTimer(TIMER_SOLVER).getTimings().get(i) / 1_000_000_000.0));
                }
            }
        }
    }
}
