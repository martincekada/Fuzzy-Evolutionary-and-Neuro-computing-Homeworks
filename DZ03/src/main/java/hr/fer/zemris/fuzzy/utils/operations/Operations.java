package hr.fer.zemris.fuzzy.utils.operations;


import hr.fer.zemris.fuzzy.utils.domain.DomainElement;
import hr.fer.zemris.fuzzy.utils.sets.IFuzzySet;
import hr.fer.zemris.fuzzy.utils.sets.MutableFuzzySet;

public class Operations {

    public Operations() {
    }

    public static IFuzzySet unaryOperation(IFuzzySet set, IUnaryFunction function) {
        MutableFuzzySet resultSet = new MutableFuzzySet(set.getDomain());

        for (DomainElement e : set.getDomain()) {
            resultSet.set(e, function.valueAt(set.getValueAt(e)));
        }

        return resultSet;
    }

    public static IFuzzySet binaryOperation(IFuzzySet first, IFuzzySet second, IBinaryFunction function) {
        MutableFuzzySet resultSet = new MutableFuzzySet(first.getDomain());

        for (DomainElement e : first.getDomain()) {
            resultSet.set(e, function.valueAt(first.getValueAt(e), second.getValueAt(e)));
        }

        return resultSet;
    }

    public static IUnaryFunction zadehNot() {
        return (double value) -> 1 - value;
    }

    public static IBinaryFunction zadehAnd() {
        return (double first, double second) -> Math.min(first, second);
    }

    public static IBinaryFunction zadehOr() {
        return (double first, double second) -> Math.max(first, second);
    }

    public static IBinaryFunction hamacherTNorm(double v) {
        return (double a, double b) -> (a * b) / (v + (1 - v) * (a + b - a * b));
    }

    public static IBinaryFunction hamacherSNorm(double v) {
        return (double a, double b) -> (a + b - (2 - v) * a * b) / (1 - (1 - v) * a * b);
    }
}
