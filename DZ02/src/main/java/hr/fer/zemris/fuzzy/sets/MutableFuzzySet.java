package hr.fer.zemris.fuzzy.sets;

import hr.fer.zemris.fuzzy.domain.Domain;
import hr.fer.zemris.fuzzy.domain.DomainElement;
import hr.fer.zemris.fuzzy.domain.IDomain;

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
}
