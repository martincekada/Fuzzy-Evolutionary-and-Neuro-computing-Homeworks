package hr.fer.zemris.ann;

import java.util.BitSet;
import java.util.List;

public interface INeuron {

    double getOutput();

    void setOutputFor(double[] input);
    double getOutputFor(double[] input);

    double addOutputFor(double[] input);

    void addErrorFor(double v);

    void addErrorFor(Layer layer, int myIndex);

    double getLastError();

    double getWeightFor(int myIndex);

    void generateNewWeights(List<Sample> samples);

    void generateNewWeights(Layer layer);

    double getOutputAt(int index);

    void startUsingNewWeights();

    void resetAllData();
}
