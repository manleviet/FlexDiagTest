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
public class NOK1_3KB extends KB {

    public NOK1_3KB() {
        super("NOK1_3", "Siemens NOK1_3", false);

        reset(false);
    }

    @Override
    public void reset(boolean hasNegativeConstraints) {
        log.trace("{}Creating NOK1_3 >>>", LoggerUtils.tab);
        LoggerUtils.indent();

        modelKB = new Model(name);
        variableList = new LinkedList<>();
        domainList = new LinkedList<>();
        constraintList = new LinkedList<>();
        defineDomains();
        defineVariables();
        defineConstraints(hasNegativeConstraints);

        LoggerUtils.outdent();
        log.debug("{}<<< Created NOK1_3", LoggerUtils.tab);
    }

    private void defineDomains() {
        log.trace("{}Defining domains >>>", LoggerUtils.tab);
        LoggerUtils.indent();

        domainList.add(Domain.builder()
                .name("dppm_vm_0")
                .values(List.of("0", "1"))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vm_1")
                .values(List.of("2", "3"))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vm_2")
                .values(List.of("2", "3"))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vm_3")
                .values(List.of("2", "3"))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vm_4")
                .values(List.of("2", "3"))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vm_5")
                .values(List.of("2"))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vm_6")
                .values(List.of("0", "1"))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vs_0")
                .values(List.of("0", "1", "2", "3", "4", "5", "6"))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vs_1")
                .values(List.of("0", "1", "2", "3", "4", "5", "6"))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vs_2")
                .values(List.of("0", "1", "2", "3", "4", "5", "6"))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vs_3")
                .values(List.of("0", "1", "2", "3", "4", "5", "6"))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vs_4")
                .values(List.of("0", "1", "2", "3", "4", "5", "6"))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vs_5")
                .values(List.of("0", "1", "2", "3", "4", "5", "6"))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vs_6")
                .values(List.of("0", "1", "2", "3", "4", "5", "6"))
                .build());

        LoggerUtils.outdent();
        log.debug("{}<<< Created domains", LoggerUtils.tab);
    }

