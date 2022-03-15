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
public class NOK1_3KB_new extends KB {

    public NOK1_3KB_new() {
        super("NOK1_3_new", "producibility.mzn", false);

        reset(false);
    }

    @Override
    public void reset(boolean hasNegativeConstraints) {
        log.trace("{}Creating NOK1_3_new >>>", LoggerUtils.tab);
        LoggerUtils.indent();

        modelKB = new Model(name);
        variableList = new LinkedList<>();
        domainList = new LinkedList<>();
        constraintList = new LinkedList<>();
        defineDomains();
        defineVariables();
        defineConstraints(hasNegativeConstraints);

        LoggerUtils.outdent();
        log.debug("{}<<< Created NOK1_3_new", LoggerUtils.tab);
    }

    private void defineDomains() {
        log.trace("{}Defining domains >>>", LoggerUtils.tab);
        LoggerUtils.indent();

        domainList.add(Domain.builder()
                .name("dppm_vm_0")
                .values(List.of("0", "1", "2", "3"))
                .chocoValues(List.of(0, 1, 2, 3))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vm_1")
                .values(List.of("0", "1", "2", "3"))
                .chocoValues(List.of(0, 1, 2, 3))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vm_2")
                .values(List.of("0", "1", "2", "3"))
                .chocoValues(List.of(0, 1, 2, 3))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vm_3")
                .values(List.of("0", "1", "2", "3"))
                .chocoValues(List.of(0, 1, 2, 3))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vm_4")
                .values(List.of("0", "1", "2", "3"))
                .chocoValues(List.of(0, 1, 2, 3))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vm_5")
                .values(List.of("0", "1", "2", "3"))
                .chocoValues(List.of(0, 1, 2, 3))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vm_6")
                .values(List.of("0", "1", "2", "3"))
                .chocoValues(List.of(0, 1, 2, 3))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vs_0")
                .values(List.of("0", "1", "2", "3", "4", "5", "6"))
                .chocoValues(List.of(0, 1, 2, 3, 4, 5, 6))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vs_1")
                .values(List.of("0", "1", "2", "3", "4", "5", "6"))
                .chocoValues(List.of(0, 1, 2, 3, 4, 5, 6))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vs_2")
                .values(List.of("0", "1", "2", "3", "4", "5", "6"))
                .chocoValues(List.of(0, 1, 2, 3, 4, 5, 6))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vs_3")
                .values(List.of("0", "1", "2", "3", "4", "5", "6"))
                .chocoValues(List.of(0, 1, 2, 3, 4, 5, 6))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vs_4")
                .values(List.of("0", "1", "2", "3", "4", "5", "6"))
                .chocoValues(List.of(0, 1, 2, 3, 4, 5, 6))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vs_5")
                .values(List.of("0", "1", "2", "3", "4", "5", "6"))
                .chocoValues(List.of(0, 1, 2, 3, 4, 5, 6))
                .build());
        domainList.add(Domain.builder()
                .name("dppm_vs_6")
                .values(List.of("0", "1", "2", "3", "4", "5", "6"))
                .chocoValues(List.of(0, 1, 2, 3, 4, 5, 6))
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
                .chocoValues(List.of(0, 1, 2, 3, 4, 5, 6))
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

        constraintGroup0();
        constraintGroup1();
        constraintGroup2();
        constraintGroup3();
        constraintGroup4();

        LoggerUtils.outdent();
        log.debug("{}<<< Created constraints", LoggerUtils.tab);
    }

    private void constraintGroup0() {
        int startIdx = 0;

        // constraint vm[0] in {0,1};
        modelKB.member(((IntVariable)variableList.get(0)).getChocoVar(), new int[]{0, 1}).post();

        addConstraint("constraint vm[0] in {0,1};", startIdx);

        // constraint vm[1] in {2,3};
        startIdx = modelKB.getNbCstrs();
        modelKB.member(((IntVariable)variableList.get(1)).getChocoVar(), new int[]{2, 3}).post();

        addConstraint("constraint vm[1] in {2,3};", startIdx);

        // constraint vm[2] in {2,3};
        startIdx = modelKB.getNbCstrs();
        modelKB.member(((IntVariable)variableList.get(2)).getChocoVar(), new int[]{2, 3}).post();

        addConstraint("constraint vm[2] in {2,3};", startIdx);

        // constraint vm[3] in {2,3};
        startIdx = modelKB.getNbCstrs();
        modelKB.member(((IntVariable)variableList.get(3)).getChocoVar(), new int[]{2, 3}).post();

        addConstraint("constraint vm[3] in {2,3};", startIdx);

        // constraint vm[4] in {2,3};
        startIdx = modelKB.getNbCstrs();
        modelKB.member(((IntVariable)variableList.get(4)).getChocoVar(), new int[]{2, 3}).post();

        addConstraint("constraint vm[4] in {2,3};", startIdx);

        // constraint vm[5] in {2};
        startIdx = modelKB.getNbCstrs();
//        modelKB.member(((IntVariable)variableList.get(5)).getChocoVar(), new int[]{2}).post();
        modelKB.arithm(((IntVariable)variableList.get(5)).getChocoVar(), "=", 2).post();

        addConstraint("constraint vm[5] in {2};", startIdx);

        // constraint vm[6] in {0,1};
        startIdx = modelKB.getNbCstrs();
        modelKB.member(((IntVariable)variableList.get(6)).getChocoVar(), new int[]{0, 1}).post();

        addConstraint("constraint vm[6] in {0,1};", startIdx);
    }

    private void constraintGroup1() {
        // Constraint 1 - dppm_vm_0.eq(dppm_vm_1).imp(dppm_vs_0.ne(dppm_vs_1)).post();
        int startIdx = modelKB.getNbCstrs();
//        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(0)).getChocoVar(),"=", ((IntVariable)variableList.get(1)).getChocoVar()),
//                modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"!=", ((IntVariable)variableList.get(8)).getChocoVar()));

        ((IntVariable)variableList.get(0)).getChocoVar().eq(((IntVariable)variableList.get(1)).getChocoVar()).imp(
                ((IntVariable)variableList.get(7)).getChocoVar().ne(((IntVariable)variableList.get(8)).getChocoVar())
        ).post();

        addConstraint("Constraint 1 - dppm_vm_0.eq(dppm_vm_1).imp(dppm_vs_0.ne(dppm_vs_1)).post();",
                startIdx);

        // Constraint 2 - dppm_vm_0.eq(dppm_vm_2).imp(dppm_vs_0.ne(dppm_vs_2)).post();
        startIdx = modelKB.getNbCstrs();
//        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(0)).getChocoVar(),"=", ((IntVariable)variableList.get(2)).getChocoVar()),
//                modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"!=", ((IntVariable)variableList.get(9)).getChocoVar()));

        ((IntVariable)variableList.get(0)).getChocoVar().eq(((IntVariable)variableList.get(2)).getChocoVar()).imp(
                ((IntVariable)variableList.get(7)).getChocoVar().ne(((IntVariable)variableList.get(9)).getChocoVar())
        ).post();

        addConstraint("Constraint 2 - dppm_vm_0.eq(dppm_vm_2).imp(dppm_vs_0.ne(dppm_vs_2)).post();",
                startIdx);

        // Constraint 3 - dppm_vm_0.eq(dppm_vm_3).imp(dppm_vs_0.ne(dppm_vs_3)).post();
        startIdx = modelKB.getNbCstrs();
//        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(0)).getChocoVar(),"=", ((IntVariable)variableList.get(3)).getChocoVar()),
//                modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"!=", ((IntVariable)variableList.get(10)).getChocoVar()));

        ((IntVariable)variableList.get(0)).getChocoVar().eq(((IntVariable)variableList.get(3)).getChocoVar()).imp(
                ((IntVariable)variableList.get(7)).getChocoVar().ne(((IntVariable)variableList.get(10)).getChocoVar())
        ).post();

        addConstraint("Constraint 3 - dppm_vm_0.eq(dppm_vm_3).imp(dppm_vs_0.ne(dppm_vs_3)).post();",
                startIdx);

        // Constraint 4 - dppm_vm_0.eq(dppm_vm_4).imp(dppm_vs_0.ne(dppm_vs_4)).post();
        startIdx = modelKB.getNbCstrs();
//        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(0)).getChocoVar(),"=", ((IntVariable)variableList.get(4)).getChocoVar()),
//                modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"!=", ((IntVariable)variableList.get(11)).getChocoVar()));

        ((IntVariable)variableList.get(0)).getChocoVar().eq(((IntVariable)variableList.get(4)).getChocoVar()).imp(
                ((IntVariable)variableList.get(7)).getChocoVar().ne(((IntVariable)variableList.get(11)).getChocoVar())
        ).post();

        addConstraint("Constraint 4 - dppm_vm_0.eq(dppm_vm_4).imp(dppm_vs_0.ne(dppm_vs_4)).post();",
                startIdx);

        // Constraint 5 - dppm_vm_0.eq(dppm_vm_5).imp(dppm_vs_0.ne(dppm_vs_5)).post();
        startIdx = modelKB.getNbCstrs();
//        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(0)).getChocoVar(),"=", ((IntVariable)variableList.get(5)).getChocoVar()),
//                modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"!=", ((IntVariable)variableList.get(12)).getChocoVar()));

        ((IntVariable)variableList.get(0)).getChocoVar().eq(((IntVariable)variableList.get(5)).getChocoVar()).imp(
                ((IntVariable)variableList.get(7)).getChocoVar().ne(((IntVariable)variableList.get(12)).getChocoVar())
        ).post();

        addConstraint("Constraint 5 - dppm_vm_0.eq(dppm_vm_5).imp(dppm_vs_0.ne(dppm_vs_5)).post();",
                startIdx);

        // Constraint 6 - dppm_vm_0.eq(dppm_vm_6).imp(dppm_vs_0.ne(dppm_vs_6)).post();
        startIdx = modelKB.getNbCstrs();
//        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(0)).getChocoVar(),"=", ((IntVariable)variableList.get(6)).getChocoVar()),
//                modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"!=", ((IntVariable)variableList.get(13)).getChocoVar()));

        ((IntVariable)variableList.get(0)).getChocoVar().eq(((IntVariable)variableList.get(6)).getChocoVar()).imp(
                ((IntVariable)variableList.get(7)).getChocoVar().ne(((IntVariable)variableList.get(13)).getChocoVar())
        ).post();

        addConstraint("Constraint 6 - dppm_vm_0.eq(dppm_vm_6).imp(dppm_vs_0.ne(dppm_vs_6)).post();",
                startIdx);

        // Constraint 7 - dppm_vm_1.eq(dppm_vm_2).imp(dppm_vs_1.ne(dppm_vs_2)).post();
        startIdx = modelKB.getNbCstrs();
//        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(1)).getChocoVar(),"=", ((IntVariable)variableList.get(2)).getChocoVar()),
//                modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"!=", ((IntVariable)variableList.get(9)).getChocoVar()));

        ((IntVariable)variableList.get(1)).getChocoVar().eq(((IntVariable)variableList.get(2)).getChocoVar()).imp(
                ((IntVariable)variableList.get(8)).getChocoVar().ne(((IntVariable)variableList.get(9)).getChocoVar())
        ).post();

        addConstraint("Constraint 7 - dppm_vm_1.eq(dppm_vm_2).imp(dppm_vs_1.ne(dppm_vs_2)).post();",
                startIdx);

        // Constraint 8 - dppm_vm_1.eq(dppm_vm_3).imp(dppm_vs_1.ne(dppm_vs_3)).post();
        startIdx = modelKB.getNbCstrs();
//        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(1)).getChocoVar(),"=", ((IntVariable)variableList.get(3)).getChocoVar()),
//                modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"!=", ((IntVariable)variableList.get(10)).getChocoVar()));

        ((IntVariable)variableList.get(1)).getChocoVar().eq(((IntVariable)variableList.get(3)).getChocoVar()).imp(
                ((IntVariable)variableList.get(8)).getChocoVar().ne(((IntVariable)variableList.get(10)).getChocoVar())
        ).post();

        addConstraint("Constraint 8 - dppm_vm_1.eq(dppm_vm_3).imp(dppm_vs_1.ne(dppm_vs_3)).post();",
                startIdx);

        // Constraint 9 - dppm_vm_1.eq(dppm_vm_4).imp(dppm_vs_1.ne(dppm_vs_4)).post();
        startIdx = modelKB.getNbCstrs();
//        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(1)).getChocoVar(),"=", ((IntVariable)variableList.get(4)).getChocoVar()),
//                modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"!=", ((IntVariable)variableList.get(11)).getChocoVar()));

        ((IntVariable)variableList.get(1)).getChocoVar().eq(((IntVariable)variableList.get(4)).getChocoVar()).imp(
                ((IntVariable)variableList.get(8)).getChocoVar().ne(((IntVariable)variableList.get(11)).getChocoVar())
        ).post();

        addConstraint("Constraint 9 - dppm_vm_1.eq(dppm_vm_4).imp(dppm_vs_1.ne(dppm_vs_4)).post();",
                startIdx);

        // Constraint 10 - dppm_vm_1.eq(dppm_vm_5).imp(dppm_vs_1.ne(dppm_vs_5)).post();
        startIdx = modelKB.getNbCstrs();
//        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(1)).getChocoVar(),"=", ((IntVariable)variableList.get(5)).getChocoVar()),
//                modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"!=", ((IntVariable)variableList.get(12)).getChocoVar()));

        ((IntVariable)variableList.get(1)).getChocoVar().eq(((IntVariable)variableList.get(5)).getChocoVar()).imp(
                ((IntVariable)variableList.get(8)).getChocoVar().ne(((IntVariable)variableList.get(12)).getChocoVar())
        ).post();

        addConstraint("Constraint 10 - dppm_vm_1.eq(dppm_vm_5).imp(dppm_vs_1.ne(dppm_vs_5)).post();",
                startIdx);

        // Constraint 11 - dppm_vm_1.eq(dppm_vm_6).imp(dppm_vs_1.ne(dppm_vs_6)).post();
        startIdx = modelKB.getNbCstrs();
//        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(1)).getChocoVar(),"=", ((IntVariable)variableList.get(6)).getChocoVar()),
//                modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"!=", ((IntVariable)variableList.get(13)).getChocoVar()));

        ((IntVariable)variableList.get(1)).getChocoVar().eq(((IntVariable)variableList.get(6)).getChocoVar()).imp(
                ((IntVariable)variableList.get(8)).getChocoVar().ne(((IntVariable)variableList.get(13)).getChocoVar())
        ).post();

        addConstraint("Constraint 11 - dppm_vm_1.eq(dppm_vm_6).imp(dppm_vs_1.ne(dppm_vs_6)).post();",
                startIdx);

        // Constraint 12 - dppm_vm_2.eq(dppm_vm_3).imp(dppm_vs_2.ne(dppm_vs_3)).post();
        startIdx = modelKB.getNbCstrs();
//        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(2)).getChocoVar(),"=", ((IntVariable)variableList.get(3)).getChocoVar()),
//                modelKB.arithm(((IntVariable)variableList.get(9)).getChocoVar(),"!=", ((IntVariable)variableList.get(10)).getChocoVar()));

        ((IntVariable)variableList.get(2)).getChocoVar().eq(((IntVariable)variableList.get(3)).getChocoVar()).imp(
                ((IntVariable)variableList.get(9)).getChocoVar().ne(((IntVariable)variableList.get(10)).getChocoVar())
        ).post();

        addConstraint("Constraint 12 - dppm_vm_2.eq(dppm_vm_3).imp(dppm_vs_2.ne(dppm_vs_3)).post();",
                startIdx);

        // Constraint 13 - dppm_vm_2.eq(dppm_vm_4).imp(dppm_vs_2.ne(dppm_vs_4)).post();
        startIdx = modelKB.getNbCstrs();
//        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(2)).getChocoVar(),"=", ((IntVariable)variableList.get(4)).getChocoVar()),
//                modelKB.arithm(((IntVariable)variableList.get(9)).getChocoVar(),"!=", ((IntVariable)variableList.get(11)).getChocoVar()));

        ((IntVariable)variableList.get(2)).getChocoVar().eq(((IntVariable)variableList.get(4)).getChocoVar()).imp(
                ((IntVariable)variableList.get(9)).getChocoVar().ne(((IntVariable)variableList.get(11)).getChocoVar())
        ).post();

        addConstraint("Constraint 13 - dppm_vm_2.eq(dppm_vm_4).imp(dppm_vs_2.ne(dppm_vs_4)).post();",
                startIdx);

        // Constraint 14 - dppm_vm_2.eq(dppm_vm_5).imp(dppm_vs_2.ne(dppm_vs_5)).post();
        startIdx = modelKB.getNbCstrs();
//        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(2)).getChocoVar(),"=", ((IntVariable)variableList.get(5)).getChocoVar()),
//                modelKB.arithm(((IntVariable)variableList.get(9)).getChocoVar(),"!=", ((IntVariable)variableList.get(12)).getChocoVar()));

        ((IntVariable)variableList.get(2)).getChocoVar().eq(((IntVariable)variableList.get(5)).getChocoVar()).imp(
                ((IntVariable)variableList.get(9)).getChocoVar().ne(((IntVariable)variableList.get(12)).getChocoVar())
        ).post();

        addConstraint("Constraint 14 - dppm_vm_2.eq(dppm_vm_5).imp(dppm_vs_2.ne(dppm_vs_5)).post();",
                startIdx);

        // Constraint 15 - dppm_vm_2.eq(dppm_vm_6).imp(dppm_vs_2.ne(dppm_vs_6)).post();
        startIdx = modelKB.getNbCstrs();
//        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(2)).getChocoVar(),"=", ((IntVariable)variableList.get(6)).getChocoVar()),
//                modelKB.arithm(((IntVariable)variableList.get(9)).getChocoVar(),"!=", ((IntVariable)variableList.get(13)).getChocoVar()));

        ((IntVariable)variableList.get(2)).getChocoVar().eq(((IntVariable)variableList.get(6)).getChocoVar()).imp(
                ((IntVariable)variableList.get(9)).getChocoVar().ne(((IntVariable)variableList.get(13)).getChocoVar())
        ).post();

        addConstraint("Constraint 15 - dppm_vm_2.eq(dppm_vm_6).imp(dppm_vs_2.ne(dppm_vs_6)).post();",
                startIdx);

        // Constraint 16 - dppm_vm_3.eq(dppm_vm_4).imp(dppm_vs_3.ne(dppm_vs_4)).post();
        startIdx = modelKB.getNbCstrs();
//        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(3)).getChocoVar(),"=", ((IntVariable)variableList.get(4)).getChocoVar()),
//                modelKB.arithm(((IntVariable)variableList.get(10)).getChocoVar(),"!=", ((IntVariable)variableList.get(11)).getChocoVar()));

        ((IntVariable)variableList.get(3)).getChocoVar().eq(((IntVariable)variableList.get(4)).getChocoVar()).imp(
                ((IntVariable)variableList.get(10)).getChocoVar().ne(((IntVariable)variableList.get(11)).getChocoVar())
        ).post();

        addConstraint("Constraint 16 - dppm_vm_3.eq(dppm_vm_4).imp(dppm_vs_3.ne(dppm_vs_4)).post();",
                startIdx);

        // Constraint 17 - dppm_vm_3.eq(dppm_vm_5).imp(dppm_vs_3.ne(dppm_vs_5)).post();
        startIdx = modelKB.getNbCstrs();
//        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(3)).getChocoVar(),"=", ((IntVariable)variableList.get(5)).getChocoVar()),
//                modelKB.arithm(((IntVariable)variableList.get(10)).getChocoVar(),"!=", ((IntVariable)variableList.get(12)).getChocoVar()));

        ((IntVariable)variableList.get(3)).getChocoVar().eq(((IntVariable)variableList.get(5)).getChocoVar()).imp(
                ((IntVariable)variableList.get(10)).getChocoVar().ne(((IntVariable)variableList.get(12)).getChocoVar())
        ).post();

        addConstraint("Constraint 17 - dppm_vm_3.eq(dppm_vm_5).imp(dppm_vs_3.ne(dppm_vs_5)).post();",
                startIdx);

        // Constraint 18 - dppm_vm_3.eq(dppm_vm_6).imp(dppm_vs_3.ne(dppm_vs_6)).post();
        startIdx = modelKB.getNbCstrs();
//        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(3)).getChocoVar(),"=", ((IntVariable)variableList.get(6)).getChocoVar()),
//                modelKB.arithm(((IntVariable)variableList.get(10)).getChocoVar(),"!=", ((IntVariable)variableList.get(13)).getChocoVar()));

        ((IntVariable)variableList.get(3)).getChocoVar().eq(((IntVariable)variableList.get(6)).getChocoVar()).imp(
                ((IntVariable)variableList.get(10)).getChocoVar().ne(((IntVariable)variableList.get(13)).getChocoVar())
        ).post();

        addConstraint("Constraint 18 - dppm_vm_3.eq(dppm_vm_6).imp(dppm_vs_3.ne(dppm_vs_6)).post();",
                startIdx);

        // Constraint 19 - dppm_vm_4.eq(dppm_vm_5).imp(dppm_vs_4.ne(dppm_vs_5)).post();
        startIdx = modelKB.getNbCstrs();
//        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(4)).getChocoVar(),"=", ((IntVariable)variableList.get(5)).getChocoVar()),
//                modelKB.arithm(((IntVariable)variableList.get(11)).getChocoVar(),"!=", ((IntVariable)variableList.get(12)).getChocoVar()));

        ((IntVariable)variableList.get(4)).getChocoVar().eq(((IntVariable)variableList.get(5)).getChocoVar()).imp(
                ((IntVariable)variableList.get(11)).getChocoVar().ne(((IntVariable)variableList.get(12)).getChocoVar())
        ).post();

        addConstraint("Constraint 19 - dppm_vm_4.eq(dppm_vm_5).imp(dppm_vs_4.ne(dppm_vs_5)).post();",
                startIdx);

        // Constraint 20 - dppm_vm_4.eq(dppm_vm_6).imp(dppm_vs_4.ne(dppm_vs_6)).post();
        startIdx = modelKB.getNbCstrs();
//        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(4)).getChocoVar(),"=", ((IntVariable)variableList.get(6)).getChocoVar()),
//                modelKB.arithm(((IntVariable)variableList.get(11)).getChocoVar(),"!=", ((IntVariable)variableList.get(13)).getChocoVar()));

        ((IntVariable)variableList.get(4)).getChocoVar().eq(((IntVariable)variableList.get(6)).getChocoVar()).imp(
                ((IntVariable)variableList.get(11)).getChocoVar().ne(((IntVariable)variableList.get(13)).getChocoVar())
        ).post();

        addConstraint("Constraint 20 - dppm_vm_4.eq(dppm_vm_6).imp(dppm_vs_4.ne(dppm_vs_6)).post();",
                startIdx);

        // Constraint 21 - dppm_vm_5.eq(dppm_vm_6).imp(dppm_vs_5.ne(dppm_vs_6)).post();
        startIdx = modelKB.getNbCstrs();
//        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(5)).getChocoVar(),"=", ((IntVariable)variableList.get(6)).getChocoVar()),
//                modelKB.arithm(((IntVariable)variableList.get(12)).getChocoVar(),"!=", ((IntVariable)variableList.get(13)).getChocoVar()));

        ((IntVariable)variableList.get(5)).getChocoVar().eq(((IntVariable)variableList.get(6)).getChocoVar()).imp(
                ((IntVariable)variableList.get(12)).getChocoVar().ne(((IntVariable)variableList.get(13)).getChocoVar())
        ).post();

        addConstraint("Constraint 21 - dppm_vm_5.eq(dppm_vm_6).imp(dppm_vs_5.ne(dppm_vs_6)).post();",
                startIdx);
    }

    private void constraintGroup2() {
        int startIdx = modelKB.getNbCstrs();

        // Constraint 22 - dppm_vs_0.ne(dppm_vs_1).post();
//        modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"!=", ((IntVariable)variableList.get(8)).getChocoVar()).post();

        ((IntVariable)variableList.get(7)).getChocoVar().ne(((IntVariable)variableList.get(8)).getChocoVar()).post();

        addConstraint("Constraint 22 - dppm_vs_0.ne(dppm_vs_1).post();",
                startIdx);

        // Constraint 23 - dppm_vs_0.ne(dppm_vs_2).post();
        startIdx = modelKB.getNbCstrs();
//        modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"!=", ((IntVariable)variableList.get(9)).getChocoVar()).post();

        ((IntVariable)variableList.get(7)).getChocoVar().ne(((IntVariable)variableList.get(9)).getChocoVar()).post();

        addConstraint("Constraint 23 - dppm_vs_0.ne(dppm_vs_2).post();",
                startIdx);

        // Constraint 24 - dppm_vs_0.ne(dppm_vs_3).post();
        startIdx = modelKB.getNbCstrs();
//        modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"!=", ((IntVariable)variableList.get(10)).getChocoVar()).post();

        ((IntVariable)variableList.get(7)).getChocoVar().ne(((IntVariable)variableList.get(10)).getChocoVar()).post();

        addConstraint("Constraint 24 - dppm_vs_0.ne(dppm_vs_3).post();",
                startIdx);

        // Constraint 25 - dppm_vs_0.ne(dppm_vs_4).post();
        startIdx = modelKB.getNbCstrs();
//        modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"!=", ((IntVariable)variableList.get(11)).getChocoVar()).post();

        ((IntVariable)variableList.get(7)).getChocoVar().ne(((IntVariable)variableList.get(11)).getChocoVar()).post();

        addConstraint("Constraint 25 - dppm_vs_0.ne(dppm_vs_4).post();",
                startIdx);

        // Constraint 26 - dppm_vs_0.ne(dppm_vs_5).post();
        startIdx = modelKB.getNbCstrs();
//        modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"!=", ((IntVariable)variableList.get(12)).getChocoVar()).post();

        ((IntVariable)variableList.get(7)).getChocoVar().ne(((IntVariable)variableList.get(12)).getChocoVar()).post();

        addConstraint("Constraint 26 - dppm_vs_0.ne(dppm_vs_5).post();",
                startIdx);

        // Constraint 27 - dppm_vs_1.ne(dppm_vs_2).post();
        startIdx = modelKB.getNbCstrs();
//        modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"!=", ((IntVariable)variableList.get(9)).getChocoVar()).post();

        ((IntVariable)variableList.get(8)).getChocoVar().ne(((IntVariable)variableList.get(9)).getChocoVar()).post();

        addConstraint("Constraint 27 - dppm_vs_1.ne(dppm_vs_2).post();",
                startIdx);

        // Constraint 28 - dppm_vs_1.ne(dppm_vs_3).post();
        startIdx = modelKB.getNbCstrs();
//        modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"!=", ((IntVariable)variableList.get(10)).getChocoVar()).post();

        ((IntVariable)variableList.get(8)).getChocoVar().ne(((IntVariable)variableList.get(10)).getChocoVar()).post();

        addConstraint("Constraint 28 - dppm_vs_1.ne(dppm_vs_3).post();",
                startIdx);

        // Constraint 29 - dppm_vs_1.ne(dppm_vs_4).post();
        startIdx = modelKB.getNbCstrs();
//        modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"!=", ((IntVariable)variableList.get(11)).getChocoVar()).post();

        ((IntVariable)variableList.get(8)).getChocoVar().ne(((IntVariable)variableList.get(11)).getChocoVar()).post();

        addConstraint("Constraint 29 - dppm_vs_1.ne(dppm_vs_4).post();",
                startIdx);

        // Constraint 30 - dppm_vs_1.ne(dppm_vs_5).post();
        startIdx = modelKB.getNbCstrs();
//        modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"!=", ((IntVariable)variableList.get(12)).getChocoVar()).post();

        ((IntVariable)variableList.get(8)).getChocoVar().ne(((IntVariable)variableList.get(12)).getChocoVar()).post();

        addConstraint("Constraint 30 - dppm_vs_1.ne(dppm_vs_5).post();",
                startIdx);

        // Constraint 31 - dppm_vs_2.ne(dppm_vs_3).post();
        startIdx = modelKB.getNbCstrs();
//        modelKB.arithm(((IntVariable)variableList.get(9)).getChocoVar(),"!=", ((IntVariable)variableList.get(10)).getChocoVar()).post();

        ((IntVariable)variableList.get(9)).getChocoVar().ne(((IntVariable)variableList.get(10)).getChocoVar()).post();

        addConstraint("Constraint 31 - dppm_vs_2.ne(dppm_vs_3).post();",
                startIdx);

        // Constraint 32 - dppm_vs_2.ne(dppm_vs_4).post();
        startIdx = modelKB.getNbCstrs();
//        modelKB.arithm(((IntVariable)variableList.get(9)).getChocoVar(),"!=", ((IntVariable)variableList.get(11)).getChocoVar()).post();

        ((IntVariable)variableList.get(9)).getChocoVar().ne(((IntVariable)variableList.get(11)).getChocoVar()).post();

        addConstraint("Constraint 32 - dppm_vs_2.ne(dppm_vs_4).post();",
                startIdx);

        // Constraint 33 - dppm_vs_2.ne(dppm_vs_5).post();
        startIdx = modelKB.getNbCstrs();
//        modelKB.arithm(((IntVariable)variableList.get(9)).getChocoVar(),"!=", ((IntVariable)variableList.get(12)).getChocoVar()).post();

        ((IntVariable)variableList.get(9)).getChocoVar().ne(((IntVariable)variableList.get(12)).getChocoVar()).post();

        addConstraint("Constraint 33 - dppm_vs_2.ne(dppm_vs_5).post();",
                startIdx);

        // Constraint 34 - dppm_vs_3.ne(dppm_vs_4).post();
        startIdx = modelKB.getNbCstrs();
//        modelKB.arithm(((IntVariable)variableList.get(10)).getChocoVar(),"!=", ((IntVariable)variableList.get(11)).getChocoVar()).post();

        ((IntVariable)variableList.get(10)).getChocoVar().ne(((IntVariable)variableList.get(11)).getChocoVar()).post();

        addConstraint("Constraint 34 - dppm_vs_3.ne(dppm_vs_4).post();",
                startIdx);

        // Constraint 35 - dppm_vs_3.ne(dppm_vs_5).post();
        startIdx = modelKB.getNbCstrs();
//        modelKB.arithm(((IntVariable)variableList.get(10)).getChocoVar(),"!=", ((IntVariable)variableList.get(12)).getChocoVar()).post();

        ((IntVariable)variableList.get(10)).getChocoVar().ne(((IntVariable)variableList.get(12)).getChocoVar()).post();

        addConstraint("Constraint 35 - dppm_vs_3.ne(dppm_vs_5).post();",
                startIdx);

        // Constraint 36 - dppm_vs_4.ne(dppm_vs_5).post();
        startIdx = modelKB.getNbCstrs();
//        modelKB.arithm(((IntVariable)variableList.get(11)).getChocoVar(),"!=", ((IntVariable)variableList.get(12)).getChocoVar()).post();

        ((IntVariable)variableList.get(11)).getChocoVar().ne(((IntVariable)variableList.get(12)).getChocoVar()).post();

        addConstraint("Constraint 36 - dppm_vs_4.ne(dppm_vs_5).post();",
                startIdx);
    }

    private void constraintGroup3() {
        // c1 - Constraint 37 - m.arithm(dppm_vs_0, "<", dppm_vs_1).post();
        int startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"<", ((IntVariable)variableList.get(8)).getChocoVar()).post();

        addConstraint("c1 - Constraint 37 - m.arithm(dppm_vs_0, \"<\", dppm_vs_1).post();",
                startIdx);

        // c2 - Constraint 38 - m.arithm(dppm_vs_0, "<", dppm_vs_2).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"<", ((IntVariable)variableList.get(9)).getChocoVar()).post();

        addConstraint("c2 - Constraint 38 - m.arithm(dppm_vs_0, \"<\", dppm_vs_2).post();",
                startIdx);

        // c3 - Constraint 39 - m.arithm(dppm_vs_0, "<", dppm_vs_3).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"<", ((IntVariable)variableList.get(10)).getChocoVar()).post();

        addConstraint("c3 - Constraint 39 - m.arithm(dppm_vs_0, \"<\", dppm_vs_3).post();",
                startIdx);

        // c4 - Constraint 40 - m.arithm(dppm_vs_0, "<", dppm_vs_4).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"<", ((IntVariable)variableList.get(11)).getChocoVar()).post();

        addConstraint("c4 - Constraint 40 - m.arithm(dppm_vs_0, \"<\", dppm_vs_4).post();",
                startIdx);

        // c5 - Constraint 41 - m.arithm(dppm_vs_0, "<", dppm_vs_5).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"<", ((IntVariable)variableList.get(12)).getChocoVar()).post();

        addConstraint("c5 - Constraint 41 - m.arithm(dppm_vs_0, \"<\", dppm_vs_5).post();",
                startIdx);

        // c6 - Constraint 42 - m.arithm(dppm_vs_1, "<", dppm_vs_6).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"<", ((IntVariable)variableList.get(13)).getChocoVar()).post();

        addConstraint("c6 - Constraint 42 - m.arithm(dppm_vs_1, \"<\", dppm_vs_6).post();",
                startIdx);

        // c7 - Constraint 43 - m.arithm(dppm_vs_2, "<", dppm_vs_6).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(9)).getChocoVar(),"<", ((IntVariable)variableList.get(13)).getChocoVar()).post();

        addConstraint("c7 - Constraint 43 - m.arithm(dppm_vs_2, \"<\", dppm_vs_6).post();",
                startIdx);

        // c8 - Constraint 44 - m.arithm(dppm_vs_3, "<", dppm_vs_6).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(10)).getChocoVar(),"<", ((IntVariable)variableList.get(13)).getChocoVar()).post();

        addConstraint("c8 - Constraint 44 - m.arithm(dppm_vs_3, \"<\", dppm_vs_6).post();",
                startIdx);

        // c9 - Constraint 45 - m.arithm(dppm_vs_4, "<", dppm_vs_6).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(11)).getChocoVar(),"<", ((IntVariable)variableList.get(13)).getChocoVar()).post();

        addConstraint("c9 - Constraint 45 - m.arithm(dppm_vs_4, \"<\", dppm_vs_6).post();",
                startIdx);

        // c10 - Constraint 46 - m.arithm(dppm_vs_5, "<", dppm_vs_6).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(12)).getChocoVar(),"<", ((IntVariable)variableList.get(13)).getChocoVar()).post();

        addConstraint("c10 - Constraint 46 - m.arithm(dppm_vs_5, \"<\", dppm_vs_6).post();",
                startIdx);

        // c11 - Constraint 47 - m.arithm(dppm_vs_3, "<", dppm_vs_0).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(10)).getChocoVar(),"<", ((IntVariable)variableList.get(7)).getChocoVar()).post();

        addConstraint("c11 - Constraint 42 - m.arithm(dppm_vs_3, \"<\", dppm_vs_0).post();",
                startIdx);

        // c12 - Constraint 48 - constraint c[12] -> ((vs[1] < vs[2] /\ vs[3] < vs[2]) -> vm[2] = 0);
        startIdx = modelKB.getNbCstrs();
//        modelKB.ifThen(modelKB.and(modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"<", ((IntVariable)variableList.get(9)).getChocoVar()),
//                        modelKB.arithm(((IntVariable)variableList.get(10)).getChocoVar(),"<", ((IntVariable)variableList.get(9)).getChocoVar())),
//                modelKB.arithm(((IntVariable)variableList.get(2)).getChocoVar(),"=",0));

        ((IntVariable)variableList.get(8)).getChocoVar().lt(((IntVariable)variableList.get(9)).getChocoVar())
                .and(((IntVariable)variableList.get(10)).getChocoVar().lt(((IntVariable)variableList.get(9)).getChocoVar()))
                .imp(((IntVariable)variableList.get(2)).getChocoVar().eq(0)).post();

        addConstraint("c12 - Constraint 48 - constraint c[12] -> ((vs[1] < vs[2] /\\ vs[3] < vs[2]) -> vm[2] = 0);",
                startIdx);

        // c13 - Constraint 49 - constraint c[13] -> ((vs[2] < vs[3] /\ vs[4] < vs[3]) -> vm[3] = 0);
        startIdx = modelKB.getNbCstrs();
//        modelKB.ifThen(modelKB.and(modelKB.arithm(((IntVariable)variableList.get(9)).getChocoVar(),"<", ((IntVariable)variableList.get(10)).getChocoVar()),
//                        modelKB.arithm(((IntVariable)variableList.get(11)).getChocoVar(),"<", ((IntVariable)variableList.get(10)).getChocoVar())),
//                modelKB.arithm(((IntVariable)variableList.get(3)).getChocoVar(),"=",0));

        ((IntVariable)variableList.get(9)).getChocoVar().lt(((IntVariable)variableList.get(10)).getChocoVar())
                .and(((IntVariable)variableList.get(11)).getChocoVar().lt(((IntVariable)variableList.get(10)).getChocoVar()))
                .imp(((IntVariable)variableList.get(3)).getChocoVar().eq(0)).post();

        addConstraint("c13 - Constraint 49 - constraint c[13] -> ((vs[2] < vs[3] /\\ vs[4] < vs[3]) -> vm[3] = 0);",
                startIdx);

        // c14 - Constraint 50 - constraint c[14] -> ((vs[3] < vs[4] /\ vs[5] < vs[4]) -> vm[4] = 0);
        startIdx = modelKB.getNbCstrs();
//        modelKB.ifThen(modelKB.and(modelKB.arithm(((IntVariable)variableList.get(10)).getChocoVar(),"<", ((IntVariable)variableList.get(11)).getChocoVar()),
//                        modelKB.arithm(((IntVariable)variableList.get(12)).getChocoVar(),"<", ((IntVariable)variableList.get(11)).getChocoVar())),
//                modelKB.arithm(((IntVariable)variableList.get(4)).getChocoVar(),"=",0));

        ((IntVariable)variableList.get(10)).getChocoVar().lt(((IntVariable)variableList.get(11)).getChocoVar())
                .and(((IntVariable)variableList.get(12)).getChocoVar().lt(((IntVariable)variableList.get(11)).getChocoVar()))
                .imp(((IntVariable)variableList.get(4)).getChocoVar().eq(0)).post();

        addConstraint("c14 - Constraint 50 - constraint c[14] -> ((vs[3] < vs[4] /\\ vs[5] < vs[4]) -> vm[4] = 0);",
                startIdx);
    }

