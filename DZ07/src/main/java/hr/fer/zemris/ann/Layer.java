package hr.fer.zemris.ann;

import hr.fer.zemris.ann.neurons.BiasNeuron;
import hr.fer.zemris.ann.neurons.INeuron;
import hr.fer.zemris.ann.neurons.Neuron;
import hr.fer.zemris.util.Sample;
import org.apache.commons.lang3.ArrayUtils;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Layer {
    private List<INeuron> neurons;

    public Layer(int layerSize, Supplier<INeuron> neuronConstructor) {
        this.neurons = new ArrayList<>(layerSize + 1);

        for (int i = 0; i < layerSize; ++i) {
            neurons.add(neuronConstructor.get());
        }

        neurons.add(new BiasNeuron());
    }



    public double[] getOutputFor(double[] input) {
        double[] output = new double[neurons.size()];

        for (int i = 0; i < output.length; ++i) {
            output[i] = neurons.get(i).getOutputFor(input);
        }

        return output;
    }


    public List<INeuron> getNeurons() {
        return neurons;
    }

    public int getGenomeSize() {
        int size = 0;

        for (INeuron n : neurons) {
            size += n.getGenomeLenght();
        }

        return size;
    }

    public double[] getGenome() {
        double[] genome = new double[0];
        for (INeuron n : neurons) {
            genome = ArrayUtils.addAll(genome, n.getWeights());
        }

        return genome;
    }

    public void setGenome(double[] genome) {
        int startIndex = 0;
        int endIndex = 0;
        for (INeuron n : neurons) {
            endIndex += n.getGenomeLenght();

            n.setWeights(ArrayUtils.subarray(genome, startIndex, endIndex));

            startIndex = endIndex;
        }
    }
}
