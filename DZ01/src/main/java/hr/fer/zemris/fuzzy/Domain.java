package hr.fer.zemris.fuzzy;

import java.util.Iterator;

public abstract class Domain implements IDomain {

    public Domain() {

    }

    public static IDomain intRange(int rangeStart, int rangeEnd) {
        return null;
    }

    public static Domain combine(IDomain firstDomain, IDomain secondDomain) {
        return null;
    }

    public int indexOfElement(DomainElement e){
        return 0;
    }

    public DomainElement elementForIndex(int i) {
        return null;
    }
}