    public void defineVariables (){
        log.trace("{}Defining variables >>", LoggerUtils.tab);
        LoggerUtils.indent();

        List<String> varNames = List.of("dppm_vm_0", "dppm_vm_1", "dppm_vm_2", "dppm_vm_3", "dppm_vm_4", "dppm_vm_5", "dppm_vm_6",
                                        "dppm_vs_0", "dppm_vs_1", "dppm_vs_2", "dppm_vs_3", "dppm_vs_4", "dppm_vs_5", "dppm_vs_6");

        for (int i = 0; i < varNames.size(); i++) {
            String varName = varNames.get(i);
            IntVar intVar = this.modelKB.intVar(varName, domainList.get(i).getIntValues());
            Variable var = IntVariable.builder()
                    .name(varName)
                    .domain(domainList.get(i))
                    .chocoVar(intVar).build();
            variableList.add(var);
        }

        // v_tmp_1 - V14
        Domain d = Domain.builder()
                .name("v_tmp_1")
                .build();
        domainList.add(d);
        BoolVar boolVar = this.modelKB.boolVar("v_tmp_1");
        Variable var = BoolVariable.builder()
                .name("v_tmp_1")
                .domain(d)
                .chocoVar(boolVar)
                .build();
        variableList.add(var);

        // v_tmp_2 - V15
        d = Domain.builder()
                .name("v_tmp_2")
                .build();
        domainList.add(d);
        boolVar = this.modelKB.boolVar("v_tmp_2");
        var = BoolVariable.builder()
                .name("v_tmp_2")
                .domain(d)
                .chocoVar(boolVar)
                .build();
        variableList.add(var);

        // v_tmp_3 - V16
        d = Domain.builder()
                .name("v_tmp_3")
                .build();
        domainList.add(d);
        boolVar = this.modelKB.boolVar("v_tmp_3");
        var = BoolVariable.builder()
                .name("v_tmp_3")
                .domain(d)
                .chocoVar(boolVar)
                .build();
        variableList.add(var);

        // dppm_vmakespan - V17
        d = Domain.builder()
                .name("dppm_vmakespan")
                .values(List.of("0", "1", "2", "3", "4", "5", "6"))
                .build();
        domainList.add(d);
        IntVar intVar = this.modelKB.intVar("dppm_vmakespan", d.getIntValues());
        var = IntVariable.builder()
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
                modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"!=", ((IntVariable)variableList.get(8)).getChocoVar()));

        addConstraint("Constraint 1 - dppm_vm_0.eq(dppm_vm_1).imp(dppm_vs_0.ne(dppm_vs_1)).post();",
                startIdx);

        // Constraint 2 - dppm_vm_0.eq(dppm_vm_2).imp(dppm_vs_0.ne(dppm_vs_2)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(0)).getChocoVar(),"=", ((IntVariable)variableList.get(2)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"!=", ((IntVariable)variableList.get(9)).getChocoVar()));

        addConstraint("Constraint 2 - dppm_vm_0.eq(dppm_vm_2).imp(dppm_vs_0.ne(dppm_vs_2)).post();",
                startIdx);

        // Constraint 3 - dppm_vm_0.eq(dppm_vm_3).imp(dppm_vs_0.ne(dppm_vs_3)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(0)).getChocoVar(),"=", ((IntVariable)variableList.get(3)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"!=", ((IntVariable)variableList.get(10)).getChocoVar()));

        addConstraint("Constraint 3 - dppm_vm_0.eq(dppm_vm_3).imp(dppm_vs_0.ne(dppm_vs_3)).post();",
                startIdx);

        // Constraint 4 - dppm_vm_0.eq(dppm_vm_4).imp(dppm_vs_0.ne(dppm_vs_4)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(0)).getChocoVar(),"=", ((IntVariable)variableList.get(4)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"!=", ((IntVariable)variableList.get(11)).getChocoVar()));

        addConstraint("Constraint 4 - dppm_vm_0.eq(dppm_vm_4).imp(dppm_vs_0.ne(dppm_vs_4)).post();",
                startIdx);

        // Constraint 5 - dppm_vm_0.eq(dppm_vm_5).imp(dppm_vs_0.ne(dppm_vs_5)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(0)).getChocoVar(),"=", ((IntVariable)variableList.get(5)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"!=", ((IntVariable)variableList.get(12)).getChocoVar()));

        addConstraint("Constraint 5 - dppm_vm_0.eq(dppm_vm_5).imp(dppm_vs_0.ne(dppm_vs_5)).post();",
                startIdx);

        // Constraint 6 - dppm_vm_0.eq(dppm_vm_6).imp(dppm_vs_0.ne(dppm_vs_6)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(0)).getChocoVar(),"=", ((IntVariable)variableList.get(6)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"!=", ((IntVariable)variableList.get(13)).getChocoVar()));

        addConstraint("Constraint 6 - dppm_vm_0.eq(dppm_vm_6).imp(dppm_vs_0.ne(dppm_vs_6)).post();",
                startIdx);

        // Constraint 7 - dppm_vm_1.eq(dppm_vm_2).imp(dppm_vs_1.ne(dppm_vs_2)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(1)).getChocoVar(),"=", ((IntVariable)variableList.get(2)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"!=", ((IntVariable)variableList.get(9)).getChocoVar()));

        addConstraint("Constraint 7 - dppm_vm_1.eq(dppm_vm_2).imp(dppm_vs_1.ne(dppm_vs_2)).post();",
                startIdx);

        // Constraint 8 - dppm_vm_1.eq(dppm_vm_3).imp(dppm_vs_1.ne(dppm_vs_3)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(1)).getChocoVar(),"=", ((IntVariable)variableList.get(3)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"!=", ((IntVariable)variableList.get(10)).getChocoVar()));

        addConstraint("Constraint 8 - dppm_vm_1.eq(dppm_vm_3).imp(dppm_vs_1.ne(dppm_vs_3)).post();",
                startIdx);

        // Constraint 9 - dppm_vm_1.eq(dppm_vm_4).imp(dppm_vs_1.ne(dppm_vs_4)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(1)).getChocoVar(),"=", ((IntVariable)variableList.get(4)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"!=", ((IntVariable)variableList.get(11)).getChocoVar()));

        addConstraint("Constraint 9 - dppm_vm_1.eq(dppm_vm_4).imp(dppm_vs_1.ne(dppm_vs_4)).post();",
                startIdx);

        // Constraint 10 - dppm_vm_1.eq(dppm_vm_5).imp(dppm_vs_1.ne(dppm_vs_5)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(1)).getChocoVar(),"=", ((IntVariable)variableList.get(5)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"!=", ((IntVariable)variableList.get(12)).getChocoVar()));

        addConstraint("Constraint 10 - dppm_vm_1.eq(dppm_vm_5).imp(dppm_vs_1.ne(dppm_vs_5)).post();",
                startIdx);

        // Constraint 11 - dppm_vm_1.eq(dppm_vm_6).imp(dppm_vs_1.ne(dppm_vs_6)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(1)).getChocoVar(),"=", ((IntVariable)variableList.get(6)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"!=", ((IntVariable)variableList.get(13)).getChocoVar()));

        addConstraint("Constraint 11 - dppm_vm_1.eq(dppm_vm_6).imp(dppm_vs_1.ne(dppm_vs_6)).post();",
                startIdx);

        // Constraint 12 - dppm_vm_2.eq(dppm_vm_3).imp(dppm_vs_2.ne(dppm_vs_3)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(2)).getChocoVar(),"=", ((IntVariable)variableList.get(3)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(9)).getChocoVar(),"!=", ((IntVariable)variableList.get(10)).getChocoVar()));

        addConstraint("Constraint 12 - dppm_vm_2.eq(dppm_vm_3).imp(dppm_vs_2.ne(dppm_vs_3)).post();",
                startIdx);

        // Constraint 13 - dppm_vm_2.eq(dppm_vm_4).imp(dppm_vs_2.ne(dppm_vs_4)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(2)).getChocoVar(),"=", ((IntVariable)variableList.get(4)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(9)).getChocoVar(),"!=", ((IntVariable)variableList.get(11)).getChocoVar()));

        addConstraint("Constraint 13 - dppm_vm_2.eq(dppm_vm_4).imp(dppm_vs_2.ne(dppm_vs_4)).post();",
                startIdx);

        // Constraint 14 - dppm_vm_2.eq(dppm_vm_5).imp(dppm_vs_2.ne(dppm_vs_5)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(2)).getChocoVar(),"=", ((IntVariable)variableList.get(5)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(9)).getChocoVar(),"!=", ((IntVariable)variableList.get(12)).getChocoVar()));

        addConstraint("Constraint 14 - dppm_vm_2.eq(dppm_vm_5).imp(dppm_vs_2.ne(dppm_vs_5)).post();",
                startIdx);

        // Constraint 15 - dppm_vm_2.eq(dppm_vm_6).imp(dppm_vs_2.ne(dppm_vs_6)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(2)).getChocoVar(),"=", ((IntVariable)variableList.get(6)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(9)).getChocoVar(),"!=", ((IntVariable)variableList.get(13)).getChocoVar()));

        addConstraint("Constraint 15 - dppm_vm_2.eq(dppm_vm_6).imp(dppm_vs_2.ne(dppm_vs_6)).post();",
                startIdx);

        // Constraint 16 - dppm_vm_3.eq(dppm_vm_4).imp(dppm_vs_3.ne(dppm_vs_4)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(3)).getChocoVar(),"=", ((IntVariable)variableList.get(4)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(10)).getChocoVar(),"!=", ((IntVariable)variableList.get(11)).getChocoVar()));

        addConstraint("Constraint 16 - dppm_vm_3.eq(dppm_vm_4).imp(dppm_vs_3.ne(dppm_vs_4)).post();",
                startIdx);

        // Constraint 17 - dppm_vm_3.eq(dppm_vm_5).imp(dppm_vs_3.ne(dppm_vs_5)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(3)).getChocoVar(),"=", ((IntVariable)variableList.get(5)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(10)).getChocoVar(),"!=", ((IntVariable)variableList.get(12)).getChocoVar()));

        addConstraint("Constraint 17 - dppm_vm_3.eq(dppm_vm_5).imp(dppm_vs_3.ne(dppm_vs_5)).post();",
                startIdx);

        // Constraint 18 - dppm_vm_3.eq(dppm_vm_6).imp(dppm_vs_3.ne(dppm_vs_6)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(3)).getChocoVar(),"=", ((IntVariable)variableList.get(6)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(10)).getChocoVar(),"!=", ((IntVariable)variableList.get(13)).getChocoVar()));

        addConstraint("Constraint 18 - dppm_vm_3.eq(dppm_vm_6).imp(dppm_vs_3.ne(dppm_vs_6)).post();",
                startIdx);

        // Constraint 19 - dppm_vm_4.eq(dppm_vm_5).imp(dppm_vs_4.ne(dppm_vs_5)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(4)).getChocoVar(),"=", ((IntVariable)variableList.get(5)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(11)).getChocoVar(),"!=", ((IntVariable)variableList.get(12)).getChocoVar()));

        addConstraint("Constraint 19 - dppm_vm_4.eq(dppm_vm_5).imp(dppm_vs_4.ne(dppm_vs_5)).post();",
                startIdx);

        // Constraint 20 - dppm_vm_4.eq(dppm_vm_6).imp(dppm_vs_4.ne(dppm_vs_6)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(4)).getChocoVar(),"=", ((IntVariable)variableList.get(6)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(11)).getChocoVar(),"!=", ((IntVariable)variableList.get(13)).getChocoVar()));

        addConstraint("Constraint 20 - dppm_vm_4.eq(dppm_vm_6).imp(dppm_vs_4.ne(dppm_vs_6)).post();",
                startIdx);

        // Constraint 21 - dppm_vm_5.eq(dppm_vm_6).imp(dppm_vs_5.ne(dppm_vs_6)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(5)).getChocoVar(),"=", ((IntVariable)variableList.get(6)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(12)).getChocoVar(),"!=", ((IntVariable)variableList.get(13)).getChocoVar()));

        addConstraint("Constraint 21 - dppm_vm_5.eq(dppm_vm_6).imp(dppm_vs_5.ne(dppm_vs_6)).post();",
                startIdx);
    }

    private void constraintGroup2() {
        int startIdx = modelKB.getNbCstrs();

        // Constraint 22 - dppm_vs_0.ne(dppm_vs_1).post();
        modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"!=", ((IntVariable)variableList.get(8)).getChocoVar()).post();

        addConstraint("Constraint 22 - dppm_vs_0.ne(dppm_vs_1).post();",
                startIdx);

        // Constraint 23 - dppm_vs_0.ne(dppm_vs_2).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"!=", ((IntVariable)variableList.get(9)).getChocoVar()).post();

        addConstraint("Constraint 23 - dppm_vs_0.ne(dppm_vs_2).post();",
                startIdx);

        // Constraint 24 - dppm_vs_0.ne(dppm_vs_3).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"!=", ((IntVariable)variableList.get(10)).getChocoVar()).post();

        addConstraint("Constraint 24 - dppm_vs_0.ne(dppm_vs_3).post();",
                startIdx);

        // Constraint 25 - dppm_vs_0.ne(dppm_vs_4).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"!=", ((IntVariable)variableList.get(11)).getChocoVar()).post();

        addConstraint("Constraint 25 - dppm_vs_0.ne(dppm_vs_4).post();",
                startIdx);

        // Constraint 26 - dppm_vs_0.ne(dppm_vs_5).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"!=", ((IntVariable)variableList.get(12)).getChocoVar()).post();

        addConstraint("Constraint 26 - dppm_vs_0.ne(dppm_vs_5).post();",
                startIdx);

        // Constraint 27 - dppm_vs_1.ne(dppm_vs_2).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"!=", ((IntVariable)variableList.get(9)).getChocoVar()).post();

        addConstraint("Constraint 27 - dppm_vs_1.ne(dppm_vs_2).post();",
                startIdx);

        // Constraint 28 - dppm_vs_1.ne(dppm_vs_3).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"!=", ((IntVariable)variableList.get(10)).getChocoVar()).post();

        addConstraint("Constraint 28 - dppm_vs_1.ne(dppm_vs_3).post();",
                startIdx);

        // Constraint 29 - dppm_vs_1.ne(dppm_vs_4).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"!=", ((IntVariable)variableList.get(11)).getChocoVar()).post();

        addConstraint("Constraint 29 - dppm_vs_1.ne(dppm_vs_4).post();",
                startIdx);

        // Constraint 30 - dppm_vs_1.ne(dppm_vs_5).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"!=", ((IntVariable)variableList.get(12)).getChocoVar()).post();

        addConstraint("Constraint 30 - dppm_vs_1.ne(dppm_vs_5).post();",
                startIdx);

        // Constraint 31 - dppm_vs_2.ne(dppm_vs_3).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(9)).getChocoVar(),"!=", ((IntVariable)variableList.get(10)).getChocoVar()).post();

        addConstraint("Constraint 31 - dppm_vs_2.ne(dppm_vs_3).post();",
                startIdx);

        // Constraint 32 - dppm_vs_2.ne(dppm_vs_4).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(9)).getChocoVar(),"!=", ((IntVariable)variableList.get(11)).getChocoVar()).post();

        addConstraint("Constraint 32 - dppm_vs_2.ne(dppm_vs_4).post();",
                startIdx);

        // Constraint 33 - dppm_vs_2.ne(dppm_vs_5).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(9)).getChocoVar(),"!=", ((IntVariable)variableList.get(12)).getChocoVar()).post();

        addConstraint("Constraint 33 - dppm_vs_2.ne(dppm_vs_5).post();",
                startIdx);

        // Constraint 34 - dppm_vs_3.ne(dppm_vs_4).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(10)).getChocoVar(),"!=", ((IntVariable)variableList.get(11)).getChocoVar()).post();

        addConstraint("Constraint 34 - dppm_vs_3.ne(dppm_vs_4).post();",
                startIdx);

        // Constraint 35 - dppm_vs_3.ne(dppm_vs_5).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(10)).getChocoVar(),"!=", ((IntVariable)variableList.get(12)).getChocoVar()).post();

        addConstraint("Constraint 35 - dppm_vs_3.ne(dppm_vs_5).post();",
                startIdx);

        // Constraint 36 - dppm_vs_4.ne(dppm_vs_5).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(11)).getChocoVar(),"!=", ((IntVariable)variableList.get(12)).getChocoVar()).post();

        addConstraint("Constraint 36 - dppm_vs_4.ne(dppm_vs_5).post();",
                startIdx);
    }

    private void constraintGroup3() {
        // Constraint 37 - m.arithm(dppm_vs_0, "<", dppm_vs_1).post();
        int startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"<", ((IntVariable)variableList.get(8)).getChocoVar()).post();

        addConstraint("Constraint 37 - m.arithm(dppm_vs_0, \"<\", dppm_vs_1).post();",
                startIdx);

        // Constraint 38 - m.arithm(dppm_vs_0, "<", dppm_vs_2).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"<", ((IntVariable)variableList.get(9)).getChocoVar()).post();

        addConstraint("Constraint 38 - m.arithm(dppm_vs_0, \"<\", dppm_vs_2).post();",
                startIdx);

        // Constraint 39 - m.arithm(dppm_vs_0, "<", dppm_vs_3).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"<", ((IntVariable)variableList.get(10)).getChocoVar()).post();

        addConstraint("Constraint 39 - m.arithm(dppm_vs_0, \"<\", dppm_vs_3).post();",
                startIdx);

        // Constraint 40 - m.arithm(dppm_vs_0, "<", dppm_vs_4).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"<", ((IntVariable)variableList.get(11)).getChocoVar()).post();

        addConstraint("Constraint 40 - m.arithm(dppm_vs_0, \"<\", dppm_vs_4).post();",
                startIdx);

        // Constraint 41 - m.arithm(dppm_vs_0, "<", dppm_vs_5).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"<", ((IntVariable)variableList.get(12)).getChocoVar()).post();

        addConstraint("Constraint 41 - m.arithm(dppm_vs_0, \"<\", dppm_vs_5).post();",
                startIdx);

        // Constraint 42 - m.arithm(dppm_vs_3, "<", dppm_vs_0).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(10)).getChocoVar(),"<", ((IntVariable)variableList.get(7)).getChocoVar()).post();

        addConstraint("Constraint 42 - m.arithm(dppm_vs_3, \"<\", dppm_vs_0).post();",
                startIdx);

        // Constraint 43 - m.arithm(dppm_vs_1, "<", dppm_vs_6).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"<", ((IntVariable)variableList.get(13)).getChocoVar()).post();

        addConstraint("Constraint 42 - m.arithm(dppm_vs_1, \"<\", dppm_vs_6).post();",
                startIdx);

        // Constraint 44 - m.arithm(dppm_vs_2, "<", dppm_vs_6).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(9)).getChocoVar(),"<", ((IntVariable)variableList.get(13)).getChocoVar()).post();

        addConstraint("Constraint 43 - m.arithm(dppm_vs_2, \"<\", dppm_vs_6).post();",
                startIdx);

        // Constraint 45 - m.arithm(dppm_vs_3, "<", dppm_vs_6).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(10)).getChocoVar(),"<", ((IntVariable)variableList.get(13)).getChocoVar()).post();

        addConstraint("Constraint 44 - m.arithm(dppm_vs_3, \"<\", dppm_vs_6).post();",
                startIdx);

        // Constraint 46 - m.arithm(dppm_vs_4, "<", dppm_vs_6).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(11)).getChocoVar(),"<", ((IntVariable)variableList.get(13)).getChocoVar()).post();

        addConstraint("Constraint 45 - m.arithm(dppm_vs_4, \"<\", dppm_vs_6).post();",
                startIdx);

        // Constraint 47 - m.arithm(dppm_vs_5, "<", dppm_vs_6).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(12)).getChocoVar(),"<", ((IntVariable)variableList.get(13)).getChocoVar()).post();

        addConstraint("Constraint 46 - m.arithm(dppm_vs_5, \"<\", dppm_vs_6).post();",
                startIdx);
    }

    private void constraintGroup4() {
        // Constraint 48 - m.element(v_tmp_1, new int[]{0,0,0,0}, dppm_vm_2).post();
        int startIdx = modelKB.getNbCstrs();
        modelKB.element(((BoolVariable)variableList.get(14)).getChocoVar(), new int[]{0,0,0,0}, ((IntVariable)variableList.get(2)).getChocoVar()).post();

        addConstraint("Constraint 47 - m.element(v_tmp_1, new int[]{0,0,0,0}, dppm_vm_2).post();",
                startIdx);

        // Constraint 49 - m.or(new Constraint[]{m.not( m.and( new Constraint[]{ m.arithm(dppm_vs_1, "<", dppm_vs_2),
        //                                                                       m.arithm(dppm_vs_3, "<", dppm_vs_2)})),
        //                                       m.arithm(v_tmp_1, "=", 1)}).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.or(modelKB.not(modelKB.and(modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"<", ((IntVariable)variableList.get(9)).getChocoVar()),
                                            modelKB.arithm(((IntVariable)variableList.get(10)).getChocoVar(),"<", ((IntVariable)variableList.get(9)).getChocoVar()))),
                    modelKB.arithm(((BoolVariable)variableList.get(14)).getChocoVar(),"=", 1)).post();

        addConstraint("Constraint 48 - m.or(new Constraint[]{m.not(m.and(new Constraint[]{m.arithm(dppm_vs_1, \"<\", dppm_vs_2), m.arithm(dppm_vs_3, \"<\", dppm_vs_2)})), m.arithm(v_tmp_1, \"=\", 1)}).post();",
                startIdx);

        // Constraint 50 - m.element(v_tmp_2, new int[]{0,0,0,0}, dppm_vm_3).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.element(((BoolVariable)variableList.get(15)).getChocoVar(), new int[]{0,0,0,0}, ((IntVariable)variableList.get(3)).getChocoVar()).post();

        addConstraint("Constraint 49 - m.element(v_tmp_2, new int[]{0,0,0,0}, dppm_vm_3).post();",
                startIdx);

        // Constraint 51 - m.or(new Constraint[]{m.not(m.and(new Constraint[]{m.arithm(dppm_vs_2, "<", dppm_vs_3),
        //                                                                    m.arithm(dppm_vs_4, "<", dppm_vs_3)})),
        //                                       m.arithm(v_tmp_2, "=", 1)}).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.or(modelKB.not(modelKB.and(modelKB.arithm(((IntVariable)variableList.get(9)).getChocoVar(),"<", ((IntVariable)variableList.get(10)).getChocoVar()),
                                           modelKB.arithm(((IntVariable)variableList.get(11)).getChocoVar(),"<", ((IntVariable)variableList.get(10)).getChocoVar()))),
                    modelKB.arithm(((BoolVariable)variableList.get(15)).getChocoVar(),"=", 1)).post();

        addConstraint("Constraint 50 - m.or(new Constraint[]{m.not(m.and(new Constraint[]{m.arithm(dppm_vs_2, \"<\", dppm_vs_3), m.arithm(dppm_vs_4, \"<\", dppm_vs_3)})), m.arithm(v_tmp_2, \"=\", 1)}).post();",
                startIdx);

        // Constraint 52 - m.element(v_tmp_3, new int[]{0,0,0,0}, dppm_vm_4).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.element(((BoolVariable)variableList.get(16)).getChocoVar(), new int[]{0,0,0,0}, ((IntVariable)variableList.get(4)).getChocoVar()).post();

        addConstraint("Constraint 51 - m.element(v_tmp_3, new int[]{0,0,0,0}, dppm_vm_4).post();",
                startIdx);

        // Constraint 53 - m.or(new Constraint[]{m.not(m.and(new Constraint[]{m.arithm(dppm_vs_3, "<", dppm_vs_4),
        //                                                                    m.arithm(dppm_vs_5, "<", dppm_vs_4)})),
        //                                       m.arithm(v_tmp_3, "=", 1)}).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.or(modelKB.not(modelKB.and(modelKB.arithm(((IntVariable)variableList.get(10)).getChocoVar(),"<", ((IntVariable)variableList.get(11)).getChocoVar()),
                                           modelKB.arithm(((IntVariable)variableList.get(12)).getChocoVar(),"<", ((IntVariable)variableList.get(11)).getChocoVar()))),
                    modelKB.arithm(((BoolVariable)variableList.get(16)).getChocoVar(),"=", 1)).post();

        addConstraint("Constraint 52 - m.or(new Constraint[]{m.not(m.and(new Constraint[]{m.arithm(dppm_vs_3, \"<\", dppm_vs_4), m.arithm(dppm_vs_5, \"<\", dppm_vs_4)})), m.arithm(v_tmp_3, \"=\", 1)}).post();",
                startIdx);

        // Constraint 54 - m.max(dppm_vmakespan, vs_array).post();
        startIdx = modelKB.getNbCstrs();
        IntVar[] vs_array = new IntVar[]{((IntVariable)variableList.get(7)).getChocoVar(),
                ((IntVariable)variableList.get(8)).getChocoVar(),
                ((IntVariable)variableList.get(9)).getChocoVar(),
                ((IntVariable)variableList.get(10)).getChocoVar(),
                ((IntVariable)variableList.get(11)).getChocoVar(),
                ((IntVariable)variableList.get(12)).getChocoVar(),
                ((IntVariable)variableList.get(13)).getChocoVar()};
        modelKB.max(((IntVariable)variableList.get(17)).getChocoVar(), vs_array).post();

        addConstraint("Constraint 53 - m.max(dppm_vmakespan, vs_array).post();",
                startIdx);

        // Constraint 55 - dppm_vmakespan.le(5).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(17)).getChocoVar(), ">=", 6).post();

        addConstraint("Constraint 54 - dppm_vmakespan.le(5).post();",
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
