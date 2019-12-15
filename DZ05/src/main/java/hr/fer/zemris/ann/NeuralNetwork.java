package hr.fer.zemris.ann;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.pow;

public class NeuralNetwork {
    private List<Layer> layers;


    public NeuralNetwork(int... layers) {
        this.layers = new ArrayList<>();

        for (int i = 1; i < layers.length; ++i) {
            this.layers.add(new Layer(layers[i], layers[i - 1] + 1));
        }
    }

    public double[] predict(Sample sample) {
        double[] result = sample.getInput();

        for (Layer l : layers) {
            result = l.getOutputFor(result);
        }

        return result;
    }

    public void train(List<Sample> samples, int algorithmCode) {

        if (algorithmCode == 1) groupLearning(samples);
        else if (algorithmCode == 2) stohasticLearning(samples);
        else if (algorithmCode == 3) miniBathesLearning(samples);
        else throw new UnsupportedOperationException("Nepoznati broj algoritma");

        learnOn(samples);
    }

    private void groupLearning(List<Sample> samples) {
        while(true) {
            learnOn(samples);
            printError(samples);
        }

    }

    private void stohasticLearning(List<Sample> samples) {
        List<Sample> oneSampleList = new ArrayList<>();
        while (true) {
            for (Sample s : samples) {
                oneSampleList.add(s);
                learnOn(oneSampleList);
                oneSampleList.clear();

                printError(samples);
            }
        }

    }


    private void miniBathesLearning(List<Sample> samples) {

    }



    private void learnOn(List<Sample> samples) {

        for (Sample s : samples) {
            addOutputFor(s);
            addErrorFor(s);
        }

        generateNewWeights(samples);
        startUsingNewWeights();
        resetAllData();
    }

    private void resetAllData() {
        for (Layer l : layers) {
            l.resetAllData();
        }
    }

    private void startUsingNewWeights() {
        for (Layer l : layers) {
            l.startUsingNewWeights();
        }
    }

    private void generateNewWeights(List<Sample> samples) {
        Layer firstLayer = layers.get(0);

        firstLayer.generateNewWeights(samples);

        for (int i = 1, n = layers.size(); i < n; ++i) {
            layers.get(i).genereteNewWeights(layers.get(i - 1));
        }


    }

    private void addOutputFor(Sample sample) {
        double[] result = sample.getInput();

        for (Layer l : layers) {
            result = l.addOutputFor(result);
        }
    }

    private void addErrorFor(Sample sample) {
        Layer outputLayer = layers.get(layers.size() - 1);

        outputLayer.addErrorFor(sample);

        for (int i = layers.size() - 2; i >= 0; i--) {
            layers.get(i).addErrorFor(layers.get(i + 1));
        }

    }


    private void printError(List<Sample> samples) {
        double[] prediction;
        double error = 0;

        for (Sample s : samples) {
            prediction = predict(s);

            double[] target = s.getOutput();

            for (int i = 0; i < target.length; ++i) {
                error += pow(target[i] - prediction[i], 2);
            }
        }

        System.out.println("Current error: " + error);

    }
}
