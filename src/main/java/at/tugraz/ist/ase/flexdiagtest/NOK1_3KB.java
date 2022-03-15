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

        // C0 - constraint vm[0] in {0,1};
        modelKB.member(((IntVariable)variableList.get(0)).getChocoVar(), new int[]{0, 1}).post();

        addConstraint("C0 - constraint vm[0] in {0,1};", startIdx);

        // C1 - constraint vm[1] in {2,3};
        startIdx = modelKB.getNbCstrs();
        modelKB.member(((IntVariable)variableList.get(1)).getChocoVar(), new int[]{2, 3}).post();

        addConstraint("C1 - constraint vm[1] in {2,3};", startIdx);

        // constraint vm[2] in {2,3};
        startIdx = modelKB.getNbCstrs();
        modelKB.member(((IntVariable)variableList.get(2)).getChocoVar(), new int[]{2, 3}).post();

        addConstraint("C2 - constraint vm[2] in {2,3};", startIdx);

        // constraint vm[3] in {2,3};
        startIdx = modelKB.getNbCstrs();
        modelKB.member(((IntVariable)variableList.get(3)).getChocoVar(), new int[]{2, 3}).post();

        addConstraint("C3 - constraint vm[3] in {2,3};", startIdx);

        // constraint vm[4] in {2,3};
        startIdx = modelKB.getNbCstrs();
        modelKB.member(((IntVariable)variableList.get(4)).getChocoVar(), new int[]{2, 3}).post();

        addConstraint("C4 - constraint vm[4] in {2,3};", startIdx);

        // constraint vm[5] in {2};
        startIdx = modelKB.getNbCstrs();
