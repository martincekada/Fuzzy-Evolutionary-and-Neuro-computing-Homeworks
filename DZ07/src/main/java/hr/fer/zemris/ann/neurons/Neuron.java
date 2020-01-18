package hr.fer.zemris.ann.neurons;

import java.util.Random;

import static java.lang.Math.*;

public class Neuron implements INeuron {
    private double[] weights;

    public Neuron(int weightsLength) {
        this.weights = new double[weightsLength];

        Random r = new Random();
        for (int i = 0; i < weightsLength; ++i) {
            weights[i] = r.nextDouble() * 4.8 - 2.4;
        }
    }


    public double getOutputFor(double[] input) {
        if (input.length != weights.length) {
            throw new IllegalArgumentException("Razlicite velicine inputa i weightova");
        }

        double result = 0;
        for (int i = 0; i < weights.length; ++i) {
            result += input[i] * weights[i];
        }

        return sigmoid(result);
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
    public int getGenomeLenght() {
        return weights.length;
    }

    public double getWeightFor(int myIndex) {
        return weights[myIndex];
    }

    private static double sigmoid(double x) {
        return 1.0 / (1 + exp(-x));
    }
}