    private void constraintGroup4() {
        // Constraint 51 - constraint dppm_vmakespan = max(vs);
        int startIdx = modelKB.getNbCstrs();
        IntVar[] vs_array = new IntVar[]{((IntVariable)variableList.get(7)).getChocoVar(),
                                            ((IntVariable)variableList.get(8)).getChocoVar(),
                                            ((IntVariable)variableList.get(9)).getChocoVar(),
                                            ((IntVariable)variableList.get(10)).getChocoVar(),
                                            ((IntVariable)variableList.get(11)).getChocoVar(),
                                            ((IntVariable)variableList.get(12)).getChocoVar(),
                                            ((IntVariable)variableList.get(13)).getChocoVar()};
        modelKB.max(((IntVariable)variableList.get(17)).getChocoVar(), vs_array).post();

        addConstraint("Constraint 51 - m.max(dppm_vmakespan, vs_array).post();",
                startIdx);

        // Constraint 52 - dppm_vmakespan.le(5).post();
        startIdx = modelKB.getNbCstrs();
//        modelKB.arithm(((IntVariable)variableList.get(17)).getChocoVar(), "<=", 5).post();

        ((IntVariable)variableList.get(17)).getChocoVar().le(5).post();

        addConstraint("Constraint 52 - dppm_vmakespan.le(5).post();",
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
