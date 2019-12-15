package hr.fer.zemris.ann;

import java.util.List;

public class BiasNeuron implements INeuron {


    public double getOutput() {
        return 1.;
    }

    public void setOutputFor(double[] input) {
    }

    @Override
    public double getOutputFor(double[] input) {
        return 1.;
    }

    @Override
    public double addOutputFor(double[] input) {
        return 1;
    }

    @Override
    public void addErrorFor(double v) {

    }

    @Override
    public void addErrorFor(Layer layer, int myIndex) {

    }

    @Override
    public double getLastError() {
        return 0;
    }

    @Override
    public double getWeightFor(int myIndex) {
        return 0;
    }

    @Override
    public void generateNewWeights(List<Sample> samples) {

    }

    @Override
    public void generateNewWeights(Layer layer) {

    }

    @Override
    public double getOutputAt(int index) {
        return 1.0;
    }

    @Override
    public void startUsingNewWeights() {

    }

    @Override
    public void resetAllData() {

    }
}
