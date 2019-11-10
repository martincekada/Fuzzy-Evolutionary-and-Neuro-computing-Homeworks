package hr.fer.zemris.fuzzy.utils.sets;


import hr.fer.zemris.fuzzy.utils.domain.DomainElement;
import hr.fer.zemris.fuzzy.utils.domain.IDomain;

public class MutableFuzzySet implements IFuzzySet {
    private double[] memberships;
    private IDomain domain;

    public MutableFuzzySet(IDomain domain) {
        this.domain = domain;
        this.memberships = new double[domain.getCardinality()];
    }


    public MutableFuzzySet set(DomainElement e, double value) {
        memberships[domain.indexOfElement(e)] = value;
        return this;
    }

    public IDomain getDomain() {
        return domain;
    }

    @Override
    public double getValueAt(DomainElement e) {
        return memberships[domain.indexOfElement(e)];
    }

    @Override
    public IFuzzySet reduceTo(double coff) {
        MutableFuzzySet reduced = new MutableFuzzySet(domain);

        for (DomainElement e : domain) {
            reduced.set(e, Math.min(coff, getValueAt(e)));
        }

        return reduced;
    }
}
