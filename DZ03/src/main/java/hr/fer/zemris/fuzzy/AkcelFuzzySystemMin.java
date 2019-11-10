package hr.fer.zemris.fuzzy;

import hr.fer.zemris.fuzzy.utils.ModelDomains;
import hr.fer.zemris.fuzzy.utils.domain.IDomain;

import static hr.fer.zemris.fuzzy.utils.ModelRules.IF_GOING_SLOW_THEN_ACCELERATE;

public class AkcelFuzzySystemMin extends FuzzySystem {

    public AkcelFuzzySystemMin(Defuzzifier defuzzifier) {
        super(defuzzifier);

        System.err.println("s eIddmam rere sole");
        rules.add(IF_GOING_SLOW_THEN_ACCELERATE);
    }

    @Override
    IDomain getSystemDomain() {
        return ModelDomains.AKCELERATION;
    }
}
