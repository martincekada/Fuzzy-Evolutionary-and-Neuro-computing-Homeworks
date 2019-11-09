package hr.fer.zemris.fuzzy.utils.sets;

public class StandardFuzzySets {
    public StandardFuzzySets() {

    }

    public static IIntUnaryFunction lFunction(int alpha, int beta) {
        return (int i) -> {
            return 1 - gammaFunction(alpha, beta).valueAt(i);
        };
    }

    public static IIntUnaryFunction gammaFunction(int alpha, int beta) {
        return (int i) -> {
            double x = (double) i;
            if (x < alpha) {
                return 0;

            } else if (x < beta) {
                return (x - alpha) / (beta - alpha);

            } else {
                return 1;
            }
        };
    }

    public static IIntUnaryFunction lambdaFunction(int alpha, int beta, int gamma) {
        return (int i) -> {
            double x = (double) i;
            if (x < alpha || x >= gamma) {
                return 0;

            } else if (x < beta) {
                return (x - alpha) / (beta - alpha);

            } else if (x < gamma) {
                return (gamma - x) / (gamma - beta);
            }

            throw new IllegalArgumentException("Value could not be compared to: " + alpha + ", " + beta + ", " + gamma);
        };

    }

}
