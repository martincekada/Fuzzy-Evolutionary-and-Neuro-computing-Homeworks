package hr.fer.zemris.fuzzy;

import hr.fer.zemris.fuzzy.utils.ModelDomains;
import hr.fer.zemris.fuzzy.utils.domain.IDomain;

import static hr.fer.zemris.fuzzy.utils.ModelRules.*;

public class HelmFuzzySystemMin extends FuzzySystem {

    public HelmFuzzySystemMin(Defuzzifier defuzzifier) {
        super(defuzzifier);

        System.err.println("test");
        rules.add(IF_CLOSE_RIGHT_TURN_LEFT);
        rules.add(IF_CLOSE_LEFT_TURN_RIGHT);

        rules.add(IF_CLOSE_RIGHT_FRONT_TURN_LEFT_EASY);
        rules.add(IF_CLOSE_LEFT_FRONT_TURN_RIGHT_EASY);

//        rules.add(IF_BACKWARDS_TURN_RIGHT);
    }

    @Override
    IDomain getSystemDomain() {
        return ModelDomains.ANGLE;
    }
}
