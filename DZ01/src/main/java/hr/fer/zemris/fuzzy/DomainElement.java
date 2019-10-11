package hr.fer.zemris.fuzzy;

import java.util.Arrays;

public class DomainElement {
    private int[] values;

    public DomainElement(int[] values) {
        this.values = values;
    }

    public static DomainElement of(int[] values) {
        return null;
    }

    public int getNumberOfComponents() {
        return 0;
    }

    public int getComponentValue() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DomainElement that = (DomainElement) o;
        return Arrays.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }
}
