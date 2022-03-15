package at.tugraz.ist.ase.flexdiagtest;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.constraints.Constraint;
import org.chocosolver.solver.variables.IntVar;

public class Main2 {
    public static void main(String[] args) {
        Model model = new Model();
        // Create a constant variable equal to 42
        IntVar v0 = model.intVar("v0", new int[]{0, 1});
// Create a variable taking its value in [1, 3] (the value is 1, 2 or 3)
        IntVar v1 = model.intVar("v1", 1, 3);
// Create a variable taking its value in {1, 3} (the value is 1 or 3)
        IntVar v2 = model.intVar("v2", new int[]{0, 1});

        model.ifThen(model.arithm(v0, "=", v1), model.arithm(v2, "=", 0));
        model.arithm(v1, "=", 1).post();
        model.arithm(v0, "=", 1).post();

        model.getSolver().solve();

        for (Constraint c : model.getCstrs()) {
            System.out.println(c);
        }

        System.out.println(v0.getValue());
        System.out.println(v1.getValue());
        System.out.println(v2.getValue());
    }
}
