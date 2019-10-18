package hr.fer.zemris.fuzzy.sets;

import hr.fer.zemris.fuzzy.domain.DomainElement;
import hr.fer.zemris.fuzzy.domain.IDomain;

public interface IFuzzySet {
    IDomain getDomain();
    double getValueAt(DomainElement e);
}
