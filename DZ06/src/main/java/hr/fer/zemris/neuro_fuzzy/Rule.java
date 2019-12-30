package hr.fer.zemris.neuro_fuzzy;

import java.util.Random;

import static java.lang.Math.exp;
import static java.lang.Math.pow;

public class Rule {
    public double a;
    public double b;
    public double c;
    public double d;

    private double p;
    private double q;
    private double r;

    private double updatedA;
    private double updatedB;
    private double updatedC;
    private double updatedD;

    private double updatedP;
    private double updatedQ;
    private double updatedR;

    public Rule(double a, double b, double c, double d, double p, double q, double r) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.p = p;
        this.q = q;
        this.r = r;


    }

    public static Rule generateRandomRule() {
        Random rand = new Random();

        double initRange = 2;

        double a = rand.nextDouble() * initRange - (initRange / 2.);
        double b = rand.nextDouble() * initRange - (initRange / 2.);
        double c = rand.nextDouble() * initRange - (initRange / 2.);
        double d = rand.nextDouble() * initRange - (initRange / 2.);

        double p = rand.nextDouble() * initRange - (initRange / 2.);
        double q = rand.nextDouble() * initRange - (initRange / 2.);
        double r = rand.nextDouble() * initRange - (initRange / 2.);

        //        updatedA = 0;
//        updatedB = 0;
//        updatedC = 0;
//        updatedD = 0;
//
//        updatedP = 0;
//        updatedQ = 0;
//        updatedR = 0;

        return new Rule(a, b, c, d, p, q, r);

    }

    public double getZ(double x, double y) {
        return p * x + q * y + r;
    }

    public double getPI(double x, double y) {
        return getAlpha(x) * getBeta(y);
    }

    private double getAlpha(double x) {
        return 1.0 / (1 + exp(b * (x - a)));
    }

    private double getBeta(double y) {
        return 1.0 / (1 + exp(d * (y - c)));
    }

    private static double sigmoid(double x) {
        return 1.0 / (1 + exp(-x));
    }

    public void accumulateRuleChange(double predictDiff, double weightedZSum, double piSum, Sample sample, double learningRate) {

        double alpha = getAlpha(sample.x);
        double beta = getBeta(sample.y);
        double z = getZ(sample.x, sample.y);

        double PIDerivation = (z * piSum - weightedZSum) / pow(piSum, 2);

        double mutalProduct = learningRate * predictDiff * PIDerivation * alpha * beta;


        updatedA += mutalProduct * (1 - alpha) * b;
        updatedB += mutalProduct * (1 - alpha) * (a - sample.x);

        updatedC += mutalProduct * (1 - beta) * d;
        updatedD += mutalProduct * (1 - beta) * (c - sample.y);


        double pi = getPI(sample.x, sample.y);

        updatedP += learningRate * 10 * predictDiff * (pi / piSum) * sample.x;
        updatedQ += learningRate * 10 * predictDiff * (pi / piSum) * sample.y;
        updatedR += learningRate * 10 * predictDiff * (pi / piSum);

    }

    public void changeRuleParams() {
//        System.out.println("mijenjam paramse");
        this.a += updatedA;
        this.b += updatedB;
        this.c += updatedC;
        this.d += updatedD;

        this.p += updatedP;
        this.q += updatedQ;
        this.r += updatedR;

        updatedA = 0;
        updatedB = 0;
        updatedC = 0;
        updatedD = 0;

        updatedP = 0;
        updatedQ = 0;
        updatedR = 0;
    }
}


















































