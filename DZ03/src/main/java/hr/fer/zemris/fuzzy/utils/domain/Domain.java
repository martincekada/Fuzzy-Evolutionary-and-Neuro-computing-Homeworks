package hr.fer.zemris.fuzzy.utils.domain;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Iterator;

public abstract class Domain implements IDomain {

    public Domain() {

    }

    public static IDomain intRange(int rangeStart, int rangeEnd) {
        return new SimpleDomain(rangeStart, rangeEnd);
    }

    public static Domain combine(IDomain firstDomain, IDomain secondDomain) {
        return new CompositeDomain(
                ArrayUtils.addAll(extractSimpleDomains(firstDomain), extractSimpleDomains(secondDomain))
        );
    }

    public int indexOfElement(DomainElement seekingElement) {
        int counter = 0;
        for (DomainElement domainElement : this) {
            if (domainElement.equals(seekingElement)) return counter;
            counter++;
        }

        throw new IllegalArgumentException("Domain does not have element:  " + seekingElement);
    }

    public DomainElement elementForIndex(int i) {
        int counter = 0;

        for (DomainElement e : this) {
            if (counter == i ) return e;
            counter++;
        }

        throw new IllegalArgumentException("Domain does not have element at index: " + i);
    }

    private static SimpleDomain[] extractSimpleDomains(IDomain domain) {
        if (domain instanceof SimpleDomain) {
            return new SimpleDomain[] { (SimpleDomain) domain};

        } else if (domain instanceof CompositeDomain) {
            domain = (CompositeDomain) domain;
            SimpleDomain[] simpleDomains = new SimpleDomain[domain.getNumberOfComponents()];

            for (int i = 0, n = simpleDomains.length; i < n; ++i) {
                simpleDomains[i] = (SimpleDomain) domain.getComponent(i);
            }

            return simpleDomains;
        } else {
            throw new IllegalArgumentException("Given domain is not SimpleDomain nor CompositeDomain");
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(!(obj instanceof Domain)) return false;

        Domain other = (Domain) obj;

        Iterator<DomainElement> otherIterator =  other.iterator();
        Iterator<DomainElement> thisIterator =  this.iterator();

        while (thisIterator.hasNext() && otherIterator.hasNext()) {
            if (!thisIterator.next().equals(otherIterator.next())) {
                return false;
            }
        }


        return !(thisIterator.hasNext() || otherIterator.hasNext());

    }
}
