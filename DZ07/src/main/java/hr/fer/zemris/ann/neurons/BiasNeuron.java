package hr.fer.zemris.ann.neurons;

import hr.fer.zemris.ann.Layer;
import hr.fer.zemris.util.Sample;

import java.util.List;

public class BiasNeuron implements INeuron {

    @Override
    public double getOutputFor(double[] input) {
        return 1.;
    }

    @Override
    public double getWeightFor(int myIndex) {
        throw new UnsupportedOperationException("Nije impl u bias neuronu");
    }

    @Override
    public double[] getWeights() {
        return new double[0];
    }

    @Override
    public void setWeights(double[] weights) {}

    @Override
    public int getGenomeLenght() {
        return 0;
    }
}
