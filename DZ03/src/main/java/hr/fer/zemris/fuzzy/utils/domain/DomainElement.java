package hr.fer.zemris.fuzzy.utils.domain;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class DomainElement {
    private int[] values;

    public DomainElement(int[] values) {
        this.values = values;
    }

    public static DomainElement of(int... values) {
        return new DomainElement(values);
    }

    public int getNumberOfComponents() {
        return values.length;
    }

    public int getComponentValue(int i) {
        return values[i];
    }

    public DomainElement reversed() {
        int[] copy = values.clone();
        ArrayUtils.reverse(copy);
        return DomainElement.of(copy);
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

    @Override
    public String toString() {
        if (values.length == 1) {
            return "Element domene: " + values[0];
        }

        else {
            StringJoiner sj = new StringJoiner(", ");

            for (int i = 0, n = values.length; i < n; ++i) {
                sj.add(String.valueOf(values[i]));
            }

            return "Element domene: (" + sj.toString() + ")";
        }
    }
}
