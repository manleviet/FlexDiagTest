package at.tugraz.ist.ase.flexdiagtest;

import at.tugraz.ist.ase.cdrmodel.CDRModel;
import at.tugraz.ist.ase.cdrmodel.IChocoModel;
import at.tugraz.ist.ase.common.LoggerUtils;
import at.tugraz.ist.ase.knowledgebases.core.Constraint;
import at.tugraz.ist.ase.knowledgebases.core.KB;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.chocosolver.solver.Model;

import java.util.*;

@Slf4j
public class NOKModel extends CDRModel implements IChocoModel {

    @Getter
    private final Model model;
    private final KB kb;

    public NOKModel(KB kb) {
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
        List<Constraint> C = new LinkedList<>(kb.getConstraintList());
        this.setPossiblyFaultyConstraints(C);

        // sets correct constraints to super class
        log.trace("{}Adding correct constraints", LoggerUtils.tab);
        this.setCorrectConstraints(Collections.emptySet());

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
