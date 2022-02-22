package at.tugraz.ist.ase.flexdiagtest;

import at.tugraz.ist.ase.common.LoggerUtils;
import at.tugraz.ist.ase.knowledgebases.core.*;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.BoolVar;
import org.chocosolver.solver.variables.IntVar;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class NOK3KB extends KB {

    public NOK3KB() {
        super("NOK3", "Siemens NOK3", false);

        reset(false);
    }

    @Override
    public void reset(boolean hasNegativeConstraints) {
        log.trace("{}Creating NOK3 >>>", LoggerUtils.tab);
        LoggerUtils.indent();

        modelKB = new Model(name);
        variableList = new LinkedList<>();
        domainList = new LinkedList<>();
        constraintList = new LinkedList<>();
        defineDomains();
        defineVariables();
        defineConstraints(hasNegativeConstraints);

        LoggerUtils.outdent();
        log.debug("{}<<< Created NOK3", LoggerUtils.tab);
    }

    private void defineDomains() {
        log.trace("{}Defining domains >>>", LoggerUtils.tab);
        LoggerUtils.indent();

        domainList.add(Domain.builder()
                .name("dppm_vm_0")
                .values(List.of("0"))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vm_1")
                .values(List.of("1", "2", "3", "4"))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vm_2")
                .values(List.of("1", "2", "3", "4"))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vm_3")
                .values(List.of("5", "6"))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vm_4")
                .values(List.of("5", "6"))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vm_5")
                .values(List.of("7", "8", "9", "10", "11", "12", "13"))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vm_6")
                .values(List.of("7", "8", "9", "10", "11", "12", "13"))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vm_7")
                .values(List.of("14"))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vm_8")
                .values(List.of("15", "16", "17", "18", "19", "20"))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vm_9")
                .values(List.of("21", "22"))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vm_10")
                .values(List.of("23"))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vm_11")
                .values(List.of("24"))
                .build());

        domainList.add(Domain.builder()
                .name("dppm_vs_0")
                .values(List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vs_1")
                .values(List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vs_2")
                .values(List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vs_3")
                .values(List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vs_4")
                .values(List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vs_5")
                .values(List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vs_6")
                .values(List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vs_7")
                .values(List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vs_8")
                .values(List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vs_9")
                .values(List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vs_10")
                .values(List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vs_11")
                .values(List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"))
                .build());

        LoggerUtils.outdent();
        log.debug("{}<<< Created domains", LoggerUtils.tab);
    }

    public void defineVariables (){
        log.trace("{}Defining variables >>", LoggerUtils.tab);
        LoggerUtils.indent();

        List<String> varNames = List.of("dppm_vm_0", "dppm_vm_1", "dppm_vm_2", "dppm_vm_3", "dppm_vm_4", "dppm_vm_5", "dppm_vm_6",
                                        "dppm_vm_7", "dppm_vm_8", "dppm_vm_9", "dppm_vm_10", "dppm_vm_11",
                                        "dppm_vs_0", "dppm_vs_1", "dppm_vs_2", "dppm_vs_3", "dppm_vs_4", "dppm_vs_5", "dppm_vs_6",
                                        "dppm_vs_7", "dppm_vs_8", "dppm_vs_9", "dppm_vs_10", "dppm_vs_11");

        for (int i = 0; i < varNames.size(); i++) {
            String varName = varNames.get(i);
            IntVar intVar = this.modelKB.intVar(varName, domainList.get(i).getIntValues());
            Variable var = IntVariable.builder()
                    .name(varName)
                    .domain(domainList.get(i))
                    .chocoVar(intVar).build();
            variableList.add(var);
        }

        // dppm_vmakespan - V24
        Domain d = Domain.builder()
                .name("dppm_vmakespan")
                .values(List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"))
                .build();
        domainList.add(d);
        IntVar intVar = this.modelKB.intVar("dppm_vmakespan", d.getIntValues());
        IntVariable var = IntVariable.builder()
                .name("dppm_vmakespan")
                .domain(d)
                .chocoVar(intVar).build();
        variableList.add(var);

        LoggerUtils.outdent();
        log.debug("{}<<< Created variables", LoggerUtils.tab);
    }

    public void defineConstraints(boolean hasNegativeConstraints) {
        log.trace("{}Defining constraints >>>", LoggerUtils.tab);
        LoggerUtils.indent();

        constraintGroup1();
        constraintGroup2();
        constraintGroup3();
        constraintGroup4();

        LoggerUtils.outdent();
        log.debug("{}<<< Created constraints", LoggerUtils.tab);
    }

    private void constraintGroup1() {
        int startIdx = 0;

        // Constraint 1 - dppm_vm_0.eq(dppm_vm_1).imp(dppm_vs_0.ne(dppm_vs_1)).post();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(0)).getChocoVar(),"=", ((IntVariable)variableList.get(1)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(12)).getChocoVar(),"!=", ((IntVariable)variableList.get(13)).getChocoVar()));

        addConstraint("Constraint 1 - dppm_vm_0.eq(dppm_vm_1).imp(dppm_vs_0.ne(dppm_vs_1)).post();",
                startIdx);

        // Constraint 2 - dppm_vm_0.eq(dppm_vm_2).imp(dppm_vs_0.ne(dppm_vs_2)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(0)).getChocoVar(),"=", ((IntVariable)variableList.get(2)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(12)).getChocoVar(),"!=", ((IntVariable)variableList.get(14)).getChocoVar()));

        addConstraint("Constraint 2 - dppm_vm_0.eq(dppm_vm_2).imp(dppm_vs_0.ne(dppm_vs_2)).post();",
                startIdx);

        // Constraint 3 - dppm_vm_0.eq(dppm_vm_3).imp(dppm_vs_0.ne(dppm_vs_3)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(0)).getChocoVar(),"=", ((IntVariable)variableList.get(3)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(12)).getChocoVar(),"!=", ((IntVariable)variableList.get(15)).getChocoVar()));

        addConstraint("Constraint 3 - dppm_vm_0.eq(dppm_vm_3).imp(dppm_vs_0.ne(dppm_vs_3)).post();",
                startIdx);

        // Constraint 4 - dppm_vm_0.eq(dppm_vm_4).imp(dppm_vs_0.ne(dppm_vs_4)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(0)).getChocoVar(),"=", ((IntVariable)variableList.get(4)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(12)).getChocoVar(),"!=", ((IntVariable)variableList.get(16)).getChocoVar()));

        addConstraint("Constraint 4 - dppm_vm_0.eq(dppm_vm_4).imp(dppm_vs_0.ne(dppm_vs_4)).post();",
                startIdx);

        // Constraint 5 - dppm_vm_0.eq(dppm_vm_5).imp(dppm_vs_0.ne(dppm_vs_5)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(0)).getChocoVar(),"=", ((IntVariable)variableList.get(5)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(12)).getChocoVar(),"!=", ((IntVariable)variableList.get(17)).getChocoVar()));

        addConstraint("Constraint 5 - dppm_vm_0.eq(dppm_vm_5).imp(dppm_vs_0.ne(dppm_vs_5)).post();",
                startIdx);

        // Constraint 6 - dppm_vm_0.eq(dppm_vm_6).imp(dppm_vs_0.ne(dppm_vs_6)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(0)).getChocoVar(),"=", ((IntVariable)variableList.get(6)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(12)).getChocoVar(),"!=", ((IntVariable)variableList.get(18)).getChocoVar()));

        addConstraint("Constraint 6 - dppm_vm_0.eq(dppm_vm_6).imp(dppm_vs_0.ne(dppm_vs_6)).post();",
                startIdx);

        // Constraint 7 - dppm_vm_0.eq(dppm_vm_7).imp(dppm_vs_0.ne(dppm_vs_7)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(0)).getChocoVar(),"=", ((IntVariable)variableList.get(7)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(12)).getChocoVar(),"!=", ((IntVariable)variableList.get(19)).getChocoVar()));

        addConstraint("Constraint 7 - dppm_vm_0.eq(dppm_vm_7).imp(dppm_vs_0.ne(dppm_vs_7)).post();",
                startIdx);

        // Constraint 8 - dppm_vm_0.eq(dppm_vm_8).imp(dppm_vs_0.ne(dppm_vs_8)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(0)).getChocoVar(),"=", ((IntVariable)variableList.get(8)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(12)).getChocoVar(),"!=", ((IntVariable)variableList.get(20)).getChocoVar()));

        addConstraint("Constraint 8 - dppm_vm_0.eq(dppm_vm_8).imp(dppm_vs_0.ne(dppm_vs_8)).post();",
                startIdx);

        // Constraint 9 - dppm_vm_0.eq(dppm_vm_9).imp(dppm_vs_0.ne(dppm_vs_9)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(0)).getChocoVar(),"=", ((IntVariable)variableList.get(9)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(12)).getChocoVar(),"!=", ((IntVariable)variableList.get(21)).getChocoVar()));

        addConstraint("Constraint 9 - dppm_vm_0.eq(dppm_vm_9).imp(dppm_vs_0.ne(dppm_vs_9)).post();",
                startIdx);

        // Constraint 10 - dppm_vm_0.eq(dppm_vm_10).imp(dppm_vs_0.ne(dppm_vs_10)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(0)).getChocoVar(),"=", ((IntVariable)variableList.get(10)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(12)).getChocoVar(),"!=", ((IntVariable)variableList.get(22)).getChocoVar()));

        addConstraint("Constraint 10 - dppm_vm_0.eq(dppm_vm_10).imp(dppm_vs_0.ne(dppm_vs_10)).post();",
                startIdx);

        // Constraint 11 - dppm_vm_0.eq(dppm_vm_11).imp(dppm_vs_0.ne(dppm_vs_11)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(0)).getChocoVar(),"=", ((IntVariable)variableList.get(11)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(12)).getChocoVar(),"!=", ((IntVariable)variableList.get(23)).getChocoVar()));

        addConstraint("Constraint 11 - dppm_vm_0.eq(dppm_vm_11).imp(dppm_vs_0.ne(dppm_vs_11)).post();",
                startIdx);

        // Constraint 12 - dppm_vm_1.eq(dppm_vm_2).imp(dppm_vs_1.ne(dppm_vs_2)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(1)).getChocoVar(),"=", ((IntVariable)variableList.get(2)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(13)).getChocoVar(),"!=", ((IntVariable)variableList.get(14)).getChocoVar()));

        addConstraint("Constraint 12 - dppm_vm_1.eq(dppm_vm_2).imp(dppm_vs_1.ne(dppm_vs_2)).post();",
                startIdx);

        // Constraint 13 - dppm_vm_1.eq(dppm_vm_3).imp(dppm_vs_1.ne(dppm_vs_3)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(1)).getChocoVar(),"=", ((IntVariable)variableList.get(3)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(13)).getChocoVar(),"!=", ((IntVariable)variableList.get(15)).getChocoVar()));

        addConstraint("Constraint 13 - dppm_vm_1.eq(dppm_vm_3).imp(dppm_vs_1.ne(dppm_vs_3)).post();",
                startIdx);

        // Constraint 14 - dppm_vm_1.eq(dppm_vm_4).imp(dppm_vs_1.ne(dppm_vs_4)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(1)).getChocoVar(),"=", ((IntVariable)variableList.get(4)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(13)).getChocoVar(),"!=", ((IntVariable)variableList.get(16)).getChocoVar()));

        addConstraint("Constraint 14 - dppm_vm_1.eq(dppm_vm_4).imp(dppm_vs_1.ne(dppm_vs_4)).post();",
                startIdx);

        // Constraint 15 - dppm_vm_1.eq(dppm_vm_5).imp(dppm_vs_1.ne(dppm_vs_5)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(1)).getChocoVar(),"=", ((IntVariable)variableList.get(5)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(13)).getChocoVar(),"!=", ((IntVariable)variableList.get(17)).getChocoVar()));

        addConstraint("Constraint 15 - dppm_vm_1.eq(dppm_vm_5).imp(dppm_vs_1.ne(dppm_vs_5)).post();",
                startIdx);

        // Constraint 16 - dppm_vm_1.eq(dppm_vm_6).imp(dppm_vs_1.ne(dppm_vs_6)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(1)).getChocoVar(),"=", ((IntVariable)variableList.get(6)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(13)).getChocoVar(),"!=", ((IntVariable)variableList.get(18)).getChocoVar()));

        addConstraint("Constraint 16 - dppm_vm_1.eq(dppm_vm_6).imp(dppm_vs_1.ne(dppm_vs_6)).post();",
                startIdx);

        // Constraint 17 - dppm_vm_1.eq(dppm_vm_7).imp(dppm_vs_1.ne(dppm_vs_7)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(1)).getChocoVar(),"=", ((IntVariable)variableList.get(7)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(13)).getChocoVar(),"!=", ((IntVariable)variableList.get(19)).getChocoVar()));

        addConstraint("Constraint 17 - dppm_vm_1.eq(dppm_vm_7).imp(dppm_vs_1.ne(dppm_vs_7)).post();",
                startIdx);

        // Constraint 18 - dppm_vm_1.eq(dppm_vm_8).imp(dppm_vs_1.ne(dppm_vs_8)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(1)).getChocoVar(),"=", ((IntVariable)variableList.get(8)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(13)).getChocoVar(),"!=", ((IntVariable)variableList.get(20)).getChocoVar()));

        addConstraint("Constraint 18 - dppm_vm_1.eq(dppm_vm_8).imp(dppm_vs_1.ne(dppm_vs_8)).post();",
                startIdx);

        // Constraint 19 - dppm_vm_1.eq(dppm_vm_9).imp(dppm_vs_1.ne(dppm_vs_9)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(1)).getChocoVar(),"=", ((IntVariable)variableList.get(9)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(13)).getChocoVar(),"!=", ((IntVariable)variableList.get(21)).getChocoVar()));

        addConstraint("Constraint 19 - dppm_vm_1.eq(dppm_vm_9).imp(dppm_vs_1.ne(dppm_vs_9)).post();",
                startIdx);

        // Constraint 20 - dppm_vm_1.eq(dppm_vm_10).imp(dppm_vs_1.ne(dppm_vs_10)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(1)).getChocoVar(),"=", ((IntVariable)variableList.get(10)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(13)).getChocoVar(),"!=", ((IntVariable)variableList.get(22)).getChocoVar()));

        addConstraint("Constraint 20 - dppm_vm_1.eq(dppm_vm_10).imp(dppm_vs_1.ne(dppm_vs_10)).post();",
                startIdx);

        // Constraint 21 - dppm_vm_1.eq(dppm_vm_11).imp(dppm_vs_1.ne(dppm_vs_11)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(1)).getChocoVar(),"=", ((IntVariable)variableList.get(11)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(13)).getChocoVar(),"!=", ((IntVariable)variableList.get(23)).getChocoVar()));

        addConstraint("Constraint 21 - dppm_vm_1.eq(dppm_vm_11).imp(dppm_vs_1.ne(dppm_vs_11)).post();",
                startIdx);

        // Constraint 22 - dppm_vm_2.eq(dppm_vm_3).imp(dppm_vs_2.ne(dppm_vs_3)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(2)).getChocoVar(),"=", ((IntVariable)variableList.get(3)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(14)).getChocoVar(),"!=", ((IntVariable)variableList.get(15)).getChocoVar()));

        addConstraint("Constraint 22 - dppm_vm_2.eq(dppm_vm_3).imp(dppm_vs_2.ne(dppm_vs_3)).post();",
                startIdx);

        // Constraint 23 - dppm_vm_2.eq(dppm_vm_4).imp(dppm_vs_2.ne(dppm_vs_4)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(2)).getChocoVar(),"=", ((IntVariable)variableList.get(4)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(14)).getChocoVar(),"!=", ((IntVariable)variableList.get(16)).getChocoVar()));

        addConstraint("Constraint 23 - dppm_vm_2.eq(dppm_vm_4).imp(dppm_vs_2.ne(dppm_vs_4)).post();",
                startIdx);

        // Constraint 24 - dppm_vm_2.eq(dppm_vm_5).imp(dppm_vs_2.ne(dppm_vs_5)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(2)).getChocoVar(),"=", ((IntVariable)variableList.get(5)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(14)).getChocoVar(),"!=", ((IntVariable)variableList.get(17)).getChocoVar()));

        addConstraint("Constraint 24 - dppm_vm_2.eq(dppm_vm_5).imp(dppm_vs_2.ne(dppm_vs_5)).post();",
                startIdx);

        // Constraint 25 - dppm_vm_2.eq(dppm_vm_6).imp(dppm_vs_2.ne(dppm_vs_6)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(2)).getChocoVar(),"=", ((IntVariable)variableList.get(6)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(14)).getChocoVar(),"!=", ((IntVariable)variableList.get(18)).getChocoVar()));

        addConstraint("Constraint 25 - dppm_vm_2.eq(dppm_vm_6).imp(dppm_vs_2.ne(dppm_vs_6)).post();",
                startIdx);

        // Constraint 26 - dppm_vm_2.eq(dppm_vm_7).imp(dppm_vs_2.ne(dppm_vs_7)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(2)).getChocoVar(),"=", ((IntVariable)variableList.get(7)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(14)).getChocoVar(),"!=", ((IntVariable)variableList.get(19)).getChocoVar()));

        addConstraint("Constraint 26 - dppm_vm_2.eq(dppm_vm_7).imp(dppm_vs_2.ne(dppm_vs_7)).post();",
                startIdx);

        // Constraint 27 - dppm_vm_2.eq(dppm_vm_8).imp(dppm_vs_2.ne(dppm_vs_8)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(2)).getChocoVar(),"=", ((IntVariable)variableList.get(8)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(14)).getChocoVar(),"!=", ((IntVariable)variableList.get(20)).getChocoVar()));

        addConstraint("Constraint 27 - dppm_vm_2.eq(dppm_vm_8).imp(dppm_vs_2.ne(dppm_vs_8)).post();",
                startIdx);

        // Constraint 28 - dppm_vm_2.eq(dppm_vm_9).imp(dppm_vs_2.ne(dppm_vs_9)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(2)).getChocoVar(),"=", ((IntVariable)variableList.get(9)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(14)).getChocoVar(),"!=", ((IntVariable)variableList.get(21)).getChocoVar()));

        addConstraint("Constraint 28 - dppm_vm_2.eq(dppm_vm_9).imp(dppm_vs_2.ne(dppm_vs_9)).post();",
                startIdx);

        // Constraint 29 - dppm_vm_2.eq(dppm_vm_10).imp(dppm_vs_2.ne(dppm_vs_10)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(2)).getChocoVar(),"=", ((IntVariable)variableList.get(10)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(14)).getChocoVar(),"!=", ((IntVariable)variableList.get(22)).getChocoVar()));

        addConstraint("Constraint 29 - dppm_vm_2.eq(dppm_vm_10).imp(dppm_vs_2.ne(dppm_vs_10)).post();",
                startIdx);

        // Constraint 30 - dppm_vm_2.eq(dppm_vm_11).imp(dppm_vs_2.ne(dppm_vs_11)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(2)).getChocoVar(),"=", ((IntVariable)variableList.get(11)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(14)).getChocoVar(),"!=", ((IntVariable)variableList.get(23)).getChocoVar()));

        addConstraint("Constraint 30 - dppm_vm_2.eq(dppm_vm_11).imp(dppm_vs_2.ne(dppm_vs_11)).post();",
                startIdx);

        // Constraint 31 - dppm_vm_3.eq(dppm_vm_4).imp(dppm_vs_3.ne(dppm_vs_4)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(3)).getChocoVar(),"=", ((IntVariable)variableList.get(4)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(15)).getChocoVar(),"!=", ((IntVariable)variableList.get(16)).getChocoVar()));

        addConstraint("Constraint 31 - dppm_vm_3.eq(dppm_vm_4).imp(dppm_vs_3.ne(dppm_vs_4)).post();",
                startIdx);

        // Constraint 32 - dppm_vm_3.eq(dppm_vm_5).imp(dppm_vs_3.ne(dppm_vs_5)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(3)).getChocoVar(),"=", ((IntVariable)variableList.get(5)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(15)).getChocoVar(),"!=", ((IntVariable)variableList.get(17)).getChocoVar()));

        addConstraint("Constraint 32 - dppm_vm_3.eq(dppm_vm_5).imp(dppm_vs_3.ne(dppm_vs_5)).post();",
                startIdx);

        // Constraint 33 - dppm_vm_3.eq(dppm_vm_6).imp(dppm_vs_3.ne(dppm_vs_6)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(3)).getChocoVar(),"=", ((IntVariable)variableList.get(6)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(15)).getChocoVar(),"!=", ((IntVariable)variableList.get(18)).getChocoVar()));

        addConstraint("Constraint 33 - dppm_vm_3.eq(dppm_vm_6).imp(dppm_vs_3.ne(dppm_vs_6)).post();",
                startIdx);

        // Constraint 34 - dppm_vm_3.eq(dppm_vm_7).imp(dppm_vs_3.ne(dppm_vs_7)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(3)).getChocoVar(),"=", ((IntVariable)variableList.get(7)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(15)).getChocoVar(),"!=", ((IntVariable)variableList.get(19)).getChocoVar()));

        addConstraint("Constraint 34 - dppm_vm_3.eq(dppm_vm_7).imp(dppm_vs_3.ne(dppm_vs_7)).post();",
                startIdx);

        // Constraint 35 - dppm_vm_3.eq(dppm_vm_8).imp(dppm_vs_3.ne(dppm_vs_8)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(3)).getChocoVar(),"=", ((IntVariable)variableList.get(8)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(15)).getChocoVar(),"!=", ((IntVariable)variableList.get(20)).getChocoVar()));

        addConstraint("Constraint 35 - dppm_vm_3.eq(dppm_vm_8).imp(dppm_vs_3.ne(dppm_vs_8)).post();",
                startIdx);

        // Constraint 36 - dppm_vm_3.eq(dppm_vm_9).imp(dppm_vs_3.ne(dppm_vs_9)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(3)).getChocoVar(),"=", ((IntVariable)variableList.get(9)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(15)).getChocoVar(),"!=", ((IntVariable)variableList.get(21)).getChocoVar()));

        addConstraint("Constraint 36 - dppm_vm_3.eq(dppm_vm_9).imp(dppm_vs_3.ne(dppm_vs_9)).post();",
                startIdx);

        // Constraint 37 - dppm_vm_3.eq(dppm_vm_10).imp(dppm_vs_3.ne(dppm_vs_10)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(3)).getChocoVar(),"=", ((IntVariable)variableList.get(10)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(15)).getChocoVar(),"!=", ((IntVariable)variableList.get(22)).getChocoVar()));

        addConstraint("Constraint 37 - dppm_vm_3.eq(dppm_vm_10).imp(dppm_vs_3.ne(dppm_vs_10)).post();",
                startIdx);

        // Constraint 38 - dppm_vm_3.eq(dppm_vm_11).imp(dppm_vs_3.ne(dppm_vs_11)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(3)).getChocoVar(),"=", ((IntVariable)variableList.get(11)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(15)).getChocoVar(),"!=", ((IntVariable)variableList.get(23)).getChocoVar()));

        addConstraint("Constraint 38 - dppm_vm_3.eq(dppm_vm_11).imp(dppm_vs_3.ne(dppm_vs_11)).post();",
                startIdx);

        // Constraint 39 - dppm_vm_4.eq(dppm_vm_5).imp(dppm_vs_4.ne(dppm_vs_5)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(4)).getChocoVar(),"=", ((IntVariable)variableList.get(5)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(16)).getChocoVar(),"!=", ((IntVariable)variableList.get(18)).getChocoVar()));

        addConstraint("Constraint 39 - dppm_vm_4.eq(dppm_vm_5).imp(dppm_vs_4.ne(dppm_vs_5)).post();",
                startIdx);

        // Constraint 40 - dppm_vm_4.eq(dppm_vm_6).imp(dppm_vs_4.ne(dppm_vs_6)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(4)).getChocoVar(),"=", ((IntVariable)variableList.get(6)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(16)).getChocoVar(),"!=", ((IntVariable)variableList.get(19)).getChocoVar()));

        addConstraint("Constraint 40 - dppm_vm_4.eq(dppm_vm_6).imp(dppm_vs_4.ne(dppm_vs_6)).post();",
                startIdx);

        // Constraint 41 - dppm_vm_4.eq(dppm_vm_7).imp(dppm_vs_4.ne(dppm_vs_7)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(4)).getChocoVar(),"=", ((IntVariable)variableList.get(7)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(16)).getChocoVar(),"!=", ((IntVariable)variableList.get(20)).getChocoVar()));

        addConstraint("Constraint 41 - dppm_vm_4.eq(dppm_vm_7).imp(dppm_vs_4.ne(dppm_vs_7)).post();",
                startIdx);

        // Constraint 42 - dppm_vm_4.eq(dppm_vm_8).imp(dppm_vs_4.ne(dppm_vs_8)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(4)).getChocoVar(),"=", ((IntVariable)variableList.get(8)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(16)).getChocoVar(),"!=", ((IntVariable)variableList.get(21)).getChocoVar()));

        addConstraint("Constraint 42 - dppm_vm_4.eq(dppm_vm_8).imp(dppm_vs_4.ne(dppm_vs_8)).post();",
                startIdx);

        // Constraint 43 - dppm_vm_4.eq(dppm_vm_9).imp(dppm_vs_4.ne(dppm_vs_9)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(4)).getChocoVar(),"=", ((IntVariable)variableList.get(9)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(16)).getChocoVar(),"!=", ((IntVariable)variableList.get(22)).getChocoVar()));

        addConstraint("Constraint 43 - dppm_vm_4.eq(dppm_vm_9).imp(dppm_vs_4.ne(dppm_vs_9)).post();",
                startIdx);

        // Constraint 44 - dppm_vm_4.eq(dppm_vm_10).imp(dppm_vs_4.ne(dppm_vs_10)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(4)).getChocoVar(),"=", ((IntVariable)variableList.get(10)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(16)).getChocoVar(),"!=", ((IntVariable)variableList.get(23)).getChocoVar()));

        addConstraint("Constraint 44 - dppm_vm_4.eq(dppm_vm_10).imp(dppm_vs_4.ne(dppm_vs_10)).post();",
                startIdx);

        // Constraint 45 - dppm_vm_4.eq(dppm_vm_11).imp(dppm_vs_4.ne(dppm_vs_11)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(4)).getChocoVar(),"=", ((IntVariable)variableList.get(11)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(16)).getChocoVar(),"!=", ((IntVariable)variableList.get(24)).getChocoVar()));

        addConstraint("Constraint 45 - dppm_vm_4.eq(dppm_vm_11).imp(dppm_vs_4.ne(dppm_vs_11)).post();",
                startIdx);

        // Constraint 46 - dppm_vm_5.eq(dppm_vm_6).imp(dppm_vs_5.ne(dppm_vs_6)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(5)).getChocoVar(),"=", ((IntVariable)variableList.get(6)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(17)).getChocoVar(),"!=", ((IntVariable)variableList.get(19)).getChocoVar()));

        addConstraint("Constraint 46 - dppm_vm_5.eq(dppm_vm_6).imp(dppm_vs_5.ne(dppm_vs_6)).post();",
                startIdx);

        // Constraint 47 - dppm_vm_5.eq(dppm_vm_7).imp(dppm_vs_5.ne(dppm_vs_7)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(5)).getChocoVar(),"=", ((IntVariable)variableList.get(7)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(17)).getChocoVar(),"!=", ((IntVariable)variableList.get(20)).getChocoVar()));

        addConstraint("Constraint 47 - dppm_vm_5.eq(dppm_vm_7).imp(dppm_vs_5.ne(dppm_vs_7)).post();",
                startIdx);

        // Constraint 48 - dppm_vm_5.eq(dppm_vm_8).imp(dppm_vs_5.ne(dppm_vs_8)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(5)).getChocoVar(),"=", ((IntVariable)variableList.get(8)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(17)).getChocoVar(),"!=", ((IntVariable)variableList.get(21)).getChocoVar()));

        addConstraint("Constraint 48 - dppm_vm_5.eq(dppm_vm_8).imp(dppm_vs_5.ne(dppm_vs_8)).post();",
                startIdx);

        // Constraint 49 - dppm_vm_5.eq(dppm_vm_9).imp(dppm_vs_5.ne(dppm_vs_9)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(5)).getChocoVar(),"=", ((IntVariable)variableList.get(9)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(17)).getChocoVar(),"!=", ((IntVariable)variableList.get(22)).getChocoVar()));

        addConstraint("Constraint 49 - dppm_vm_5.eq(dppm_vm_9).imp(dppm_vs_5.ne(dppm_vs_9)).post();",
                startIdx);

        // Constraint 50 - dppm_vm_5.eq(dppm_vm_10).imp(dppm_vs_5.ne(dppm_vs_10)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(5)).getChocoVar(),"=", ((IntVariable)variableList.get(10)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(17)).getChocoVar(),"!=", ((IntVariable)variableList.get(23)).getChocoVar()));

        addConstraint("Constraint 50 - dppm_vm_5.eq(dppm_vm_10).imp(dppm_vs_5.ne(dppm_vs_10)).post();",
                startIdx);

        // Constraint 51 - dppm_vm_5.eq(dppm_vm_11).imp(dppm_vs_5.ne(dppm_vs_11)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(5)).getChocoVar(),"=", ((IntVariable)variableList.get(11)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(17)).getChocoVar(),"!=", ((IntVariable)variableList.get(24)).getChocoVar()));

        addConstraint("Constraint 51 - dppm_vm_5.eq(dppm_vm_11).imp(dppm_vs_5.ne(dppm_vs_11)).post();",
                startIdx);

        // Constraint 52 - dppm_vm_6.eq(dppm_vm_7).imp(dppm_vs_6.ne(dppm_vs_7)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(6)).getChocoVar(),"=", ((IntVariable)variableList.get(7)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(18)).getChocoVar(),"!=", ((IntVariable)variableList.get(20)).getChocoVar()));

        addConstraint("Constraint 52 - dppm_vm_6.eq(dppm_vm_7).imp(dppm_vs_6.ne(dppm_vs_7)).post();",
                startIdx);

        // Constraint 53 - dppm_vm_6.eq(dppm_vm_8).imp(dppm_vs_6.ne(dppm_vs_8)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(6)).getChocoVar(),"=", ((IntVariable)variableList.get(8)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(18)).getChocoVar(),"!=", ((IntVariable)variableList.get(21)).getChocoVar()));

        addConstraint("Constraint 53 - dppm_vm_6.eq(dppm_vm_8).imp(dppm_vs_6.ne(dppm_vs_8)).post();",
                startIdx);

        // Constraint 54 - dppm_vm_6.eq(dppm_vm_9).imp(dppm_vs_6.ne(dppm_vs_9)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(6)).getChocoVar(),"=", ((IntVariable)variableList.get(9)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(18)).getChocoVar(),"!=", ((IntVariable)variableList.get(22)).getChocoVar()));

        addConstraint("Constraint 54 - dppm_vm_6.eq(dppm_vm_9).imp(dppm_vs_6.ne(dppm_vs_9)).post();",
                startIdx);

        // Constraint 55 - dppm_vm_6.eq(dppm_vm_10).imp(dppm_vs_6.ne(dppm_vs_10)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(6)).getChocoVar(),"=", ((IntVariable)variableList.get(10)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(18)).getChocoVar(),"!=", ((IntVariable)variableList.get(23)).getChocoVar()));

        addConstraint("Constraint 55 - dppm_vm_6.eq(dppm_vm_10).imp(dppm_vs_6.ne(dppm_vs_10)).post();",
                startIdx);

        // Constraint 56 - dppm_vm_6.eq(dppm_vm_11).imp(dppm_vs_6.ne(dppm_vs_11)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(6)).getChocoVar(),"=", ((IntVariable)variableList.get(11)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(18)).getChocoVar(),"!=", ((IntVariable)variableList.get(24)).getChocoVar()));

        addConstraint("Constraint 56 - dppm_vm_6.eq(dppm_vm_11).imp(dppm_vs_6.ne(dppm_vs_11)).post();",
                startIdx);

        // Constraint 57 - dppm_vm_7.eq(dppm_vm_8).imp(dppm_vs_7.ne(dppm_vs_8)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"=", ((IntVariable)variableList.get(8)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(20)).getChocoVar(),"!=", ((IntVariable)variableList.get(21)).getChocoVar()));

        addConstraint("Constraint 57 - dppm_vm_7.eq(dppm_vm_8).imp(dppm_vs_7.ne(dppm_vs_8)).post();",
                startIdx);

        // Constraint 58 - dppm_vm_7.eq(dppm_vm_9).imp(dppm_vs_7.ne(dppm_vs_9)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"=", ((IntVariable)variableList.get(9)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(20)).getChocoVar(),"!=", ((IntVariable)variableList.get(22)).getChocoVar()));

        addConstraint("Constraint 58 - dppm_vm_7.eq(dppm_vm_9).imp(dppm_vs_7.ne(dppm_vs_9)).post();",
                startIdx);

        // Constraint 59 - dppm_vm_7.eq(dppm_vm_10).imp(dppm_vs_7.ne(dppm_vs_10)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"=", ((IntVariable)variableList.get(10)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(20)).getChocoVar(),"!=", ((IntVariable)variableList.get(23)).getChocoVar()));

        addConstraint("Constraint 59 - dppm_vm_7.eq(dppm_vm_10).imp(dppm_vs_7.ne(dppm_vs_10)).post();",
                startIdx);

        // Constraint 60 - dppm_vm_7.eq(dppm_vm_11).imp(dppm_vs_7.ne(dppm_vs_11)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"=", ((IntVariable)variableList.get(11)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(20)).getChocoVar(),"!=", ((IntVariable)variableList.get(24)).getChocoVar()));

        addConstraint("Constraint 60 - dppm_vm_7.eq(dppm_vm_11).imp(dppm_vs_7.ne(dppm_vs_11)).post();",
                startIdx);

        // Constraint 61 - dppm_vm_8.eq(dppm_vm_9).imp(dppm_vs_8.ne(dppm_vs_9)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"=", ((IntVariable)variableList.get(9)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(21)).getChocoVar(),"!=", ((IntVariable)variableList.get(22)).getChocoVar()));

        addConstraint("Constraint 61 - dppm_vm_8.eq(dppm_vm_9).imp(dppm_vs_8.ne(dppm_vs_9)).post();",
                startIdx);

        // Constraint 62 - dppm_vm_8.eq(dppm_vm_10).imp(dppm_vs_8.ne(dppm_vs_10)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"=", ((IntVariable)variableList.get(10)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(21)).getChocoVar(),"!=", ((IntVariable)variableList.get(23)).getChocoVar()));

        addConstraint("Constraint 62 - dppm_vm_8.eq(dppm_vm_10).imp(dppm_vs_8.ne(dppm_vs_10)).post();",
                startIdx);

        // Constraint 63 - dppm_vm_8.eq(dppm_vm_11).imp(dppm_vs_8.ne(dppm_vs_11)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"=", ((IntVariable)variableList.get(11)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(21)).getChocoVar(),"!=", ((IntVariable)variableList.get(24)).getChocoVar()));

        addConstraint("Constraint 63 - dppm_vm_8.eq(dppm_vm_11).imp(dppm_vs_8.ne(dppm_vs_11)).post();",
                startIdx);

        // Constraint 64 - dppm_vm_9.eq(dppm_vm_10).imp(dppm_vs_9.ne(dppm_vs_10)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(9)).getChocoVar(),"=", ((IntVariable)variableList.get(10)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(22)).getChocoVar(),"!=", ((IntVariable)variableList.get(23)).getChocoVar()));

        addConstraint("Constraint 64 - dppm_vm_9.eq(dppm_vm_10).imp(dppm_vs_9.ne(dppm_vs_10)).post();",
                startIdx);

        // Constraint 65 - dppm_vm_9.eq(dppm_vm_11).imp(dppm_vs_9.ne(dppm_vs_11)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(9)).getChocoVar(),"=", ((IntVariable)variableList.get(11)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(22)).getChocoVar(),"!=", ((IntVariable)variableList.get(24)).getChocoVar()));

        addConstraint("Constraint 65 - dppm_vm_9.eq(dppm_vm_11).imp(dppm_vs_9.ne(dppm_vs_11)).post();",
                startIdx);

        // Constraint 66 - dppm_vm_10.eq(dppm_vm_11).imp(dppm_vs_10.ne(dppm_vs_11)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(10)).getChocoVar(),"=", ((IntVariable)variableList.get(11)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(23)).getChocoVar(),"!=", ((IntVariable)variableList.get(24)).getChocoVar()));

        addConstraint("Constraint 66 - dppm_vm_10.eq(dppm_vm_11).imp(dppm_vs_10.ne(dppm_vs_11)).post();",
                startIdx);
    }

    private void constraintGroup2() {
        int startIdx = modelKB.getNbCstrs();
        // Constraint 67 - dppm_vs_0.ne(dppm_vs_1).post();
        modelKB.arithm(((IntVariable)variableList.get(12)).getChocoVar(),"!=", ((IntVariable)variableList.get(13)).getChocoVar()).post();

        addConstraint("Constraint 67 - dppm_vs_0.ne(dppm_vs_1).post();",
                startIdx);

        // Constraint 68 - dppm_vs_0.ne(dppm_vs_2).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(12)).getChocoVar(),"!=", ((IntVariable)variableList.get(14)).getChocoVar()).post();

        addConstraint("Constraint 68 - dppm_vs_0.ne(dppm_vs_2).post();",
                startIdx);

        // Constraint 69 - dppm_vs_0.ne(dppm_vs_3).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(12)).getChocoVar(),"!=", ((IntVariable)variableList.get(15)).getChocoVar()).post();

        addConstraint("Constraint 69 - dppm_vs_0.ne(dppm_vs_3).post();",
                startIdx);

        // Constraint 70 - dppm_vs_0.ne(dppm_vs_4).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(12)).getChocoVar(),"!=", ((IntVariable)variableList.get(16)).getChocoVar()).post();

        addConstraint("Constraint 70 - dppm_vs_0.ne(dppm_vs_4).post();",
                startIdx);

        // Constraint 71 - dppm_vs_0.ne(dppm_vs_5).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(12)).getChocoVar(),"!=", ((IntVariable)variableList.get(17)).getChocoVar()).post();

        addConstraint("Constraint 71 - dppm_vs_0.ne(dppm_vs_5).post();",
                startIdx);

        // Constraint 72 - dppm_vs_0.ne(dppm_vs_6).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(12)).getChocoVar(),"!=", ((IntVariable)variableList.get(18)).getChocoVar()).post();

        addConstraint("Constraint 72 - dppm_vs_0.ne(dppm_vs_6).post();",
                startIdx);

        // Constraint 73 - dppm_vs_0.ne(dppm_vs_7).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(12)).getChocoVar(),"!=", ((IntVariable)variableList.get(19)).getChocoVar()).post();

        addConstraint("Constraint 73 - dppm_vs_0.ne(dppm_vs_7).post();",
                startIdx);

        // Constraint 74 - dppm_vs_0.ne(dppm_vs_8).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(12)).getChocoVar(),"!=", ((IntVariable)variableList.get(20)).getChocoVar()).post();

        addConstraint("Constraint 74 - dppm_vs_0.ne(dppm_vs_8).post();",
                startIdx);

        // Constraint 75 - dppm_vs_0.ne(dppm_vs_9).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(12)).getChocoVar(),"!=", ((IntVariable)variableList.get(21)).getChocoVar()).post();

        addConstraint("Constraint 75 - dppm_vs_0.ne(dppm_vs_9).post();",
                startIdx);

        // Constraint 76 - dppm_vs_0.ne(dppm_vs_10).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(12)).getChocoVar(),"!=", ((IntVariable)variableList.get(22)).getChocoVar()).post();

        addConstraint("Constraint 76 - dppm_vs_0.ne(dppm_vs_10).post();",
                startIdx);

        // Constraint 77 - dppm_vs_0.ne(dppm_vs_11).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(12)).getChocoVar(),"!=", ((IntVariable)variableList.get(23)).getChocoVar()).post();

        addConstraint("Constraint 77 - dppm_vs_0.ne(dppm_vs_11).post();",
                startIdx);

        // Constraint 78 - dppm_vs_1.ne(dppm_vs_2).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(13)).getChocoVar(),"!=", ((IntVariable)variableList.get(14)).getChocoVar()).post();

        addConstraint("Constraint 78 - dppm_vs_1.ne(dppm_vs_2).post();",
                startIdx);

        // Constraint 79 - dppm_vs_1.ne(dppm_vs_3).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(13)).getChocoVar(),"!=", ((IntVariable)variableList.get(15)).getChocoVar()).post();

        addConstraint("Constraint 79 - dppm_vs_1.ne(dppm_vs_3).post();",
                startIdx);

        // Constraint 80 - dppm_vs_1.ne(dppm_vs_4).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(13)).getChocoVar(),"!=", ((IntVariable)variableList.get(16)).getChocoVar()).post();

        addConstraint("Constraint 80 - dppm_vs_1.ne(dppm_vs_4).post();",
                startIdx);

        // Constraint 81 - dppm_vs_1.ne(dppm_vs_5).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(13)).getChocoVar(),"!=", ((IntVariable)variableList.get(17)).getChocoVar()).post();

        addConstraint("Constraint 81 - dppm_vs_1.ne(dppm_vs_5).post();",
                startIdx);

        // Constraint 82 - dppm_vs_1.ne(dppm_vs_6).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(13)).getChocoVar(),"!=", ((IntVariable)variableList.get(18)).getChocoVar()).post();

        addConstraint("Constraint 82 - dppm_vs_1.ne(dppm_vs_6).post();",
                startIdx);

        // Constraint 83 - dppm_vs_1.ne(dppm_vs_7).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(13)).getChocoVar(),"!=", ((IntVariable)variableList.get(19)).getChocoVar()).post();

        addConstraint("Constraint 83 - dppm_vs_1.ne(dppm_vs_7).post();",
                startIdx);

        // Constraint 84 - dppm_vs_1.ne(dppm_vs_8).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(13)).getChocoVar(),"!=", ((IntVariable)variableList.get(20)).getChocoVar()).post();

        addConstraint("Constraint 84 - dppm_vs_1.ne(dppm_vs_8).post();",
                startIdx);

        // Constraint 85 - dppm_vs_1.ne(dppm_vs_9).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(13)).getChocoVar(),"!=", ((IntVariable)variableList.get(21)).getChocoVar()).post();

        addConstraint("Constraint 85 - dppm_vs_1.ne(dppm_vs_9).post();",
                startIdx);

        // Constraint 86 - dppm_vs_1.ne(dppm_vs_10).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(13)).getChocoVar(),"!=", ((IntVariable)variableList.get(22)).getChocoVar()).post();

        addConstraint("Constraint 86 - dppm_vs_1.ne(dppm_vs_10).post();",
                startIdx);

        // Constraint 87 - dppm_vs_1.ne(dppm_vs_11).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(13)).getChocoVar(),"!=", ((IntVariable)variableList.get(23)).getChocoVar()).post();

        addConstraint("Constraint 87 - dppm_vs_1.ne(dppm_vs_11).post();",
                startIdx);

        // Constraint 88 - dppm_vs_2.ne(dppm_vs_3).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(14)).getChocoVar(),"!=", ((IntVariable)variableList.get(15)).getChocoVar()).post();

        addConstraint("Constraint 88 - dppm_vs_2.ne(dppm_vs_3).post();",
                startIdx);

        // Constraint 89 - dppm_vs_2.ne(dppm_vs_4).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(14)).getChocoVar(),"!=", ((IntVariable)variableList.get(16)).getChocoVar()).post();

        addConstraint("Constraint 89 - dppm_vs_2.ne(dppm_vs_4).post();",
                startIdx);

        // Constraint 90 - dppm_vs_2.ne(dppm_vs_5).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(14)).getChocoVar(),"!=", ((IntVariable)variableList.get(17)).getChocoVar()).post();

        addConstraint("Constraint 90 - dppm_vs_2.ne(dppm_vs_5).post();",
                startIdx);

        // Constraint 91 - dppm_vs_2.ne(dppm_vs_6).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(14)).getChocoVar(),"!=", ((IntVariable)variableList.get(18)).getChocoVar()).post();

        addConstraint("Constraint 91 - dppm_vs_2.ne(dppm_vs_6).post();",
                startIdx);

        // Constraint 92 - dppm_vs_2.ne(dppm_vs_7).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(14)).getChocoVar(),"!=", ((IntVariable)variableList.get(19)).getChocoVar()).post();

        addConstraint("Constraint 92 - dppm_vs_2.ne(dppm_vs_7).post();",
                startIdx);

        // Constraint 93 - dppm_vs_2.ne(dppm_vs_8).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(14)).getChocoVar(),"!=", ((IntVariable)variableList.get(20)).getChocoVar()).post();

        addConstraint("Constraint 93 - dppm_vs_2.ne(dppm_vs_8).post();",
                startIdx);

        // Constraint 94 - dppm_vs_2.ne(dppm_vs_9).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(14)).getChocoVar(),"!=", ((IntVariable)variableList.get(21)).getChocoVar()).post();

        addConstraint("Constraint 94 - dppm_vs_2.ne(dppm_vs_9).post();",
                startIdx);

        // Constraint 95 - dppm_vs_2.ne(dppm_vs_10).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(14)).getChocoVar(),"!=", ((IntVariable)variableList.get(22)).getChocoVar()).post();

        addConstraint("Constraint 95 - dppm_vs_2.ne(dppm_vs_10).post();",
                startIdx);

        // Constraint 96 - dppm_vs_2.ne(dppm_vs_11).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(14)).getChocoVar(),"!=", ((IntVariable)variableList.get(23)).getChocoVar()).post();

        addConstraint("Constraint 96 - dppm_vs_2.ne(dppm_vs_11).post();",
                startIdx);

        // Constraint 97 - dppm_vs_3.ne(dppm_vs_4).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(15)).getChocoVar(),"!=", ((IntVariable)variableList.get(16)).getChocoVar()).post();

        addConstraint("Constraint 97 - dppm_vs_3.ne(dppm_vs_4).post();",
                startIdx);

        // Constraint 98 - dppm_vs_3.ne(dppm_vs_5).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(15)).getChocoVar(),"!=", ((IntVariable)variableList.get(17)).getChocoVar()).post();

        addConstraint("Constraint 98 - dppm_vs_3.ne(dppm_vs_5).post();",
                startIdx);

        // Constraint 99 - dppm_vs_3.ne(dppm_vs_6).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(15)).getChocoVar(),"!=", ((IntVariable)variableList.get(18)).getChocoVar()).post();

        addConstraint("Constraint 99 - dppm_vs_3.ne(dppm_vs_6).post();",
                startIdx);

        // Constraint 100 - dppm_vs_3.ne(dppm_vs_7).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(15)).getChocoVar(),"!=", ((IntVariable)variableList.get(19)).getChocoVar()).post();

        addConstraint("Constraint 100 - dppm_vs_3.ne(dppm_vs_7).post();",
                startIdx);

        // Constraint 101 - dppm_vs_3.ne(dppm_vs_8).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(15)).getChocoVar(),"!=", ((IntVariable)variableList.get(20)).getChocoVar()).post();

        addConstraint("Constraint 101 - dppm_vs_3.ne(dppm_vs_8).post();",
                startIdx);

        // Constraint 102 - dppm_vs_3.ne(dppm_vs_9).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(15)).getChocoVar(),"!=", ((IntVariable)variableList.get(21)).getChocoVar()).post();

        addConstraint("Constraint 102 - dppm_vs_3.ne(dppm_vs_9).post();",
                startIdx);

        // Constraint 103 - dppm_vs_3.ne(dppm_vs_10).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(15)).getChocoVar(),"!=", ((IntVariable)variableList.get(22)).getChocoVar()).post();

        addConstraint("Constraint 103 - dppm_vs_3.ne(dppm_vs_10).post();",
                startIdx);

        // Constraint 104 - dppm_vs_3.ne(dppm_vs_11).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(15)).getChocoVar(),"!=", ((IntVariable)variableList.get(23)).getChocoVar()).post();

        addConstraint("Constraint 104 - dppm_vs_3.ne(dppm_vs_11).post();",
                startIdx);

        // Constraint 105 - dppm_vs_4.ne(dppm_vs_5).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(16)).getChocoVar(),"!=", ((IntVariable)variableList.get(17)).getChocoVar()).post();

        addConstraint("Constraint 105 - dppm_vs_4.ne(dppm_vs_5).post();",
                startIdx);

        // Constraint 106 - dppm_vs_4.ne(dppm_vs_6).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(16)).getChocoVar(),"!=", ((IntVariable)variableList.get(18)).getChocoVar()).post();

        addConstraint("Constraint 106 - dppm_vs_4.ne(dppm_vs_6).post();",
                startIdx);

        // Constraint 107 - dppm_vs_4.ne(dppm_vs_7).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(16)).getChocoVar(),"!=", ((IntVariable)variableList.get(19)).getChocoVar()).post();

        addConstraint("Constraint 107 - dppm_vs_4.ne(dppm_vs_7).post();",
                startIdx);

        // Constraint 108 - dppm_vs_4.ne(dppm_vs_8).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(16)).getChocoVar(),"!=", ((IntVariable)variableList.get(20)).getChocoVar()).post();

        addConstraint("Constraint 108 - dppm_vs_4.ne(dppm_vs_8).post();",
                startIdx);

        // Constraint 109 - dppm_vs_4.ne(dppm_vs_9).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(16)).getChocoVar(),"!=", ((IntVariable)variableList.get(21)).getChocoVar()).post();

        addConstraint("Constraint 109 - dppm_vs_4.ne(dppm_vs_9).post();",
                startIdx);

        // Constraint 110 - dppm_vs_4.ne(dppm_vs_10).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(16)).getChocoVar(),"!=", ((IntVariable)variableList.get(22)).getChocoVar()).post();

        addConstraint("Constraint 110 - dppm_vs_4.ne(dppm_vs_10).post();",
                startIdx);

        // Constraint 111 - dppm_vs_4.ne(dppm_vs_11).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(16)).getChocoVar(),"!=", ((IntVariable)variableList.get(23)).getChocoVar()).post();

        addConstraint("Constraint 111 - dppm_vs_4.ne(dppm_vs_11).post();",
                startIdx);

        // Constraint 112 - dppm_vs_5.ne(dppm_vs_6).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(17)).getChocoVar(),"!=", ((IntVariable)variableList.get(18)).getChocoVar()).post();

        addConstraint("Constraint 112 - dppm_vs_5.ne(dppm_vs_6).post();",
                startIdx);

        // Constraint 113 - dppm_vs_5.ne(dppm_vs_7).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(17)).getChocoVar(),"!=", ((IntVariable)variableList.get(19)).getChocoVar()).post();

        addConstraint("Constraint 113 - dppm_vs_5.ne(dppm_vs_7).post();",
                startIdx);

        // Constraint 114 - dppm_vs_5.ne(dppm_vs_8).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(17)).getChocoVar(),"!=", ((IntVariable)variableList.get(20)).getChocoVar()).post();

        addConstraint("Constraint 114 - dppm_vs_5.ne(dppm_vs_8).post();",
                startIdx);

        // Constraint 115 - dppm_vs_5.ne(dppm_vs_9).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(17)).getChocoVar(),"!=", ((IntVariable)variableList.get(21)).getChocoVar()).post();

        addConstraint("Constraint 115 - dppm_vs_5.ne(dppm_vs_9).post();",
                startIdx);

        // Constraint 116 - dppm_vs_5.ne(dppm_vs_10).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(17)).getChocoVar(),"!=", ((IntVariable)variableList.get(22)).getChocoVar()).post();

        addConstraint("Constraint 116 - dppm_vs_5.ne(dppm_vs_10).post();",
                startIdx);

        // Constraint 117 - dppm_vs_5.ne(dppm_vs_11).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(17)).getChocoVar(),"!=", ((IntVariable)variableList.get(23)).getChocoVar()).post();

        addConstraint("Constraint 117 - dppm_vs_5.ne(dppm_vs_11).post();",
                startIdx);

        // Constraint 118 - dppm_vs_6.ne(dppm_vs_7).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(18)).getChocoVar(),"!=", ((IntVariable)variableList.get(19)).getChocoVar()).post();

        addConstraint("Constraint 118 - dppm_vs_6.ne(dppm_vs_7).post();",
                startIdx);

        // Constraint 119 - dppm_vs_6.ne(dppm_vs_8).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(18)).getChocoVar(),"!=", ((IntVariable)variableList.get(20)).getChocoVar()).post();

        addConstraint("Constraint 119 - dppm_vs_6.ne(dppm_vs_8).post();",
                startIdx);

        // Constraint 120 - dppm_vs_6.ne(dppm_vs_9).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(18)).getChocoVar(),"!=", ((IntVariable)variableList.get(21)).getChocoVar()).post();

        addConstraint("Constraint 120 - dppm_vs_6.ne(dppm_vs_9).post();",
                startIdx);

        // Constraint 121 - dppm_vs_6.ne(dppm_vs_10).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(18)).getChocoVar(),"!=", ((IntVariable)variableList.get(22)).getChocoVar()).post();

        addConstraint("Constraint 121 - dppm_vs_6.ne(dppm_vs_10).post();",
                startIdx);

        // Constraint 122 - dppm_vs_6.ne(dppm_vs_11).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(18)).getChocoVar(),"!=", ((IntVariable)variableList.get(23)).getChocoVar()).post();

        addConstraint("Constraint 122 - dppm_vs_6.ne(dppm_vs_11).post();",
                startIdx);

        // Constraint 123 - dppm_vs_7.ne(dppm_vs_8).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(19)).getChocoVar(),"!=", ((IntVariable)variableList.get(20)).getChocoVar()).post();

        addConstraint("Constraint 123 - dppm_vs_7.ne(dppm_vs_8).post();",
                startIdx);

        // Constraint 124 - dppm_vs_7.ne(dppm_vs_9).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(19)).getChocoVar(),"!=", ((IntVariable)variableList.get(21)).getChocoVar()).post();

        addConstraint("Constraint 124 - dppm_vs_7.ne(dppm_vs_9).post();",
                startIdx);

        // Constraint 125 - dppm_vs_7.ne(dppm_vs_10).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(19)).getChocoVar(),"!=", ((IntVariable)variableList.get(22)).getChocoVar()).post();

        addConstraint("Constraint 125 - dppm_vs_7.ne(dppm_vs_10).post();",
                startIdx);

        // Constraint 126 - dppm_vs_7.ne(dppm_vs_11).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(19)).getChocoVar(),"!=", ((IntVariable)variableList.get(23)).getChocoVar()).post();

        addConstraint("Constraint 126 - dppm_vs_7.ne(dppm_vs_11).post();",
                startIdx);

        // Constraint 127 - dppm_vs_8.ne(dppm_vs_9).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(20)).getChocoVar(),"!=", ((IntVariable)variableList.get(21)).getChocoVar()).post();

        addConstraint("Constraint 127 - dppm_vs_8.ne(dppm_vs_9).post();",
                startIdx);

        // Constraint 128 - dppm_vs_8.ne(dppm_vs_10).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(20)).getChocoVar(),"!=", ((IntVariable)variableList.get(22)).getChocoVar()).post();

        addConstraint("Constraint 128 - dppm_vs_8.ne(dppm_vs_10).post();",
                startIdx);

        // Constraint 129 - dppm_vs_8.ne(dppm_vs_11).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(20)).getChocoVar(),"!=", ((IntVariable)variableList.get(23)).getChocoVar()).post();

        addConstraint("Constraint 129 - dppm_vs_8.ne(dppm_vs_11).post();",
                startIdx);

        // Constraint 130 - dppm_vs_9.ne(dppm_vs_10).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(21)).getChocoVar(),"!=", ((IntVariable)variableList.get(22)).getChocoVar()).post();

        addConstraint("Constraint 130 - dppm_vs_9.ne(dppm_vs_10).post();",
                startIdx);

        // Constraint 131 - dppm_vs_9.ne(dppm_vs_11).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(21)).getChocoVar(),"!=", ((IntVariable)variableList.get(23)).getChocoVar()).post();

        addConstraint("Constraint 131 - dppm_vs_9.ne(dppm_vs_11).post();",
                startIdx);

        // Constraint 132 - dppm_vs_10.ne(dppm_vs_11).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(22)).getChocoVar(),"!=", ((IntVariable)variableList.get(23)).getChocoVar()).post();

        addConstraint("Constraint 132 - dppm_vs_10.ne(dppm_vs_11).post();",
                startIdx);
    }

    private void constraintGroup3() {
        // Constraint 133 - m.arithm(dppm_vs_0, "<", dppm_vs_1).post();
        int startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(12)).getChocoVar(),"<", ((IntVariable)variableList.get(13)).getChocoVar()).post();

        addConstraint("Constraint 133 - m.arithm(dppm_vs_0, \"<\", dppm_vs_1).post();",
                startIdx);

        // Constraint 134 - m.arithm(dppm_vs_0, "<", dppm_vs_2).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(12)).getChocoVar(),"<", ((IntVariable)variableList.get(14)).getChocoVar()).post();

        addConstraint("Constraint 134 - m.arithm(dppm_vs_0, \"<\", dppm_vs_2).post();",
                startIdx);

        // Constraint 135 - m.arithm(dppm_vs_1, "<", dppm_vs_3).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(13)).getChocoVar(),"<", ((IntVariable)variableList.get(15)).getChocoVar()).post();

        addConstraint("Constraint 135 - m.arithm(dppm_vs_1, \"<\", dppm_vs_3).post();",
                startIdx);

        // Constraint 136 - m.arithm(dppm_vs_2, "<", dppm_vs_3).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(14)).getChocoVar(),"<", ((IntVariable)variableList.get(15)).getChocoVar()).post();

        addConstraint("Constraint 136 - m.arithm(dppm_vs_2, \"<\", dppm_vs_3).post();",
                startIdx);

        // Constraint 137 - m.arithm(dppm_vs_1, "<", dppm_vs_4).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(13)).getChocoVar(),"<", ((IntVariable)variableList.get(16)).getChocoVar()).post();

        addConstraint("Constraint 137 - m.arithm(dppm_vs_1, \"<\", dppm_vs_4).post();",
                startIdx);

        // Constraint 138 - m.arithm(dppm_vs_2, "<", dppm_vs_4).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(14)).getChocoVar(),"<", ((IntVariable)variableList.get(16)).getChocoVar()).post();

        addConstraint("Constraint 138 - m.arithm(dppm_vs_2, \"<\", dppm_vs_4).post();",
                startIdx);

        // Constraint 139 - m.arithm(dppm_vs_1, "<", dppm_vs_5).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(13)).getChocoVar(),"<", ((IntVariable)variableList.get(17)).getChocoVar()).post();

        addConstraint("Constraint 139 - m.arithm(dppm_vs_1, \"<\", dppm_vs_5).post();",
                startIdx);

        // Constraint 140 - m.arithm(dppm_vs_2, "<", dppm_vs_5).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(14)).getChocoVar(),"<", ((IntVariable)variableList.get(17)).getChocoVar()).post();

        addConstraint("Constraint 140 - m.arithm(dppm_vs_2, \"<\", dppm_vs_5).post();",
                startIdx);

        // Constraint 141 - m.arithm(dppm_vs_1, "<", dppm_vs_6).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(13)).getChocoVar(),"<", ((IntVariable)variableList.get(18)).getChocoVar()).post();

        addConstraint("Constraint 141 - m.arithm(dppm_vs_1, \"<\", dppm_vs_6).post();",
                startIdx);

        // Constraint 142 - m.arithm(dppm_vs_2, "<", dppm_vs_6).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(14)).getChocoVar(),"<", ((IntVariable)variableList.get(18)).getChocoVar()).post();

        addConstraint("Constraint 142 - m.arithm(dppm_vs_2, \"<\", dppm_vs_6).post();",
                startIdx);

        // Constraint 143 - m.arithm(dppm_vs_3, "<", dppm_vs_7).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(15)).getChocoVar(),"<", ((IntVariable)variableList.get(19)).getChocoVar()).post();

        addConstraint("Constraint 143 - m.arithm(dppm_vs_3, \"<\", dppm_vs_7).post();",
                startIdx);

        // Constraint 144 - m.arithm(dppm_vs_4, "<", dppm_vs_7).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(16)).getChocoVar(),"<", ((IntVariable)variableList.get(19)).getChocoVar()).post();

        addConstraint("Constraint 144 - m.arithm(dppm_vs_4, \"<\", dppm_vs_7).post();",
                startIdx);

        // Constraint 145 - m.arithm(dppm_vs_5, "<", dppm_vs_7).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(17)).getChocoVar(),"<", ((IntVariable)variableList.get(19)).getChocoVar()).post();

        addConstraint("Constraint 145 - m.arithm(dppm_vs_5, \"<\", dppm_vs_7).post();",
                startIdx);

        // Constraint 146 - m.arithm(dppm_vs_6, "<", dppm_vs_7).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(18)).getChocoVar(),"<", ((IntVariable)variableList.get(19)).getChocoVar()).post();

        addConstraint("Constraint 146 - m.arithm(dppm_vs_6, \"<\", dppm_vs_7).post();",
                startIdx);

        // Constraint 147 - m.arithm(dppm_vs_3, "<", dppm_vs_8).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(15)).getChocoVar(),"<", ((IntVariable)variableList.get(20)).getChocoVar()).post();

        addConstraint("Constraint 147 - m.arithm(dppm_vs_3, \"<\", dppm_vs_8).post();",
                startIdx);

        // Constraint 148 - m.arithm(dppm_vs_4, "<", dppm_vs_8).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(16)).getChocoVar(),"<", ((IntVariable)variableList.get(20)).getChocoVar()).post();

        addConstraint("Constraint 148 - m.arithm(dppm_vs_4, \"<\", dppm_vs_8).post();",
                startIdx);

        // Constraint 149 - m.arithm(dppm_vs_5, "<", dppm_vs_8).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(17)).getChocoVar(),"<", ((IntVariable)variableList.get(20)).getChocoVar()).post();

        addConstraint("Constraint 149 - m.arithm(dppm_vs_5, \"<\", dppm_vs_8).post();",
                startIdx);

        // Constraint 150 - m.arithm(dppm_vs_6, "<", dppm_vs_8).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(18)).getChocoVar(),"<", ((IntVariable)variableList.get(20)).getChocoVar()).post();

        addConstraint("Constraint 150 - m.arithm(dppm_vs_6, \"<\", dppm_vs_8).post();",
                startIdx);

        // Constraint 151 - m.arithm(dppm_vs_3, "<", dppm_vs_9).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(15)).getChocoVar(),"<", ((IntVariable)variableList.get(21)).getChocoVar()).post();

        addConstraint("Constraint 151 - m.arithm(dppm_vs_3, \"<\", dppm_vs_9).post();",
                startIdx);

        // Constraint 152 - m.arithm(dppm_vs_4, "<", dppm_vs_9).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(16)).getChocoVar(),"<", ((IntVariable)variableList.get(21)).getChocoVar()).post();

        addConstraint("Constraint 152 - m.arithm(dppm_vs_4, \"<\", dppm_vs_9).post();",
                startIdx);

        // Constraint 153 - m.arithm(dppm_vs_5, "<", dppm_vs_9).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(17)).getChocoVar(),"<", ((IntVariable)variableList.get(21)).getChocoVar()).post();

        addConstraint("Constraint 153 - m.arithm(dppm_vs_5, \"<\", dppm_vs_9).post();",
                startIdx);

        // Constraint 154 - m.arithm(dppm_vs_6, "<", dppm_vs_9).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(18)).getChocoVar(),"<", ((IntVariable)variableList.get(21)).getChocoVar()).post();

        addConstraint("Constraint 154 - m.arithm(dppm_vs_6, \"<\", dppm_vs_9).post();",
                startIdx);

        // Constraint 155 - m.arithm(dppm_vs_7, "<", dppm_vs_10).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(19)).getChocoVar(),"<", ((IntVariable)variableList.get(22)).getChocoVar()).post();

        addConstraint("Constraint 155 - m.arithm(dppm_vs_7, \"<\", dppm_vs_10).post();",
                startIdx);

        // Constraint 156 - m.arithm(dppm_vs_8, "<", dppm_vs_10).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(20)).getChocoVar(),"<", ((IntVariable)variableList.get(22)).getChocoVar()).post();

        addConstraint("Constraint 156 - m.arithm(dppm_vs_8, \"<\", dppm_vs_10).post();",
                startIdx);

        // Constraint 157 - m.arithm(dppm_vs_9, "<", dppm_vs_10).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(21)).getChocoVar(),"<", ((IntVariable)variableList.get(22)).getChocoVar()).post();

        addConstraint("Constraint 157 - m.arithm(dppm_vs_9, \"<\", dppm_vs_10).post();",
                startIdx);

        // Constraint 158 - m.arithm(dppm_vs_10, "<", dppm_vs_11).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(22)).getChocoVar(),"<", ((IntVariable)variableList.get(23)).getChocoVar()).post();

        addConstraint("Constraint 158 - m.arithm(dppm_vs_10, \"<\", dppm_vs_11).post();",
                startIdx);
    }

    private void constraintGroup4() {
        // Constraint 159 - m.max(dppm_vmakespan, vs_array).post();
        int startIdx = modelKB.getNbCstrs();
        IntVar[] vs_array = new IntVar[]{((IntVariable)variableList.get(12)).getChocoVar(),
                ((IntVariable)variableList.get(13)).getChocoVar(),
                ((IntVariable)variableList.get(14)).getChocoVar(),
                ((IntVariable)variableList.get(15)).getChocoVar(),
                ((IntVariable)variableList.get(16)).getChocoVar(),
                ((IntVariable)variableList.get(17)).getChocoVar(),
                ((IntVariable)variableList.get(18)).getChocoVar(),
                ((IntVariable)variableList.get(19)).getChocoVar(),
                ((IntVariable)variableList.get(20)).getChocoVar(),
                ((IntVariable)variableList.get(21)).getChocoVar(),
                ((IntVariable)variableList.get(22)).getChocoVar(),
                ((IntVariable)variableList.get(23)).getChocoVar()};
        modelKB.max(((IntVariable)variableList.get(24)).getChocoVar(), vs_array).post();

        addConstraint("Constraint 159 - m.max(dppm_vmakespan, vs_array).post();",
                startIdx);

        // Constraint 160 - dppm_vmakespan.le(5).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(24)).getChocoVar(), ">=", 5).post();

        addConstraint("Constraint 160 - dppm_vmakespan.le(5).post();",
                startIdx);

    }

    private void addConstraint(String constraintName, int startIdx) {
        org.chocosolver.solver.constraints.Constraint negChocoConstraint = null;

        Constraint constraint = new Constraint(constraintName);
        constraint.addChocoConstraints(modelKB, startIdx, modelKB.getNbCstrs() - 1, hasNegativeConstraints);
        constraintList.add(constraint);
    }

    @Override
    public IntVar[] getIntVars() {
        org.chocosolver.solver.variables.Variable[] vars = getModelKB().getVars();

        return Arrays.stream(vars).map(v -> (IntVar) v).toArray(IntVar[]::new);
    }

    @Override
    public IntVar getIntVar(@NonNull String variable) {
        Variable var = getVariable(variable);

        return ((IntVariable) var).getChocoVar();
    }

    @Override
    public BoolVar[] getBoolVars() {
        throw new UnsupportedOperationException("Not supported by this knowledge base.");
    }

    @Override
    public BoolVar getBoolVar(@NonNull String variable) {
        throw new UnsupportedOperationException("Not supported by this knowledge base.");
    }

    // Choco value
    @Override
    public int getIntValue(@NonNull String var, @NonNull String value) {
        Domain domain = getDomain(var);

        return domain.getChocoValue(value);
    }

    @Override
    public boolean getBoolValue(@NonNull String var, @NonNull String value) {
        throw new UnsupportedOperationException("Not supported by this knowledge base.");
    }
}
