package hr.fer.zemris.neuro_fuzzy;

import static java.lang.Math.cos;
import static java.lang.Math.pow;

public class Function {

    public static double valueFor(double x, double y) {
        double result;
        double firstPart;
        double cos;


        firstPart = pow(x - 1, 2) + pow(y + 2, 2) - 5 * x * y + 3;
        cos = cos(x / 5.0);


        result = firstPart * pow(cos, 2);
        return result;
    }
}
