package at.tugraz.ist.ase.flexdiagtest.test;

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
public class NOK1_3KB_new2 extends KB {

    public NOK1_3KB_new2() {
        super("NOK1_3_new2", "producibility.mzn", false);

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
//        defineDomains();
        defineVariables();
        defineConstraints(hasNegativeConstraints);

        LoggerUtils.outdent();
        log.debug("{}<<< Created NOK1_3_new", LoggerUtils.tab);
    }

    private void defineDomains() {
//        log.trace("{}Defining domains >>>", LoggerUtils.tab);
//        LoggerUtils.indent();
//
//        domainList.add(Domain.builder()
//                .name("dppm_vm_0")
//                .values(List.of("0", "1", "2", "3"))
//                .chocoValues(List.of(0, 1, 2, 3))
//                .build());
//        domainList.add(Domain.builder()
//                .name("dppm_vm_1")
//                .values(List.of("0", "1", "2", "3"))
//                .chocoValues(List.of(0, 1, 2, 3))
//                .build());
//        domainList.add(Domain.builder()
//                .name("dppm_vm_2")
//                .values(List.of("0", "1", "2", "3"))
//                .chocoValues(List.of(0, 1, 2, 3))
//                .build());
//        domainList.add(Domain.builder()
//                .name("dppm_vm_3")
//                .values(List.of("0", "1", "2", "3"))
//                .chocoValues(List.of(0, 1, 2, 3))
//                .build());
//        domainList.add(Domain.builder()
//                .name("dppm_vm_4")
//                .values(List.of("0", "1", "2", "3"))
//                .chocoValues(List.of(0, 1, 2, 3))
//                .build());
//        domainList.add(Domain.builder()
//                .name("dppm_vm_5")
//                .values(List.of("0", "1", "2", "3"))
//                .chocoValues(List.of(0, 1, 2, 3))
//                .build());
//        domainList.add(Domain.builder()
//                .name("dppm_vm_6")
//                .values(List.of("0", "1", "2", "3"))
//                .chocoValues(List.of(0, 1, 2, 3))
//                .build());
//        domainList.add(Domain.builder()
//                .name("dppm_vs_0")
//                .values(List.of("0", "1", "2", "3", "4", "5", "6"))
//                .chocoValues(List.of(0, 1, 2, 3, 4, 5, 6))
//                .build());
//        domainList.add(Domain.builder()
//                .name("dppm_vs_1")
//                .values(List.of("0", "1", "2", "3", "4", "5", "6"))
//                .chocoValues(List.of(0, 1, 2, 3, 4, 5, 6))
//                .build());
//        domainList.add(Domain.builder()
//                .name("dppm_vs_2")
//                .values(List.of("0", "1", "2", "3", "4", "5", "6"))
//                .chocoValues(List.of(0, 1, 2, 3, 4, 5, 6))
//                .build());
//        domainList.add(Domain.builder()
//                .name("dppm_vs_3")
//                .values(List.of("0", "1", "2", "3", "4", "5", "6"))
//                .chocoValues(List.of(0, 1, 2, 3, 4, 5, 6))
//                .build());
//        domainList.add(Domain.builder()
//                .name("dppm_vs_4")
//                .values(List.of("0", "1", "2", "3", "4", "5", "6"))
//                .chocoValues(List.of(0, 1, 2, 3, 4, 5, 6))
//                .build());
//        domainList.add(Domain.builder()
//                .name("dppm_vs_5")
//                .values(List.of("0", "1", "2", "3", "4", "5", "6"))
//                .chocoValues(List.of(0, 1, 2, 3, 4, 5, 6))
//                .build());
//        domainList.add(Domain.builder()
//                .name("dppm_vs_6")
//                .values(List.of("0", "1", "2", "3", "4", "5", "6"))
//                .chocoValues(List.of(0, 1, 2, 3, 4, 5, 6))
//                .build());
//
//        LoggerUtils.outdent();
//        log.debug("{}<<< Created domains", LoggerUtils.tab);
    }

