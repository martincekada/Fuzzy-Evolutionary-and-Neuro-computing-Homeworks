package hr.fer.zemris.fuzzy;

import hr.fer.zemris.fuzzy.utils.domain.IDomain;
import hr.fer.zemris.fuzzy.utils.operations.Operations;
import hr.fer.zemris.fuzzy.utils.sets.IFuzzySet;
import hr.fer.zemris.fuzzy.utils.sets.MutableFuzzySet;

import java.util.ArrayList;
import java.util.List;

public abstract class FuzzySystem {
    private Defuzzifier defuzzifier;
    protected List<Rule> rules = new ArrayList<>();

    public FuzzySystem(Defuzzifier defuzzifier) {
        this.defuzzifier = defuzzifier;
    }


    public int conclude(int L, int D, int LK, int DK, int V, int S) {
        return defuzzifier.decode(getConclusion(L, D, LK, DK, V, S));
    }

    public IFuzzySet getConclusion(int L, int D, int LK, int DK, int V, int S) {
        IFuzzySet result = new MutableFuzzySet(getSystemDomain());

        List<IFuzzySet> conclusions = new ArrayList<>();
        for (Rule r : rules) {
            conclusions.add(r.resolve(L, D, LK, DK, V, S));
        }

        for (IFuzzySet s : conclusions) {
            result = Operations.binaryOperation(result, s, Operations.zadehOr());
        }

        return result;
    }

    abstract IDomain getSystemDomain();
}
