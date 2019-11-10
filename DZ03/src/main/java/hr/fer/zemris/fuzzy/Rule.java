package hr.fer.zemris.fuzzy;

import hr.fer.zemris.fuzzy.utils.domain.DomainElement;
import hr.fer.zemris.fuzzy.utils.sets.IFuzzySet;

public class Rule {
    private IFuzzySet[] ifs;
    private IFuzzySet then;

    public Rule(IFuzzySet[] ifs, IFuzzySet then) {
        this.ifs = ifs;
        this.then = then;
    }

    public IFuzzySet resolve(int L, int D, int LK, int DK, int V, int S) {
        int[] inputs = new int[] {L, D, LK, DK, V, S};

        double minValue = 1.0;

        for (int i = 0, n = ifs.length; i < n; ++i) {

            if (ifs[i] == null) continue;

            double partValue = ifs[i].getValueAt(DomainElement.of(inputs[i]));
            if (partValue < minValue) {
                minValue = partValue;
            }
//            minValue *= partValue;
        }

        System.err.println("Uzimam u obzir: " + minValue);
        return then.reduceTo(minValue);
    }
}
