package hr.fer.zemris.fuzzy.utils.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CompositeDomain extends Domain {
    private List<SimpleDomain> components;

    public CompositeDomain(SimpleDomain[] components) {
        this.components = new ArrayList<>(Arrays.asList(components));
    }

    public int getCardinality() {
        int cardinality = 1;

        for (SimpleDomain component : components) {
            cardinality *= component.getCardinality();
        }

        return cardinality;
    }

    public IDomain getComponent(int i) {
        return components.get(i);
    }

    public int getNumberOfComponents() {
        return components.size();
    }

    @Override
    public Iterator<DomainElement> iterator() {
        return new CompositeDomainIterator<DomainElement>();
    }

    class CompositeDomainIterator<T> implements Iterator<DomainElement> {
        private int[] counters;
        private int[] sizes;

        public CompositeDomainIterator() {
//            components = CompositeDomain.this.components;
            counters = new int[components.size()];
            sizes = new int[components.size()];

            for (int i = 0, n = components.size(); i < n; ++i) {
                sizes[i] = components.get(i).getCardinality();
            }


        }


        public boolean hasNext() {
            return counters[0] >= 0;
        }


        public DomainElement next() {

            int[] elements = new int[counters.length];

            for (int i = 0, n = counters.length; i < n; ++i) {
                elements[i] = components.get(i).elementForIndex(counters[i]).getComponentValue(0);
            }

            DomainElement element = DomainElement.of(elements);


            int i = counters.length - 1;

            while (++counters[i] == sizes[i]) {
                if (i == 0) {
                    counters[0] = -1;
                    break;
                }

                counters[i] = 0;
                i--;
            }


            return element;
        }


        public void remove() {
            throw new UnsupportedOperationException("Can not remove elements from domain");
        }
    }
}