    private IntVar vm_0;
    private IntVar vm_1;
    private IntVar vm_2;
    private IntVar vm_3;
    private IntVar vm_4;
    private IntVar vm_5;
    private IntVar vm_6;
    private IntVar vs_0;
    private IntVar vs_1;
    private IntVar vs_2;
    private IntVar vs_3;
    private IntVar vs_4;
    private IntVar vs_5;
    private IntVar vs_6;
    private IntVar[] vs;// = new IntVar[] {vs_0, vs_1, vs_2, vs_3, vs_4, vs_5, vs_6};
    private IntVar makespan;

    public void defineVariables (){
        log.trace("{}Defining variables >>", LoggerUtils.tab);
        LoggerUtils.indent();

//        List<String> varNames = List.of("dppm_vm_0", "dppm_vm_1", "dppm_vm_2", "dppm_vm_3", "dppm_vm_4", "dppm_vm_5", "dppm_vm_6",
//                                        "dppm_vs_0", "dppm_vs_1", "dppm_vs_2", "dppm_vs_3", "dppm_vs_4", "dppm_vs_5", "dppm_vs_6");
//
//        for (int i = 0; i < varNames.size(); i++) {
//            String varName = varNames.get(i);
//            IntVar intVar = this.modelKB.intVar(varName, domainList.get(i).getIntValues());
//            Variable var = IntVariable.builder()
//                    .name(varName)
//                    .domain(domainList.get(i))
//                    .chocoVar(intVar).build();
//            variableList.add(var);
//        }
//
//        // v_tmp_1 - V14
//        Domain d = Domain.builder()
//                .name("v_tmp_1")
//                .build();
//        domainList.add(d);
//        BoolVar boolVar = this.modelKB.boolVar("v_tmp_1");
//        Variable var = BoolVariable.builder()
//                .name("v_tmp_1")
//                .domain(d)
//                .chocoVar(boolVar)
//                .build();
//        variableList.add(var);
//
//        // v_tmp_2 - V15
//        d = Domain.builder()
//                .name("v_tmp_2")
//                .build();
//        domainList.add(d);
//        boolVar = this.modelKB.boolVar("v_tmp_2");
//        var = BoolVariable.builder()
//                .name("v_tmp_2")
//                .domain(d)
//                .chocoVar(boolVar)
//                .build();
//        variableList.add(var);
//
//        // v_tmp_3 - V16
//        d = Domain.builder()
//                .name("v_tmp_3")
//                .build();
//        domainList.add(d);
//        boolVar = this.modelKB.boolVar("v_tmp_3");
//        var = BoolVariable.builder()
//                .name("v_tmp_3")
//                .domain(d)
//                .chocoVar(boolVar)
//                .build();
//        variableList.add(var);
//
//        // dppm_vmakespan - V17
//        d = Domain.builder()
//                .name("dppm_vmakespan")
//                .values(List.of("0", "1", "2", "3", "4", "5", "6"))
//                .chocoValues(List.of(0, 1, 2, 3, 4, 5, 6))
//                .build();
//        domainList.add(d);
//        IntVar intVar = this.modelKB.intVar("dppm_vmakespan", d.getIntValues());
//        var = IntVariable.builder()
//                .name("dppm_vmakespan")
//                .domain(d)
//                .chocoVar(intVar).build();
//        variableList.add(var);

        vm_0 = this.modelKB.intVar("dppm_vm_0", new int[] {0, 1, 2, 3});
        vm_1 = this.modelKB.intVar("dppm_vm_1", new int[] {0, 1, 2, 3});
        vm_2 = this.modelKB.intVar("dppm_vm_2", new int[] {0, 1, 2, 3});
        vm_3 = this.modelKB.intVar("dppm_vm_3", new int[] {0, 1, 2, 3});
        vm_4 = this.modelKB.intVar("dppm_vm_4", new int[] {0, 1, 2, 3});
        vm_5 = this.modelKB.intVar("dppm_vm_5", new int[] {0, 1, 2, 3});
        vm_6 = this.modelKB.intVar("dppm_vm_6", new int[] {0, 1, 2, 3});
        vs_0 = this.modelKB.intVar("dppm_vs_0", new int[] {0, 1, 2, 3, 4, 5, 6});
        vs_1 = this.modelKB.intVar("dppm_vs_1", new int[] {0, 1, 2, 3, 4, 5, 6});
        vs_2 = this.modelKB.intVar("dppm_vs_2", new int[] {0, 1, 2, 3, 4, 5, 6});
        vs_3 = this.modelKB.intVar("dppm_vs_3", new int[] {0, 1, 2, 3, 4, 5, 6});
        vs_4 = this.modelKB.intVar("dppm_vs_4", new int[] {0, 1, 2, 3, 4, 5, 6});
        vs_5 = this.modelKB.intVar("dppm_vs_5", new int[] {0, 1, 2, 3, 4, 5, 6});
        vs_6 = this.modelKB.intVar("dppm_vs_6", new int[] {0, 1, 2, 3, 4, 5, 6});
        makespan = this.modelKB.intVar("dppm_vmakespan", new int[] {0, 1, 2, 3, 4, 5, 6});

        vs = new IntVar[]{vs_0, vs_1, vs_2, vs_3, vs_4, vs_5, vs_6};

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
        modelKB.member(vm_0, new int[]{0, 1}).post();

        addConstraint("C0", startIdx);

        // C1 - constraint vm[1] in {2,3};
        startIdx = modelKB.getNbCstrs();
        modelKB.member(vm_1, new int[]{2, 3}).post();

        addConstraint("C1", startIdx);

        // C2 - constraint vm[2] in {2,3};
        startIdx = modelKB.getNbCstrs();
        modelKB.member(vm_2, new int[]{2, 3}).post();

        addConstraint("C2", startIdx);

        // C3 - constraint vm[3] in {2,3};
        startIdx = modelKB.getNbCstrs();
        modelKB.member(vm_3, new int[]{2, 3}).post();

        addConstraint("C3", startIdx);

        // C4 - constraint vm[4] in {2,3};
        startIdx = modelKB.getNbCstrs();
        modelKB.member(vm_4, new int[]{2, 3}).post();

        addConstraint("C4", startIdx);

        // C5 - constraint vm[5] in {2};
        startIdx = modelKB.getNbCstrs();
//        modelKB.member(((IntVariable)variableList.get(5)).getChocoVar(), new int[]{2}).post();
        modelKB.arithm(vm_5, "=", 2).post();

        addConstraint("C5", startIdx);

        // C6 - constraint vm[6] in {0,1};
        startIdx = modelKB.getNbCstrs();
        modelKB.member(vm_6, new int[]{0, 1}).post();

        addConstraint("C6", startIdx);
    }

