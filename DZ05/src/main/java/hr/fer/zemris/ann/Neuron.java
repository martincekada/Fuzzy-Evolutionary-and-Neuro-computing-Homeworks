package hr.fer.zemris.ann;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.lang.Math.*;

public class Neuron implements INeuron {
    private double[] weights;
    private double[] newWeights;
    private double output;
    private List<Double> outputs;
    private List<Double> errors;

    private static double LEARNING_RATE = 0.2;

    public Neuron(int weightsLength) {
        this.weights = new double[weightsLength];
        this.newWeights = new double[weightsLength];
        this.outputs = new ArrayList<>();
        this.errors = new ArrayList<>();

        Random r = new Random();
        for (int i = 0; i < weightsLength; ++i) {
            weights[i] = r.nextDouble() * 4.8 - 2.4;
        }
    }


    public double getOutput() {
        return output;
    }

    public void setOutputFor(double[] input) {
        this.output = getOutputFor(input);
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

    public double addOutputFor(double[] input) {
        output = getOutputFor(input);
        outputs.add(output);

        return output;
    }

    public void addErrorFor(double target) {
        double error = output * (1 - output) * (target - output);
        errors.add(error);
    }


    public void addErrorFor(Layer layer, int myIndex) {
        double error = output * (1 - output);
        double sum = 0;

        for (INeuron n : layer.getNeurons()) {
            sum += (n.getLastError() * n.getWeightFor(myIndex));
        }

        errors.add(error * sum);
    }


    public double getLastError() {
        return errors.get(errors.size() - 1);
    }

    public double getWeightFor(int myIndex) {
        return weights[myIndex];
    }

    public void generateNewWeights(List<Sample> samples) {
        if (samples.size() != errors.size()) {
            throw new UnsupportedOperationException("Razliciti broj errora i uzoraka");
        }



        for (int i = 0, n = weights.length; i < n; ++i) {
            double correction = 0;

            for (int j = 0, m = samples.size(); j < m; ++j) {
                correction += (samples.get(j).getInput()[i] * errors.get(j));
            }

            newWeights[i] = weights[i] + LEARNING_RATE * correction;
        }
    }

    public void generateNewWeights(Layer layer) {

        for (int i = 0, n = weights.length; i < n ;++i) {
            INeuron previosNeuron = layer.getNeurons().get(i);

            double correction = 0;
            for (int j = 0, m = errors.size(); j < m; ++j) {
                correction += (previosNeuron.getOutputAt(j) * errors.get(j));
            }

            newWeights[i] = weights[i] + LEARNING_RATE * correction;

        }
    }

    @Override
    public void startUsingNewWeights() {
        weights = newWeights.clone();
    }

    @Override
    public double getOutputAt(int index) {
        return outputs.get(index);
    }

    @Override
    public void resetAllData() {
        outputs.clear();
        errors.clear();
    }

    private static double sigmoid(double x) {
        return 1.0 / (1 + exp(-x));
    }
}
