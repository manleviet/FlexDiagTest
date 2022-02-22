package at.tugraz.ist.ase.flexdiagtest;

import at.tugraz.ist.ase.cacdr.algorithms.FlexDiag;
import at.tugraz.ist.ase.cacdr.algorithms.QuickXPlain;
import at.tugraz.ist.ase.cacdr.algorithms.hsdag.HSDAG;
import at.tugraz.ist.ase.cacdr.algorithms.hsdag.labeler.FlexDiagLabeler;
import at.tugraz.ist.ase.cacdr.algorithms.hsdag.parameters.FlexDiagParameters;
import at.tugraz.ist.ase.cacdr.checker.ChocoConsistencyChecker;
import at.tugraz.ist.ase.cacdr.eval.CAEvaluator;
import at.tugraz.ist.ase.knowledgebases.core.Constraint;
import at.tugraz.ist.ase.knowledgebases.core.KB;

import java.util.List;
import java.util.Set;

import static at.tugraz.ist.ase.cacdr.algorithms.FlexDiag.TIMER_FLEXDIAG;
import static at.tugraz.ist.ase.cacdr.eval.CAEvaluator.TIMER_SOLVER;
import static at.tugraz.ist.ase.cacdr.eval.CAEvaluator.printPerformance;
import static at.tugraz.ist.ase.common.ConstraintUtils.convertToStringWithMessage;
import static at.tugraz.ist.ase.eval.evaluator.PerformanceEvaluator.getTimer;

public class MainV2 {
    public static void main(String[] args) {
//        KB kb = new NOK1_1KB(); // initialize the knowledge base model_1_nok_1
//        KB kb = new NOK1_2KB(); // initialize the knowledge base model_1_nok_2
//        KB kb = new NOK1_3KB(); // initialize the knowledge base model_1_nok_3
//        KB kb = new NOK2KB(); // initialize the knowledge base model_2_nok
        KB kb = new NOK3KB(); // initialize the knowledge base model_2_nok

        NOKModel model = new NOKModel(kb); // create an object of the conflict detection and resolution model
        model.initialize(); // initialize the model
        // create a consistency checker, which is used to check the consistency of the model
        ChocoConsistencyChecker checker = new ChocoConsistencyChecker(model);

        Set<Constraint> C = model.getPossiblyFaultyConstraints();
        Set<Constraint> B = model.getCorrectConstraints();
        Set<Constraint> AC = model.getAllConstraints();

        // QUICKXPLAIN
        QuickXPlain quickXplain = new QuickXPlain(checker);

        CAEvaluator.reset();
        Set<Constraint> firstConflictSet = quickXplain.findConflictSet(C, B);

        System.out.println("=========================================");
        System.out.println("Conflict sets found by QuickXplain:");
        System.out.println(firstConflictSet);

        // FLEXDIAG
        FlexDiag fd = new FlexDiag(checker); // create a FlexDiag object

        // reset the timers, the counters
        CAEvaluator.reset();
        // identify the diagnosis
        Set<Constraint> diagnosis = fd.findDiagnosis(C, AC, 1);

        if (diagnosis.isEmpty()) {
            System.out.println("=========================================");
            System.out.println("No diagnosis found");
        } else {
            System.out.println("=========================================");
            System.out.println("One diagnosis found by FlexDiag:");
            System.out.println(diagnosis);
            System.out.println("Time for FlexDiag: " + + ((double) getTimer(TIMER_FLEXDIAG).total() / 1_000_000_000.0));
            System.out.println("Time for solver: " + ((double) getTimer(TIMER_SOLVER).total() / 1_000_000_000.0));
//            printPerformance();
        }

        // FLEXDIAG - all diagnoses
        // create parameters for the HSDAG algorithm
        FlexDiagParameters parameters = new FlexDiagParameters(model.getPossiblyFaultyConstraints(), model.getAllConstraints(), 1);
        // create a labeler, which is used to label the nodes of the HSDAG
        FlexDiagLabeler flexDiag = new FlexDiagLabeler(checker, parameters);

        HSDAG hsdag = new HSDAG(flexDiag, checker); // create an HSDAG object

        // reset the timers, the counters
        CAEvaluator.reset();
        hsdag.construct(); // construct the HSDAG

        List<Set<Constraint>> allConflictSets = hsdag.getDiagnoses(); // get all conflict sets
        List<Set<Constraint>> allDiagnoses = hsdag.getConflicts(); // get all diagnoses

        if (!allDiagnoses.isEmpty()) {
            System.out.println("=========================================");
            System.out.println("Diagnoses found by FlexDiag:");
            System.out.println(convertToStringWithMessage(allDiagnoses, "Diagnosis"));
//            printPerformance();

            for (int i = 0; i < allDiagnoses.size(); i++) {
                System.out.println("Time for diagnosis " + (i+1) + ": " + ((double) getTimer(TIMER_FLEXDIAG).getTimings().get(i) / 1_000_000_000.0));
                System.out.println("Time for solver: " + ((double) getTimer(TIMER_SOLVER).getTimings().get(i) / 1_000_000_000.0));
            }
        }

        // FASTDIAG
//        // run the fastDiag to find diagnoses
//        FastDiagV2 fd = new FastDiagV2(checker);
//
//        CAEvaluator.reset();
//        Set<Constraint> firstDiag = fd.findDiagnosis(C, AC);
//
//        if (firstDiag.isEmpty()) {
//            System.out.println("=========================================");
//            System.out.println("No diagnosis found");
//        } else {
//            System.out.println("=========================================");
//            System.out.println("One diagnosis found by FastDiag:");
//            System.out.println(firstDiag);
//            System.out.println("Time for FastDiag: " + + ((double) getTimer(TIMER_FASTDIAGV2).total() / 1_000_000_000.0));
//            System.out.println("Time for solver: " + ((double) getTimer(TIMER_SOLVER).total() / 1_000_000_000.0));
////            printPerformance();
//        }
//
//        // create parameters for the HSDAG algorithm
//        FastDiagV2Parameters fastdiag_parameters = new FastDiagV2Parameters(C, AC);
//        // create a labeler, which is used to label the nodes of the HSDAG
//        FastDiagV2Labeler fastDiag = new FastDiagV2Labeler(checker, fastdiag_parameters);
//
//        HSDAG hsdag = new HSDAG(fastDiag, checker); // create an HSDAG object
//
//        // reset the timers, the counters
//        CAEvaluator.reset();
//        hsdag.construct(); // construct the HSDAG
//
//        List<Set<Constraint>> allConflictSets = hsdag.getDiagnoses(); // get all conflict sets
//        List<Set<Constraint>> allDiagnoses = hsdag.getConflicts(); // get all diagnoses
//
//        if (!allDiagnoses.isEmpty()) {
//            System.out.println("=========================================");
//            System.out.println("Diagnoses found by FastDiag:");
//            System.out.println(convertToStringWithMessage(allDiagnoses, "Diagnosis"));
////            printPerformance();
//
//            for (int i = 0; i < allDiagnoses.size(); i++) {
//                System.out.println("Time for diagnosis " + (i+1) + ": " + ((double) getTimer(TIMER_FASTDIAGV2).getTimings().get(i) / 1_000_000_000.0));
//                System.out.println("Time for solver: " + ((double) getTimer(TIMER_SOLVER).getTimings().get(i) / 1_000_000_000.0));
//            }
//        }
    }
}
