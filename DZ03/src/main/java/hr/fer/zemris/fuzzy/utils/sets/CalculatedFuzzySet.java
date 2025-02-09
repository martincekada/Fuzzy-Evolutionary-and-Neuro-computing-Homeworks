package hr.fer.zemris.fuzzy.utils.sets;


import hr.fer.zemris.fuzzy.utils.domain.DomainElement;
import hr.fer.zemris.fuzzy.utils.domain.IDomain;

public class CalculatedFuzzySet implements IFuzzySet {
    private IIntUnaryFunction function;
    private IDomain domain;

    public CalculatedFuzzySet(IDomain domain, IIntUnaryFunction function) {
        this.function = function;
        this.domain = domain;
    }

    @Override
    public IFuzzySet reduceTo(double coff) {
        MutableFuzzySet reduced = new MutableFuzzySet(domain);

        for (DomainElement e : domain) {
            reduced.set(e, Math.min(coff, getValueAt(e)));
        }

        return reduced;
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
