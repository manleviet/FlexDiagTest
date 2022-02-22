package at.tugraz.ist.ase.flexdiagtest;

import at.tugraz.ist.ase.knowledgebases.core.Constraint;
import at.tugraz.ist.ase.knowledgebases.core.Variable;
import org.chocosolver.solver.Model;

public class MainV1 {
    public static void main(String[] args) {
        // create the model
        NOK1_1KB nok1_1KB = new NOK1_1KB();

        System.out.println(nok1_1KB);
        // print all constraints
        for (Constraint c : nok1_1KB.getConstraintList()) {
            System.out.println(c);
            c.getChocoConstraints().forEach(System.out::println);
            System.out.println();
        }

        Model model = nok1_1KB.getModelKB();
        model.getSolver().solve(); // identify a configuration

        System.out.println("Configuration:");
        for (Variable v : nok1_1KB.getVariableList()) {
            System.out.println(v.getName() + " = " + v.getValue());
        }
    }
}
