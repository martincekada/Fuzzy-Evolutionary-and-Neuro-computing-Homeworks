package hr.fer.zemris.ann.neurons;

public interface INeuron {

    double getOutputFor(double[] input);

    double[] getWeights();
    void setWeights(double[] weights);

    double getWeightFor(int myIndex);

    int getGenomeLenght();
}
