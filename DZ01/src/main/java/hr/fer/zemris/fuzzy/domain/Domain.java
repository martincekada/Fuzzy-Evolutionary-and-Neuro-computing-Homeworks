package hr.fer.zemris.fuzzy.domain;

import org.apache.commons.lang3.ArrayUtils;

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
}
