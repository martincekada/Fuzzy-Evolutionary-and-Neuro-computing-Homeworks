package hr.fer.zemris.fuzzy;

import hr.fer.zemris.fuzzy.utils.domain.DomainElement;
import hr.fer.zemris.fuzzy.utils.sets.IFuzzySet;

public class COADefuzzifier implements Defuzzifier {
    @Override
    public int decode(IFuzzySet set) {
        double nominator = 0;
        double denominator = 0;

        for (DomainElement e : set.getDomain()) {
            nominator += e.getComponentValue(0) * set.getValueAt(e);
            denominator += set.getValueAt(e);
        }

        return (int) (nominator / denominator);
    }
}