//        modelKB.member(((IntVariable)variableList.get(5)).getChocoVar(), new int[]{2}).post();
        modelKB.arithm(((IntVariable)variableList.get(5)).getChocoVar(), "=", 2).post();

        addConstraint("C5 - constraint vm[5] in {2};", startIdx);

        // constraint vm[6] in {0,1};
        startIdx = modelKB.getNbCstrs();
        modelKB.member(((IntVariable)variableList.get(6)).getChocoVar(), new int[]{0, 1}).post();

        addConstraint("C6 - constraint vm[6] in {0,1};", startIdx);
    }

    private void constraintGroup1() {
        // C7 - dppm_vm_0.eq(dppm_vm_1).imp(dppm_vs_0.ne(dppm_vs_1)).post();
        int startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(0)).getChocoVar(),"=", ((IntVariable)variableList.get(1)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"!=", ((IntVariable)variableList.get(8)).getChocoVar()));

        addConstraint("C7 - dppm_vm_0.eq(dppm_vm_1).imp(dppm_vs_0.ne(dppm_vs_1)).post();",
                startIdx);

        // C8 - dppm_vm_0.eq(dppm_vm_2).imp(dppm_vs_0.ne(dppm_vs_2)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(0)).getChocoVar(),"=", ((IntVariable)variableList.get(2)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"!=", ((IntVariable)variableList.get(9)).getChocoVar()));

        addConstraint("C8 - dppm_vm_0.eq(dppm_vm_2).imp(dppm_vs_0.ne(dppm_vs_2)).post();",
                startIdx);

        // C9 - dppm_vm_0.eq(dppm_vm_3).imp(dppm_vs_0.ne(dppm_vs_3)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(0)).getChocoVar(),"=", ((IntVariable)variableList.get(3)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"!=", ((IntVariable)variableList.get(10)).getChocoVar()));

        addConstraint("C9 - dppm_vm_0.eq(dppm_vm_3).imp(dppm_vs_0.ne(dppm_vs_3)).post();",
                startIdx);

        // C10 - dppm_vm_0.eq(dppm_vm_4).imp(dppm_vs_0.ne(dppm_vs_4)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(0)).getChocoVar(),"=", ((IntVariable)variableList.get(4)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"!=", ((IntVariable)variableList.get(11)).getChocoVar()));

        addConstraint("C10 - dppm_vm_0.eq(dppm_vm_4).imp(dppm_vs_0.ne(dppm_vs_4)).post();",
                startIdx);

        // C11 - dppm_vm_0.eq(dppm_vm_5).imp(dppm_vs_0.ne(dppm_vs_5)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(0)).getChocoVar(),"=", ((IntVariable)variableList.get(5)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"!=", ((IntVariable)variableList.get(12)).getChocoVar()));

        addConstraint("C11 - dppm_vm_0.eq(dppm_vm_5).imp(dppm_vs_0.ne(dppm_vs_5)).post();",
                startIdx);

        // C12 - dppm_vm_0.eq(dppm_vm_6).imp(dppm_vs_0.ne(dppm_vs_6)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(0)).getChocoVar(),"=", ((IntVariable)variableList.get(6)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"!=", ((IntVariable)variableList.get(13)).getChocoVar()));

        addConstraint("C12 - dppm_vm_0.eq(dppm_vm_6).imp(dppm_vs_0.ne(dppm_vs_6)).post();",
                startIdx);

        // C13 - dppm_vm_1.eq(dppm_vm_2).imp(dppm_vs_1.ne(dppm_vs_2)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(1)).getChocoVar(),"=", ((IntVariable)variableList.get(2)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"!=", ((IntVariable)variableList.get(9)).getChocoVar()));

        addConstraint("C13 - dppm_vm_1.eq(dppm_vm_2).imp(dppm_vs_1.ne(dppm_vs_2)).post();",
                startIdx);

        // C14 - dppm_vm_1.eq(dppm_vm_3).imp(dppm_vs_1.ne(dppm_vs_3)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(1)).getChocoVar(),"=", ((IntVariable)variableList.get(3)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"!=", ((IntVariable)variableList.get(10)).getChocoVar()));

        addConstraint("C14 - dppm_vm_1.eq(dppm_vm_3).imp(dppm_vs_1.ne(dppm_vs_3)).post();",
                startIdx);

        // C15 - dppm_vm_1.eq(dppm_vm_4).imp(dppm_vs_1.ne(dppm_vs_4)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(1)).getChocoVar(),"=", ((IntVariable)variableList.get(4)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"!=", ((IntVariable)variableList.get(11)).getChocoVar()));

        addConstraint("C15 - dppm_vm_1.eq(dppm_vm_4).imp(dppm_vs_1.ne(dppm_vs_4)).post();",
                startIdx);

        // C16 - dppm_vm_1.eq(dppm_vm_5).imp(dppm_vs_1.ne(dppm_vs_5)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(1)).getChocoVar(),"=", ((IntVariable)variableList.get(5)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"!=", ((IntVariable)variableList.get(12)).getChocoVar()));

        addConstraint("C16 - dppm_vm_1.eq(dppm_vm_5).imp(dppm_vs_1.ne(dppm_vs_5)).post();",
                startIdx);

        // C17 - dppm_vm_1.eq(dppm_vm_6).imp(dppm_vs_1.ne(dppm_vs_6)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(1)).getChocoVar(),"=", ((IntVariable)variableList.get(6)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"!=", ((IntVariable)variableList.get(13)).getChocoVar()));

        addConstraint("C17 - dppm_vm_1.eq(dppm_vm_6).imp(dppm_vs_1.ne(dppm_vs_6)).post();",
                startIdx);

        // C18 - dppm_vm_2.eq(dppm_vm_3).imp(dppm_vs_2.ne(dppm_vs_3)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(2)).getChocoVar(),"=", ((IntVariable)variableList.get(3)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(9)).getChocoVar(),"!=", ((IntVariable)variableList.get(10)).getChocoVar()));

        addConstraint("C18 - dppm_vm_2.eq(dppm_vm_3).imp(dppm_vs_2.ne(dppm_vs_3)).post();",
                startIdx);

        // C19 - dppm_vm_2.eq(dppm_vm_4).imp(dppm_vs_2.ne(dppm_vs_4)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(2)).getChocoVar(),"=", ((IntVariable)variableList.get(4)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(9)).getChocoVar(),"!=", ((IntVariable)variableList.get(11)).getChocoVar()));

        addConstraint("C19 - dppm_vm_2.eq(dppm_vm_4).imp(dppm_vs_2.ne(dppm_vs_4)).post();",
                startIdx);

        // C20 - dppm_vm_2.eq(dppm_vm_5).imp(dppm_vs_2.ne(dppm_vs_5)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(2)).getChocoVar(),"=", ((IntVariable)variableList.get(5)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(9)).getChocoVar(),"!=", ((IntVariable)variableList.get(12)).getChocoVar()));

        addConstraint("C20 - dppm_vm_2.eq(dppm_vm_5).imp(dppm_vs_2.ne(dppm_vs_5)).post();",
                startIdx);

        // C21 - dppm_vm_2.eq(dppm_vm_6).imp(dppm_vs_2.ne(dppm_vs_6)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(2)).getChocoVar(),"=", ((IntVariable)variableList.get(6)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(9)).getChocoVar(),"!=", ((IntVariable)variableList.get(13)).getChocoVar()));

        addConstraint("C21 - dppm_vm_2.eq(dppm_vm_6).imp(dppm_vs_2.ne(dppm_vs_6)).post();",
                startIdx);

        // C22 - dppm_vm_3.eq(dppm_vm_4).imp(dppm_vs_3.ne(dppm_vs_4)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(3)).getChocoVar(),"=", ((IntVariable)variableList.get(4)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(10)).getChocoVar(),"!=", ((IntVariable)variableList.get(11)).getChocoVar()));

        addConstraint("C22 - dppm_vm_3.eq(dppm_vm_4).imp(dppm_vs_3.ne(dppm_vs_4)).post();",
                startIdx);

        // C23 - dppm_vm_3.eq(dppm_vm_5).imp(dppm_vs_3.ne(dppm_vs_5)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(3)).getChocoVar(),"=", ((IntVariable)variableList.get(5)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(10)).getChocoVar(),"!=", ((IntVariable)variableList.get(12)).getChocoVar()));

        addConstraint("C23 - dppm_vm_3.eq(dppm_vm_5).imp(dppm_vs_3.ne(dppm_vs_5)).post();",
                startIdx);

        // C24 - dppm_vm_3.eq(dppm_vm_6).imp(dppm_vs_3.ne(dppm_vs_6)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(3)).getChocoVar(),"=", ((IntVariable)variableList.get(6)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(10)).getChocoVar(),"!=", ((IntVariable)variableList.get(13)).getChocoVar()));

        addConstraint("C24 - dppm_vm_3.eq(dppm_vm_6).imp(dppm_vs_3.ne(dppm_vs_6)).post();",
                startIdx);

        // C25 - dppm_vm_4.eq(dppm_vm_5).imp(dppm_vs_4.ne(dppm_vs_5)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(4)).getChocoVar(),"=", ((IntVariable)variableList.get(5)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(11)).getChocoVar(),"!=", ((IntVariable)variableList.get(12)).getChocoVar()));

        addConstraint("C25 - dppm_vm_4.eq(dppm_vm_5).imp(dppm_vs_4.ne(dppm_vs_5)).post();",
                startIdx);

        // C26 - dppm_vm_4.eq(dppm_vm_6).imp(dppm_vs_4.ne(dppm_vs_6)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(4)).getChocoVar(),"=", ((IntVariable)variableList.get(6)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(11)).getChocoVar(),"!=", ((IntVariable)variableList.get(13)).getChocoVar()));

        addConstraint("C26 - dppm_vm_4.eq(dppm_vm_6).imp(dppm_vs_4.ne(dppm_vs_6)).post();",
                startIdx);

        // C27 - dppm_vm_5.eq(dppm_vm_6).imp(dppm_vs_5.ne(dppm_vs_6)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(((IntVariable)variableList.get(5)).getChocoVar(),"=", ((IntVariable)variableList.get(6)).getChocoVar()),
                modelKB.arithm(((IntVariable)variableList.get(12)).getChocoVar(),"!=", ((IntVariable)variableList.get(13)).getChocoVar()));

        addConstraint("C27 - dppm_vm_5.eq(dppm_vm_6).imp(dppm_vs_5.ne(dppm_vs_6)).post();",
                startIdx);
    }

    private void constraintGroup2() {
        int startIdx = modelKB.getNbCstrs();

        // C28 - dppm_vs_0.ne(dppm_vs_1).post();
        modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"!=", ((IntVariable)variableList.get(8)).getChocoVar()).post();

        addConstraint("C28 - dppm_vs_0.ne(dppm_vs_1).post();",
                startIdx);

        // C29 - dppm_vs_0.ne(dppm_vs_2).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"!=", ((IntVariable)variableList.get(9)).getChocoVar()).post();

        addConstraint("C29 - dppm_vs_0.ne(dppm_vs_2).post();",
                startIdx);

        // C30 - dppm_vs_0.ne(dppm_vs_3).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"!=", ((IntVariable)variableList.get(10)).getChocoVar()).post();

        addConstraint("C30 - dppm_vs_0.ne(dppm_vs_3).post();",
                startIdx);

        // C31 - dppm_vs_0.ne(dppm_vs_4).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"!=", ((IntVariable)variableList.get(11)).getChocoVar()).post();

        addConstraint("C31 - dppm_vs_0.ne(dppm_vs_4).post();",
                startIdx);

        // C32 - dppm_vs_0.ne(dppm_vs_5).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"!=", ((IntVariable)variableList.get(12)).getChocoVar()).post();

        addConstraint("C32 - dppm_vs_0.ne(dppm_vs_5).post();",
                startIdx);

        // C33 - dppm_vs_1.ne(dppm_vs_2).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"!=", ((IntVariable)variableList.get(9)).getChocoVar()).post();

        addConstraint("C33 - dppm_vs_1.ne(dppm_vs_2).post();",
                startIdx);

        // C34 - dppm_vs_1.ne(dppm_vs_3).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"!=", ((IntVariable)variableList.get(10)).getChocoVar()).post();

        addConstraint("C34 - dppm_vs_1.ne(dppm_vs_3).post();",
                startIdx);

        // C35 - dppm_vs_1.ne(dppm_vs_4).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"!=", ((IntVariable)variableList.get(11)).getChocoVar()).post();

        addConstraint("C35 - dppm_vs_1.ne(dppm_vs_4).post();",
                startIdx);

        // C36 - dppm_vs_1.ne(dppm_vs_5).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"!=", ((IntVariable)variableList.get(12)).getChocoVar()).post();

        addConstraint("C36 - dppm_vs_1.ne(dppm_vs_5).post();",
                startIdx);

        // C37 - dppm_vs_2.ne(dppm_vs_3).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(9)).getChocoVar(),"!=", ((IntVariable)variableList.get(10)).getChocoVar()).post();

        addConstraint("C37 - dppm_vs_2.ne(dppm_vs_3).post();",
                startIdx);

        // C38 - dppm_vs_2.ne(dppm_vs_4).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(9)).getChocoVar(),"!=", ((IntVariable)variableList.get(11)).getChocoVar()).post();

        addConstraint("C38 - dppm_vs_2.ne(dppm_vs_4).post();",
                startIdx);

        // C39 - dppm_vs_2.ne(dppm_vs_5).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(9)).getChocoVar(),"!=", ((IntVariable)variableList.get(12)).getChocoVar()).post();

        addConstraint("C39 - dppm_vs_2.ne(dppm_vs_5).post();",
                startIdx);

        // C40 - dppm_vs_3.ne(dppm_vs_4).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(10)).getChocoVar(),"!=", ((IntVariable)variableList.get(11)).getChocoVar()).post();

        addConstraint("C40 - dppm_vs_3.ne(dppm_vs_4).post();",
                startIdx);

        // C41 - dppm_vs_3.ne(dppm_vs_5).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(10)).getChocoVar(),"!=", ((IntVariable)variableList.get(12)).getChocoVar()).post();

        addConstraint("C41 - dppm_vs_3.ne(dppm_vs_5).post();",
                startIdx);

        // C42 - dppm_vs_4.ne(dppm_vs_5).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(11)).getChocoVar(),"!=", ((IntVariable)variableList.get(12)).getChocoVar()).post();

        addConstraint("C42 - dppm_vs_4.ne(dppm_vs_5).post();",
                startIdx);
    }

    private void constraintGroup3() {
        // C43 - m.arithm(dppm_vs_0, "<", dppm_vs_1).post();
        int startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"<", ((IntVariable)variableList.get(8)).getChocoVar()).post();

        addConstraint("c1 - m.arithm(dppm_vs_0, \"<\", dppm_vs_1).post();",
                startIdx);

        // C44 - m.arithm(dppm_vs_0, "<", dppm_vs_2).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"<", ((IntVariable)variableList.get(9)).getChocoVar()).post();

        addConstraint("c2 - m.arithm(dppm_vs_0, \"<\", dppm_vs_2).post();",
                startIdx);

        // C45 - m.arithm(dppm_vs_0, "<", dppm_vs_3).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"<", ((IntVariable)variableList.get(10)).getChocoVar()).post();

        addConstraint("c3 - m.arithm(dppm_vs_0, \"<\", dppm_vs_3).post();",
                startIdx);

        // C46 - m.arithm(dppm_vs_0, "<", dppm_vs_4).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"<", ((IntVariable)variableList.get(11)).getChocoVar()).post();

        addConstraint("c4 - m.arithm(dppm_vs_0, \"<\", dppm_vs_4).post();",
                startIdx);

        // C47 - m.arithm(dppm_vs_0, "<", dppm_vs_5).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(7)).getChocoVar(),"<", ((IntVariable)variableList.get(12)).getChocoVar()).post();

        addConstraint("c5 - m.arithm(dppm_vs_0, \"<\", dppm_vs_5).post();",
                startIdx);

        // C48 - m.arithm(dppm_vs_1, "<", dppm_vs_6).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"<", ((IntVariable)variableList.get(13)).getChocoVar()).post();

        addConstraint("c6 - m.arithm(dppm_vs_1, \"<\", dppm_vs_6).post();",
                startIdx);

        // C49 - m.arithm(dppm_vs_2, "<", dppm_vs_6).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(9)).getChocoVar(),"<", ((IntVariable)variableList.get(13)).getChocoVar()).post();

        addConstraint("c7 - m.arithm(dppm_vs_2, \"<\", dppm_vs_6).post();",
                startIdx);

        // C50 - m.arithm(dppm_vs_3, "<", dppm_vs_6).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(10)).getChocoVar(),"<", ((IntVariable)variableList.get(13)).getChocoVar()).post();

        addConstraint("c8 - m.arithm(dppm_vs_3, \"<\", dppm_vs_6).post();",
                startIdx);

        // C51 - m.arithm(dppm_vs_4, "<", dppm_vs_6).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(11)).getChocoVar(),"<", ((IntVariable)variableList.get(13)).getChocoVar()).post();

        addConstraint("c9 - m.arithm(dppm_vs_4, \"<\", dppm_vs_6).post();",
                startIdx);

        // C52 - m.arithm(dppm_vs_5, "<", dppm_vs_6).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(12)).getChocoVar(),"<", ((IntVariable)variableList.get(13)).getChocoVar()).post();

        addConstraint("c10 - m.arithm(dppm_vs_5, \"<\", dppm_vs_6).post();",
                startIdx);

        // C53 - m.arithm(dppm_vs_3, "<", dppm_vs_0).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(10)).getChocoVar(),"<", ((IntVariable)variableList.get(7)).getChocoVar()).post();

        addConstraint("c11 - m.arithm(dppm_vs_3, \"<\", dppm_vs_0).post();",
                startIdx);

        // C54 - constraint c[12] -> ((vs[1] < vs[2] /\ vs[3] < vs[2]) -> vm[2] = 0);
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.and(modelKB.arithm(((IntVariable)variableList.get(8)).getChocoVar(),"<", ((IntVariable)variableList.get(9)).getChocoVar()),
                        modelKB.arithm(((IntVariable)variableList.get(10)).getChocoVar(),"<", ((IntVariable)variableList.get(9)).getChocoVar())),
                modelKB.arithm(((IntVariable)variableList.get(2)).getChocoVar(),"=",0));

        addConstraint("c12 - constraint c[12] -> ((vs[1] < vs[2] /\\ vs[3] < vs[2]) -> vm[2] = 0);",
                startIdx);

        // C55 - constraint c[13] -> ((vs[2] < vs[3] /\ vs[4] < vs[3]) -> vm[3] = 0);
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.and(modelKB.arithm(((IntVariable)variableList.get(9)).getChocoVar(),"<", ((IntVariable)variableList.get(10)).getChocoVar()),
                        modelKB.arithm(((IntVariable)variableList.get(11)).getChocoVar(),"<", ((IntVariable)variableList.get(10)).getChocoVar())),
                modelKB.arithm(((IntVariable)variableList.get(3)).getChocoVar(),"=",0));

        addConstraint("c13 - constraint c[13] -> ((vs[2] < vs[3] /\\ vs[4] < vs[3]) -> vm[3] = 0);",
                startIdx);

        // C56 - constraint c[14] -> ((vs[3] < vs[4] /\ vs[5] < vs[4]) -> vm[4] = 0);
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.and(modelKB.arithm(((IntVariable)variableList.get(10)).getChocoVar(),"<", ((IntVariable)variableList.get(11)).getChocoVar()),
                        modelKB.arithm(((IntVariable)variableList.get(12)).getChocoVar(),"<", ((IntVariable)variableList.get(11)).getChocoVar())),
                modelKB.arithm(((IntVariable)variableList.get(4)).getChocoVar(),"=",0));

        addConstraint("c14 - constraint c[14] -> ((vs[3] < vs[4] /\\ vs[5] < vs[4]) -> vm[4] = 0);",
                startIdx);
    }

    private void constraintGroup4() {
        // C57 - m.max(dppm_vmakespan, vs_array).post();
        int startIdx = modelKB.getNbCstrs();
        IntVar[] vs_array = new IntVar[]{((IntVariable)variableList.get(7)).getChocoVar(),
                ((IntVariable)variableList.get(8)).getChocoVar(),
                ((IntVariable)variableList.get(9)).getChocoVar(),
                ((IntVariable)variableList.get(10)).getChocoVar(),
                ((IntVariable)variableList.get(11)).getChocoVar(),
                ((IntVariable)variableList.get(12)).getChocoVar(),
                ((IntVariable)variableList.get(13)).getChocoVar()};
        modelKB.max(((IntVariable)variableList.get(17)).getChocoVar(), vs_array).post();

        addConstraint("C57 - m.max(dppm_vmakespan, vs_array).post();",
                startIdx);

        // C58 - dppm_vmakespan.le(5).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(((IntVariable)variableList.get(17)).getChocoVar(), "<=", 5).post();

        addConstraint("c15 - dppm_vmakespan.le(5).post();",
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
