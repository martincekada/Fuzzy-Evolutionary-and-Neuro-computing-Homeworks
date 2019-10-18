package hr.fer.zemris.fuzzy.domain;


public interface IDomain extends Iterable<DomainElement> {
    int getCardinality();
    IDomain getComponent(int i);
    int getNumberOfComponents();
    int indexOfElement(DomainElement e);
    DomainElement elementForIndex(int i);
}
