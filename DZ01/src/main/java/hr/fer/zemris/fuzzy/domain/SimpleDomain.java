package hr.fer.zemris.fuzzy.domain;

import java.util.Iterator;

public class SimpleDomain extends Domain {
    private int first;
    private int last;

    SimpleDomain(int first, int last) {
        this.first = first;
        this.last  = last;
    }

    public int getCardinality() {
        return last - first;
    }

    public IDomain getComponent(int i) {
        return this;
    }

    public int getNumberOfComponents() {
        return 1;
    }

    public int getFirst() {
        return first;
    }

    public int getLast() {
        return last;
    }

    @Override
    public Iterator<DomainElement> iterator() {
        return new SimpleDomainIterator<DomainElement>(first, last);
    }

    static class SimpleDomainIterator<T> implements Iterator<DomainElement> {
        private int counter;
        private int second;

        public SimpleDomainIterator(int first, int second) {
            this.counter = first;
            this.second = second;
        }


        public boolean hasNext() {
            return counter < second;
        }


        public DomainElement next() {
            if (!hasNext()) {
                throw new IllegalStateException("Do not call next without checking if iterator has next element");
            }

            return DomainElement.of(counter++);
        }


        public void remove() {
            throw new UnsupportedOperationException("Can not remove elements from domain");
        }
    }
}