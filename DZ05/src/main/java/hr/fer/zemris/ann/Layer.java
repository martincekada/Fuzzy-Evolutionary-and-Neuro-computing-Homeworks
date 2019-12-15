package hr.fer.zemris.ann;

import java.util.ArrayList;
import java.util.List;

public class Layer {
    private List<INeuron> neurons;

    public Layer(int layerSize, int neuronsSize) {
        this.neurons = new ArrayList<>(layerSize + 1);

        for (int i = 0; i < layerSize; ++i) {
            neurons.add(new Neuron(neuronsSize));
        }

        neurons.add(new BiasNeuron());
    }

//    public static INeuron[] getNeurons() {
//        return ne
//    }


    public double[] getOutputFor(double[] input) {
        double[] output = new double[neurons.size()];

        for (int i = 0; i < output.length; ++i) {
            output[i] = neurons.get(i).getOutputFor(input);
        }

        return output;
    }

    public double[] addOutputFor(double[] input) {
        double[] output = new double[neurons.size()];

        for (int i = 0; i < output.length; ++i) {
            output[i] = neurons.get(i).addOutputFor(input);
        }

        return output;
    }

    public void addErrorFor(Sample sample) {
        double[] target = sample.getOutput();

//        -1 je zbog bias neurona u zadnjem sloju
        for (int i = 0; i < neurons.size() - 1; ++i) {
            neurons.get(i).addErrorFor(target[i]);

        }

    }

    public void addErrorFor(Layer layer) {

        for (int i = 0; i < neurons.size(); ++i) {
            neurons.get(i).addErrorFor(layer, i);
        }
    }

    public List<INeuron> getNeurons() {
        return neurons;
    }

    public void generateNewWeights(List<Sample> samples) {
        for (int i = 0, n = neurons.size(); i < n; ++i) {
            neurons.get(i).generateNewWeights(samples);
        }
    }

    public void genereteNewWeights(Layer layer) {
        for (int i = 0, n = neurons.size(); i < n; ++i) {
            neurons.get(i).generateNewWeights(layer);
        }
    }

    public void startUsingNewWeights() {
        for (INeuron n : neurons) {
            n.startUsingNewWeights();
        }
    }

    public void resetAllData() {
        for (INeuron n : neurons) {
            n.resetAllData();
        }
    }
}
