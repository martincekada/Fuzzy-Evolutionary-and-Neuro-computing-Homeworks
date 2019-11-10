package hr.fer.zemris.fuzzy;

import hr.fer.zemris.fuzzy.utils.sets.IFuzzySet;

public interface Defuzzifier {

    int decode(IFuzzySet set);
}
