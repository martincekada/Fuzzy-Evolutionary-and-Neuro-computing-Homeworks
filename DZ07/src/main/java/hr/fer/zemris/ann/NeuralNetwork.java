package hr.fer.zemris.ann;

import hr.fer.zemris.ann.neurons.Neuron;
import hr.fer.zemris.ann.neurons.SimilarityNeuron;
import hr.fer.zemris.util.Sample;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.pow;

public class NeuralNetwork {
    private int[] givenLayers;
    private List<Layer> layers;

    public NeuralNetwork(int... layers) {
        this.givenLayers = layers;
        this.layers = new ArrayList<>();

        this.layers.add(new Layer(layers[1], () -> new SimilarityNeuron(layers[0])));

        for (int i = 2; i < layers.length; ++i) {
            final int index = i;
            this.layers.add(new Layer(layers[i], () -> new Neuron(layers[index - 1] + 1)));
        }
    }

    public double[] predict(Sample sample) {
        double[] result = sample.getInput();

        for (Layer l : layers) {
            result = l.getOutputFor(result);
        }

        return result;
    }

    public double calculateError(List<Sample> samples) {
        double[] prediction;
        double error = 0;

        for (Sample s : samples) {
            prediction = predict(s);

            double[] target = s.getOutput();

            for (int i = 0; i < target.length; ++i) {
                error += pow(target[i] - prediction[i], 2);
            }
        }

        return error;
    }

    public double[] getGenome() {
        double[] genome = new double[0];
        for (Layer l : layers) {
            genome = ArrayUtils.addAll(genome, l.getGenome());
        }

        return genome;
    }

    public void setGenome(double[] genome) {
        int startIndex = 0;
        int endIndex = 0;
        for (Layer l : layers) {
            endIndex += l.getGenomeSize();

            l.setGenome(ArrayUtils.subarray(genome, startIndex, endIndex));

            startIndex = endIndex;
        }
    }

    public int getGenomeSize() {
        int size = 0;
        for(Layer l : layers) {
            size += l.getGenomeSize();
        }

        return size;
    }

    private void printError(List<Sample> samples) {
        System.out.println("Current error: " + calculateError(samples));

    }

    public int[] getLayers() {
        return this.givenLayers;
    }

    public Layer getFirstLayer() {
        return layers.get(0);
    }
}
