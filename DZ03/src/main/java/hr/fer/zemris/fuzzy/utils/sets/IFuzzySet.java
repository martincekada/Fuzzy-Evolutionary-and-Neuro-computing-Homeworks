package hr.fer.zemris.fuzzy.utils.sets;


import hr.fer.zemris.fuzzy.utils.domain.DomainElement;
import hr.fer.zemris.fuzzy.utils.domain.IDomain;

public interface IFuzzySet {
    IDomain getDomain();
    double getValueAt(DomainElement e);
}
