package hr.fer.zemris.fuzzy.sets;

import hr.fer.zemris.fuzzy.domain.DomainElement;
import hr.fer.zemris.fuzzy.domain.IDomain;

public class CalculatedFuzzySet implements IFuzzySet {
    private IIntUnaryFunction function;
    private IDomain domain;

    public CalculatedFuzzySet(IDomain domain, IIntUnaryFunction function) {
        this.function = function;
        this.domain = domain;
    }

    @Override
    public IDomain getDomain() {
        return domain;
    }

    @Override
    public double getValueAt(DomainElement e) {
        return function.valueAt(domain.indexOfElement(e));
    }
}
