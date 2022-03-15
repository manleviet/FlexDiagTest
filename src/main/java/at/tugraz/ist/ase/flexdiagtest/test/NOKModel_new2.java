package at.tugraz.ist.ase.flexdiagtest.test;

import at.tugraz.ist.ase.cdrmodel.CDRModel;
import at.tugraz.ist.ase.cdrmodel.IChocoModel;
import at.tugraz.ist.ase.common.LoggerUtils;
import at.tugraz.ist.ase.knowledgebases.core.Constraint;
import at.tugraz.ist.ase.knowledgebases.core.KB;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.chocosolver.solver.Model;

import java.util.LinkedList;
import java.util.List;

@Slf4j
public class NOKModel_new2 extends CDRModel implements IChocoModel {

    @Getter
    private final Model model;
    private final KB kb;

    public NOKModel_new2(KB kb) {
        super("kb");

        this.kb = kb;
        this.model = this.kb.getModelKB();
    }

    @Override
    public void initialize() {
        log.debug("{}Initializing the model for {} >>>", LoggerUtils.tab, getName());
        LoggerUtils.indent();

        // sets possibly faulty constraints to super class
        log.trace("{}Adding possibly faulty constraints", LoggerUtils.tab);
        List<Constraint> C = new LinkedList<>();
//        Collections.reverse(C);
        C.add(kb.getConstraint(44));
        C.add(kb.getConstraint(45));
        C.add(kb.getConstraint(46));
        C.add(kb.getConstraint(47));
        C.add(kb.getConstraint(48));
        C.add(kb.getConstraint(49));
        C.add(kb.getConstraint(50));
        C.add(kb.getConstraint(51));
        C.add(kb.getConstraint(52));
        C.add(kb.getConstraint(53));
        C.add(kb.getConstraint(54));
        C.add(kb.getConstraint(55));
        C.add(kb.getConstraint(56));
        C.add(kb.getConstraint(57));
        C.add(kb.getConstraint(58));
        this.setPossiblyFaultyConstraints(C);

        // sets correct constraints to super class
        log.trace("{}Adding correct constraints", LoggerUtils.tab);
        List<Constraint> B = new LinkedList<>();
        B.add(kb.getConstraint(0));
        B.add(kb.getConstraint(1));
        B.add(kb.getConstraint(2));
        B.add(kb.getConstraint(3));
        B.add(kb.getConstraint(4));
        B.add(kb.getConstraint(5));
        B.add(kb.getConstraint(6));
        B.add(kb.getConstraint(7));
        B.add(kb.getConstraint(8));
        B.add(kb.getConstraint(9));
        B.add(kb.getConstraint(10));
        B.add(kb.getConstraint(11));
        B.add(kb.getConstraint(12));
        B.add(kb.getConstraint(13));
        B.add(kb.getConstraint(14));
        B.add(kb.getConstraint(15));
        B.add(kb.getConstraint(16));
        B.add(kb.getConstraint(17));
        B.add(kb.getConstraint(18));
        B.add(kb.getConstraint(19));
        B.add(kb.getConstraint(20));
        B.add(kb.getConstraint(21));
        B.add(kb.getConstraint(22));
        B.add(kb.getConstraint(23));
        B.add(kb.getConstraint(24));
        B.add(kb.getConstraint(25));
        B.add(kb.getConstraint(26));
        B.add(kb.getConstraint(27));
        B.add(kb.getConstraint(28));
        B.add(kb.getConstraint(29));
        B.add(kb.getConstraint(30));
        B.add(kb.getConstraint(31));
        B.add(kb.getConstraint(32));
        B.add(kb.getConstraint(33));
        B.add(kb.getConstraint(34));
        B.add(kb.getConstraint(35));
        B.add(kb.getConstraint(36));
        B.add(kb.getConstraint(37));
        B.add(kb.getConstraint(38));
        B.add(kb.getConstraint(39));
        B.add(kb.getConstraint(40));
        B.add(kb.getConstraint(41));
        B.add(kb.getConstraint(42));
        B.add(kb.getConstraint(43));
        this.setCorrectConstraints(B);

        model.unpost(model.getCstrs());

        LoggerUtils.outdent();
        log.debug("{}<<< Model {} initialized", LoggerUtils.tab, getName());
    }

    private void createUserRequirements() {
        // commands which create the user requirements
        // add user requirements to the model
    }

    private void createConfiguration() {
        // commands which create the configurations
        // add configurations to the model
    }
}