    private void constraintGroup1() {
        // Constraint 7 - dppm_vm_0.eq(dppm_vm_1).imp(dppm_vs_0.ne(dppm_vs_1)).post();
        int startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(vm_0,"=", vm_1),
                modelKB.arithm(vs_0,"!=", vs_1));

        addConstraint("C7",
                startIdx);

        // Constraint 8 - dppm_vm_0.eq(dppm_vm_2).imp(dppm_vs_0.ne(dppm_vs_2)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(vm_0,"=", vm_2),
                modelKB.arithm(vs_0,"!=", vs_2));

        addConstraint("C8",
                startIdx);

        // Constraint 9 - dppm_vm_0.eq(dppm_vm_3).imp(dppm_vs_0.ne(dppm_vs_3)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(vm_0,"=", vm_3),
                modelKB.arithm(vs_0,"!=", vs_3));

        addConstraint("C9",
                startIdx);

        // Constraint 10 - dppm_vm_0.eq(dppm_vm_4).imp(dppm_vs_0.ne(dppm_vs_4)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(vm_0,"=", vm_4),
                modelKB.arithm(vs_0,"!=", vs_4));

        addConstraint("C10",
                startIdx);

        // Constraint 11 - dppm_vm_0.eq(dppm_vm_5).imp(dppm_vs_0.ne(dppm_vs_5)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(vm_0,"=", vm_5),
                modelKB.arithm(vs_0,"!=", vs_5));

        addConstraint("C11",
                startIdx);

        // Constraint 12 - dppm_vm_0.eq(dppm_vm_6).imp(dppm_vs_0.ne(dppm_vs_6)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(vm_0,"=", vm_6),
                modelKB.arithm(vs_0,"!=", vs_6));

        addConstraint("C12",
                startIdx);

        // Constraint 13 - dppm_vm_1.eq(dppm_vm_2).imp(dppm_vs_1.ne(dppm_vs_2)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(vm_1,"=", vm_2),
                modelKB.arithm(vs_1,"!=", vs_2));

        addConstraint("C13",
                startIdx);

        // Constraint 14 - dppm_vm_1.eq(dppm_vm_3).imp(dppm_vs_1.ne(dppm_vs_3)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(vm_1,"=", vm_3),
                modelKB.arithm(vs_1,"!=", vs_3));

        addConstraint("C14",
                startIdx);

        // Constraint 15 - dppm_vm_1.eq(dppm_vm_4).imp(dppm_vs_1.ne(dppm_vs_4)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(vm_1,"=", vm_4),
                modelKB.arithm(vs_1,"!=", vs_4));

        addConstraint("C15",
                startIdx);

        // Constraint 16 - dppm_vm_1.eq(dppm_vm_5).imp(dppm_vs_1.ne(dppm_vs_5)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(vm_1,"=", vm_5),
                modelKB.arithm(vs_1,"!=", vs_5));

        addConstraint("C16",
                startIdx);

        // Constraint 17 - dppm_vm_1.eq(dppm_vm_6).imp(dppm_vs_1.ne(dppm_vs_6)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(vm_1,"=", vm_6),
                modelKB.arithm(vs_1,"!=", vs_6));

        addConstraint("C17",
                startIdx);

        // Constraint 18 - dppm_vm_2.eq(dppm_vm_3).imp(dppm_vs_2.ne(dppm_vs_3)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(vm_2,"=", vm_3),
                modelKB.arithm(vs_2,"!=", vs_3));

        addConstraint("C18",
                startIdx);

        // Constraint 19 - dppm_vm_2.eq(dppm_vm_4).imp(dppm_vs_2.ne(dppm_vs_4)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(vm_2,"=", vm_4),
                modelKB.arithm(vs_2,"!=", vs_4));

        addConstraint("C19",
                startIdx);

        // Constraint 20 - dppm_vm_2.eq(dppm_vm_5).imp(dppm_vs_2.ne(dppm_vs_5)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(vm_2,"=", vm_5),
                modelKB.arithm(vs_2,"!=", vs_5));

        addConstraint("C20",
                startIdx);

        // Constraint 21 - dppm_vm_2.eq(dppm_vm_6).imp(dppm_vs_2.ne(dppm_vs_6)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(vm_2,"=", vm_6),
                modelKB.arithm(vs_2,"!=", vs_6));

        addConstraint("C21",
                startIdx);

        // Constraint 22 - dppm_vm_3.eq(dppm_vm_4).imp(dppm_vs_3.ne(dppm_vs_4)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(vm_3,"=", vm_4),
                modelKB.arithm(vs_3,"!=", vs_4));

        addConstraint("C22",
                startIdx);

        // Constraint 23 - dppm_vm_3.eq(dppm_vm_5).imp(dppm_vs_3.ne(dppm_vs_5)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(vm_3,"=", vm_5),
                modelKB.arithm(vs_3,"!=", vs_5));

        addConstraint("C23",
                startIdx);

        // Constraint 24 - dppm_vm_3.eq(dppm_vm_6).imp(dppm_vs_3.ne(dppm_vs_6)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(vm_3,"=", vm_6),
                modelKB.arithm(vs_3,"!=", vs_6));

        addConstraint("C24",
                startIdx);

        // Constraint 25 - dppm_vm_4.eq(dppm_vm_5).imp(dppm_vs_4.ne(dppm_vs_5)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(vm_4,"=", vm_5),
                modelKB.arithm(vs_4,"!=", vs_5));

        addConstraint("C25",
                startIdx);

        // Constraint 26 - dppm_vm_4.eq(dppm_vm_6).imp(dppm_vs_4.ne(dppm_vs_6)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(vm_4,"=", vm_6),
                modelKB.arithm(vs_4,"!=", vs_6));

        addConstraint("C26",
                startIdx);

        // Constraint 27 - dppm_vm_5.eq(dppm_vm_6).imp(dppm_vs_5.ne(dppm_vs_6)).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.arithm(vm_5,"=", vm_6),
                modelKB.arithm(vs_5,"!=", vs_6));

        addConstraint("C27",
                startIdx);
    }

    private void constraintGroup2() {
        int startIdx = modelKB.getNbCstrs();

        // Constraint 28 - dppm_vs_0.ne(dppm_vs_1).post();
        modelKB.arithm(vs_0,"!=", vs_1).post();

        addConstraint("C28",
                startIdx);

        // Constraint 29 - dppm_vs_0.ne(dppm_vs_2).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(vs_0,"!=", vs_2).post();

        addConstraint("C29",
                startIdx);

        // Constraint 30 - dppm_vs_0.ne(dppm_vs_3).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(vs_0,"!=", vs_3).post();

        addConstraint("C30",
                startIdx);

        // Constraint 31 - dppm_vs_0.ne(dppm_vs_4).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(vs_0,"!=", vs_4).post();

        addConstraint("C31",
                startIdx);

        // Constraint 32 - dppm_vs_0.ne(dppm_vs_5).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(vs_0,"!=", vs_5).post();

        addConstraint("C32",
                startIdx);

        // Constraint 33 - dppm_vs_1.ne(dppm_vs_2).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(vs_1,"!=", vs_2).post();

        addConstraint("C33",
                startIdx);

        // Constraint 34 - dppm_vs_1.ne(dppm_vs_3).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(vs_1,"!=", vs_3).post();

        addConstraint("C34",
                startIdx);

        // Constraint 35 - dppm_vs_1.ne(dppm_vs_4).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(vs_1,"!=", vs_4).post();

        addConstraint("C35",
                startIdx);

        // Constraint 36 - dppm_vs_1.ne(dppm_vs_5).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(vs_1,"!=", vs_5).post();

        addConstraint("C36",
                startIdx);

        // Constraint 37 - dppm_vs_2.ne(dppm_vs_3).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(vs_2,"!=", vs_3).post();

        addConstraint("C37",
                startIdx);

        // Constraint 38 - dppm_vs_2.ne(dppm_vs_4).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(vs_2,"!=", vs_4).post();

        addConstraint("C38",
                startIdx);

        // Constraint 39 - dppm_vs_2.ne(dppm_vs_5).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(vs_2,"!=", vs_5).post();

        addConstraint("C39",
                startIdx);

        // Constraint 40 - dppm_vs_3.ne(dppm_vs_4).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(vs_3,"!=", vs_4).post();

        addConstraint("C40",
                startIdx);

        // Constraint 41 - dppm_vs_3.ne(dppm_vs_5).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(vs_3,"!=", vs_5).post();

        addConstraint("C41",
                startIdx);

        // Constraint 42 - dppm_vs_4.ne(dppm_vs_5).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(vs_4,"!=", vs_5).post();

        addConstraint("C42",
                startIdx);

        // Constraint 43 - constraint dppm_vmakespan = max(vs);
        startIdx = modelKB.getNbCstrs();
//        IntVar[] vs_array = new IntVar[]{((IntVariable)variableList.get(7)).getChocoVar(),
//                                            ((IntVariable)variableList.get(8)).getChocoVar(),
//                                            ((IntVariable)variableList.get(9)).getChocoVar(),
//                                            ((IntVariable)variableList.get(10)).getChocoVar(),
//                                            ((IntVariable)variableList.get(11)).getChocoVar(),
//                                            ((IntVariable)variableList.get(12)).getChocoVar(),
//                                            ((IntVariable)variableList.get(13)).getChocoVar()};
        modelKB.max(makespan, vs).post();

        addConstraint("C43",
                startIdx);
    }

    private void constraintGroup3() {
        // c1 - Constraint 44 - m.arithm(dppm_vs_0, "<", dppm_vs_1).post();
        int startIdx = modelKB.getNbCstrs();
        modelKB.arithm(vs_0,"<", vs_1).post();

        addConstraint("c1",
                startIdx);

        // c2 - Constraint 45 - m.arithm(dppm_vs_0, "<", dppm_vs_2).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(vs_0,"<", vs_2).post();

        addConstraint("c2",
                startIdx);

        // c3 - Constraint 46 - m.arithm(dppm_vs_0, "<", dppm_vs_3).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(vs_0,"<", vs_3).post();

        addConstraint("c3",
                startIdx);

        // c4 - Constraint 47 - m.arithm(dppm_vs_0, "<", dppm_vs_4).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(vs_0,"<", vs_4).post();

        addConstraint("c4",
                startIdx);

        // c5 - Constraint 48 - m.arithm(dppm_vs_0, "<", dppm_vs_5).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(vs_0,"<", vs_5).post();

        addConstraint("c5",
                startIdx);

        // c6 - Constraint 49 - m.arithm(dppm_vs_1, "<", dppm_vs_6).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(vs_1,"<", vs_6).post();

        addConstraint("c6",
                startIdx);

        // c7 - Constraint 50 - m.arithm(dppm_vs_2, "<", dppm_vs_6).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(vs_2,"<", vs_6).post();

        addConstraint("c7",
                startIdx);

        // c8 - Constraint 51 - m.arithm(dppm_vs_3, "<", dppm_vs_6).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(vs_3,"<", vs_6).post();

        addConstraint("c8",
                startIdx);

        // c9 - Constraint 52 - m.arithm(dppm_vs_4, "<", dppm_vs_6).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(vs_4,"<", vs_6).post();

        addConstraint("c9",
                startIdx);

        // c10 - Constraint 53 - m.arithm(dppm_vs_5, "<", dppm_vs_6).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(vs_5,"<", vs_6).post();

        addConstraint("c10",
                startIdx);

        // c11 - Constraint 54 - m.arithm(dppm_vs_3, "<", dppm_vs_0).post();
        startIdx = modelKB.getNbCstrs();
        modelKB.arithm(vs_3,"<", vs_0).post();

        addConstraint("c11",
                startIdx);

        // c12 - Constraint 55 - constraint c[12] -> ((vs[1] < vs[2] /\ vs[3] < vs[2]) -> vm[2] = 0);
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.and(modelKB.arithm(vs_1,"<", vs_2),
                        modelKB.arithm(vs_3,"<", vs_2)),
                modelKB.arithm(vm_2,"=",0));

        addConstraint("c12",
                startIdx);

        // c13 - Constraint 56 - constraint c[13] -> ((vs[2] < vs[3] /\ vs[4] < vs[3]) -> vm[3] = 0);
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.and(modelKB.arithm(vs_2,"<", vs_3),
                        modelKB.arithm(vs_4,"<", vs_3)),
                modelKB.arithm(vm_3,"=",0));

        addConstraint("c13",
                startIdx);

        // c14 - Constraint 57 - constraint c[14] -> ((vs[3] < vs[4] /\ vs[5] < vs[4]) -> vm[4] = 0);
        startIdx = modelKB.getNbCstrs();
        modelKB.ifThen(modelKB.and(modelKB.arithm(vs_3,"<", vs_4),
                        modelKB.arithm(vs_5,"<", vs_4)),
                modelKB.arithm(vm_4,"=",0));

        addConstraint("c14",
                startIdx);
    }

    private void constraintGroup4() {
//        // Constraint 51 - constraint dppm_vmakespan = max(vs);
//        int startIdx = modelKB.getNbCstrs();
////        IntVar[] vs_array = new IntVar[]{((IntVariable)variableList.get(7)).getChocoVar(),
////                                            ((IntVariable)variableList.get(8)).getChocoVar(),
////                                            ((IntVariable)variableList.get(9)).getChocoVar(),
////                                            ((IntVariable)variableList.get(10)).getChocoVar(),
////                                            ((IntVariable)variableList.get(11)).getChocoVar(),
////                                            ((IntVariable)variableList.get(12)).getChocoVar(),
////                                            ((IntVariable)variableList.get(13)).getChocoVar()};
//        modelKB.max(makespan, vs).post();
//
//        addConstraint("Constraint 51 - m.max(dppm_vmakespan, vs_array).post();",
//                startIdx);

        // Constraint 58 - dppm_vmakespan.le(5).post();
        int startIdx = modelKB.getNbCstrs();
        modelKB.arithm(makespan, "<=", 5).post();

        addConstraint("c15",
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
