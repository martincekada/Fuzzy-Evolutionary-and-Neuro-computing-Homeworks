package hr.fer.zemris.fuzzy;

import java.util.Iterator;

public class SimpleDomain extends Domain {
    private int first;
    private int last;

    SimpleDomain(int first, int last) {
        this.first = first;
        this.last  = last;
    }

    public int getCardinality() {
        return 0;
    }

    public IDomain getComponent(int i) {
        return null;
    }

    public int getNumberOfComponents() {
        return 0;
    }

    public int getFirst() {
        return first;
    }

    public int getLast() {
        return last;
    }

    @Override
    public Iterator<DomainElement> iterator() {
        return null;
    }
}
