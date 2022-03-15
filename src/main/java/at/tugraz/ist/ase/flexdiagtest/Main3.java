package at.tugraz.ist.ase.flexdiagtest;

import at.tugraz.ist.ase.knowledgebases.core.IntVariable;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.constraints.Constraint;
import org.chocosolver.solver.exception.ContradictionException;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.solver.variables.Variable;

public class Main3 {
    public static void main(String[] args) {
        Model model = new Model();

        IntVar vm0 = model.intVar("vm0", new int[]{0, 1, 2, 3});
        IntVar vm1 = model.intVar("vm1", new int[]{0, 1, 2, 3});
        IntVar vm2 = model.intVar("vm2", new int[]{0, 1, 2, 3});
        IntVar vm3 = model.intVar("vm3", new int[]{0, 1, 2, 3});
        IntVar vm4 = model.intVar("vm4", new int[]{0, 1, 2, 3});
        IntVar vm5 = model.intVar("vm5", new int[]{0, 1, 2, 3});
        IntVar vm6 = model.intVar("vm6", new int[]{0, 1, 2, 3});

        IntVar vs0 = model.intVar("vs0", new int[]{0, 1, 2, 3, 4, 5, 6});
        IntVar vs1 = model.intVar("vs1", new int[]{0, 1, 2, 3, 4, 5, 6});
        IntVar vs2 = model.intVar("vs2", new int[]{0, 1, 2, 3, 4, 5, 6});
        IntVar vs3 = model.intVar("vs3", new int[]{0, 1, 2, 3, 4, 5, 6});
        IntVar vs4 = model.intVar("vs4", new int[]{0, 1, 2, 3, 4, 5, 6});
        IntVar vs5 = model.intVar("vs5", new int[]{0, 1, 2, 3, 4, 5, 6});
        IntVar vs6 = model.intVar("vs6", new int[]{0, 1, 2, 3, 4, 5, 6});

        IntVar[] vs_array = new IntVar[]{vs0, vs1, vs2, vs3, vs4, vs5, vs6};

        IntVar makespan = model.intVar("makespan", 0, 6);

        model.member(vm0, new int[]{0, 1}).post();
        model.member(vm1, new int[]{2, 3}).post();
        model.member(vm2, new int[]{2, 3}).post();
        model.member(vm3, new int[]{2, 3}).post();
        model.member(vm4, new int[]{2, 3}).post();
        model.arithm(vm5, "=", 2).post();
        model.member(vm6, new int[]{0, 1}).post();

        model.ifThen(model.arithm(vm0,"=", vm1), model.arithm(vs0,"!=", vs1));
        model.ifThen(model.arithm(vm0,"=", vm2), model.arithm(vs0,"!=", vs2));
        model.ifThen(model.arithm(vm0,"=", vm3), model.arithm(vs0,"!=", vs3));
        model.ifThen(model.arithm(vm0,"=", vm4), model.arithm(vs0,"!=", vs4));
        model.ifThen(model.arithm(vm0,"=", vm5), model.arithm(vs0,"!=", vs5));
        model.ifThen(model.arithm(vm0,"=", vm6), model.arithm(vs0,"!=", vs6));

        model.ifThen(model.arithm(vm1,"=", vm2), model.arithm(vs1,"!=", vs2));
        model.ifThen(model.arithm(vm1,"=", vm3), model.arithm(vs1,"!=", vs3));
        model.ifThen(model.arithm(vm1,"=", vm4), model.arithm(vs1,"!=", vs4));
        model.ifThen(model.arithm(vm1,"=", vm5), model.arithm(vs1,"!=", vs5));
        model.ifThen(model.arithm(vm1,"=", vm6), model.arithm(vs1,"!=", vs6));

        model.ifThen(model.arithm(vm2,"=", vm3), model.arithm(vs2,"!=", vs3));
        model.ifThen(model.arithm(vm2,"=", vm4), model.arithm(vs2,"!=", vs4));
        model.ifThen(model.arithm(vm2,"=", vm5), model.arithm(vs2,"!=", vs5));
        model.ifThen(model.arithm(vm2,"=", vm6), model.arithm(vs2,"!=", vs6));

        model.ifThen(model.arithm(vm3,"=", vm4), model.arithm(vs3,"!=", vs4));
        model.ifThen(model.arithm(vm3,"=", vm5), model.arithm(vs3,"!=", vs5));
        model.ifThen(model.arithm(vm3,"=", vm6), model.arithm(vs3,"!=", vs6));

        model.ifThen(model.arithm(vm4,"=", vm5), model.arithm(vs4,"!=", vs5));
        model.ifThen(model.arithm(vm4,"=", vm6), model.arithm(vs4,"!=", vs6));

        model.ifThen(model.arithm(vm5,"=", vm6), model.arithm(vs5,"!=", vs6));

        model.arithm(vs0,"!=", vs1).post();
        model.arithm(vs0,"!=", vs2).post();
        model.arithm(vs0,"!=", vs3).post();
        model.arithm(vs0,"!=", vs4).post();
        model.arithm(vs0,"!=", vs5).post();

        model.arithm(vs1,"!=", vs2).post();
        model.arithm(vs1,"!=", vs3).post();
        model.arithm(vs1,"!=", vs4).post();
        model.arithm(vs1,"!=", vs5).post();

        model.arithm(vs2,"!=", vs3).post();
        model.arithm(vs2,"!=", vs4).post();
        model.arithm(vs2,"!=", vs5).post();

        model.arithm(vs3,"!=", vs4).post();
        model.arithm(vs3,"!=", vs5).post();

        model.arithm(vs4,"!=", vs5).post();

        model.max(makespan, vs_array).post();

        // Requirements
//        model.arithm(vs0,"<", vs1).post(); // c1
//        model.arithm(vs0,"<", vs2).post(); // c2
//        model.arithm(vs0, "<", vs3).post(); // c3
        model.arithm(vs0, "<", vs4).post(); // c4
        model.arithm(vs0, "<", vs5).post(); // c5

        model.arithm(vs1, "<", vs6).post(); // c6
        model.arithm(vs2, "<", vs6).post(); // c7
        model.arithm(vs3, "<", vs6).post(); // c8
        model.arithm(vs4, "<", vs6).post(); // c9
        model.arithm(vs5, "<", vs6).post(); // c10

        model.arithm(vs3, "<", vs0).post(); // c11

        model.ifThen(model.and(model.arithm(vs1,"<", vs2),
                        model.arithm(vs3,"<", vs2)),
                model.arithm(vm2,"=",0)); // c12

        model.ifThen(model.and(model.arithm(vs2,"<", vs3),
                        model.arithm(vs4,"<", vs3)),
                model.arithm(vm3,"=",0)); // c13

        model.ifThen(model.and(model.arithm(vs3,"<", vs4),
                        model.arithm(vs5,"<", vs4)),
                model.arithm(vm4,"=",0)); // c14

        model.arithm(makespan, "<=", 5).post(); // c15

        System.out.println("Constraints");
        for (Constraint c : model.getCstrs()) {
            System.out.println(c);
        }

        try {
            model.getSolver().propagate();
            System.out.println("Propagate ok");

            for (Variable var : model.getVars()) {
                IntVar intVar = (IntVar) var;
                System.out.println(intVar.getName() + " = " + intVar.getValue());
            }
        } catch (ContradictionException e) {
            System.out.println(e.getMessage());
        }

        if (model.getSolver().solve()) {
            System.out.println("OK");
        } else {
            System.out.println("FAIL");
        }

//        while (model.getSolver().solve()) {
//            System.out.println("Values:");
//            System.out.println("vm0:" + vm0.getValue());
//            System.out.println("vm1:" + vm1.getValue());
//            System.out.println("vm2:" + vm2.getValue());
//            System.out.println("vm3:" + vm3.getValue());
//            System.out.println("vm4:" + vm4.getValue());
//            System.out.println("vm5:" + vm5.getValue());
//            System.out.println("vm6:" + vm6.getValue());
//            System.out.println("vs0:" + vs0.getValue());
//            System.out.println("vs1:" + vs1.getValue());
//            System.out.println("vs2:" + vs2.getValue());
//            System.out.println("vs3:" + vs3.getValue());
//            System.out.println("vs4:" + vs4.getValue());
//            System.out.println("vs5:" + vs5.getValue());
//            System.out.println("vs6:" + vs6.getValue());
//            System.out.println("makespan:" + makespan.getValue());
//        }
    }
}
