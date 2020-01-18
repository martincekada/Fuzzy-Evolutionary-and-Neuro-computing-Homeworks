package hr.fer.zemris.ann.neurons;

import java.util.Random;

import static java.lang.Math.abs;

public class SimilarityNeuron implements INeuron {
//    TODO: razmotrit velicinu range-a
    private static double RANGE = 2.4;
//    w1, w2, s1, s2
    private double[] weights;
    private int weightSize;

    public SimilarityNeuron(double[] weights) {
        this.weights = weights;
        this.weightSize = weights.length / 2;
    }

    public SimilarityNeuron(int inputLength) {
        this.weightSize = inputLength;
        this.weights = new double[inputLength * 2];

        Random r = new Random();
        for (int i = 0, n = weights.length; i < n; ++i) {
            weights[i] = r.nextDouble() * RANGE * 2 - RANGE;
        }
    }

    @Override
    public double getOutputFor(double[] input) {
        double sum = 0;

        for (int i = 0, n = input.length; i < n; i++) {
            sum += abs(input[i] - weights[i]) / abs(weights[i + weightSize]);
        }


        return 1 / (1 + sum);
    }

    @Override
    public int getGenomeLenght() {
        return weights.length;
    }

    @Override
    public double[] getWeights() {
        return weights;
    }

    @Override
    public void setWeights(double[] weights) {
        this.weights = weights;
    }

    @Override
    public double getWeightFor(int myIndex) {
        return weights[myIndex];
    }
}
