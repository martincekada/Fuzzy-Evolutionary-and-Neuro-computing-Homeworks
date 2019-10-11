package hr.fer.zemris.fuzzy;

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
        return 0;
    }

    public IDomain getComponent(int i) {
        return null;
    }

    public int getNumberOfComponents() {
        return 0;
    }

    @Override
    public Iterator<DomainElement> iterator() {
        return null;
    }
}
