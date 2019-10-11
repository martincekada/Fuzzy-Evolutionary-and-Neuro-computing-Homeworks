package hr.fer.zemris.fuzzy;


public interface IDomain extends Iterable {
    int getCardinality();
    IDomain getComponent(int i);
    int getNumberOfComponents();
    int indexOfElement(DomainElement e);
    DomainElement elementForIndex(int i);
}
