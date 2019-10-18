package hr.fer.zemris.fuzzy.relations;

import hr.fer.zemris.fuzzy.domain.CompositeDomain;
import hr.fer.zemris.fuzzy.domain.DomainElement;
import hr.fer.zemris.fuzzy.domain.IDomain;
import hr.fer.zemris.fuzzy.sets.IFuzzySet;
import hr.fer.zemris.fuzzy.sets.MutableFuzzySet;

public class Relations {
    public static boolean isSymmetric(IFuzzySet set) {
        if (!isUtimesURelation(set)) return false;

        for (DomainElement e : set.getDomain()) {
            if (!(set.getValueAt(e) == set.getValueAt(e.reversed()))) {
                return false;
            }
        }

        return true;
    }

    public static boolean isReflexive(IFuzzySet set) {
        if (!isUtimesURelation(set)) return false;

        for (DomainElement e : set.getDomain()) {
            if (e.equals(e.reversed()) && set.getValueAt(e) != 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isMaxMinTransitive(IFuzzySet set) {
        if (!isUtimesURelation(set)) return false;

        for (DomainElement e : set.getDomain()) {
            int x = e.getComponentValue(0);
            int z = e.getComponentValue(1);

            double max = -Double.MAX_VALUE;
            for (DomainElement yElement : set.getDomain().getComponent(0)) {
                int y = yElement.getComponentValue(0);

                double min = Math.min(set.getValueAt(DomainElement.of(x, y)), set.getValueAt(DomainElement.of(y, z)));
                if (min > max) {
                    max = min;
                }
            }
            double mi = set.getValueAt(e);

            if (Double.compare(mi, max) < 0) {
                return false;
            }
        }

        return true;
    }

    public static IFuzzySet compositionOfBinaryRelations(IFuzzySet first, IFuzzySet second) {
        if (!first.getDomain().getComponent(1).equals(second.getDomain().getComponent(0))) {
            throw new IllegalArgumentException("To create composition, define relations as U x V and V x W");
        }

        IFuzzySet composition = new MutableFuzzySet(
                CompositeDomain.combine(first.getDomain().getComponent(0), second.getDomain().getComponent(1))
        );

        IDomain joinComposition = first.getDomain().getComponent(1);
        for (DomainElement e : composition.getDomain()) {
            int x = e.getComponentValue(0);
            int z = e.getComponentValue(1);

            for (DomainElement y : joinComposition) {
                
            }
        }


        return null;
    }

    public static boolean isFuzzyEquivalence(IFuzzySet set) {
        return false;
    }

    public static boolean isUtimesURelation(IFuzzySet set) {
        if (set.getDomain().getNumberOfComponents() != 2) return false;

        return set.getDomain().getComponent(0).equals(set.getDomain().getComponent(1));
    }
}
