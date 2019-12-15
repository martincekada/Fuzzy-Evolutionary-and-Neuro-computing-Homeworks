package hr.fer.zemris.ann;

public class Sample {
    private double[] input;
    private double[] output;

    public Sample(double[] input, double[] output) {
        this.input = new double[input.length + 1];
        this.output = output;

        for (int i = 0; i < input.length; ++i) {
            this.input[i] = input[i];
        }
        this.input[input.length] = 1;
    }

    public double[] getInput() {
        return input;
    }

    public double[] getOutput() {
        return output;
    }
}
