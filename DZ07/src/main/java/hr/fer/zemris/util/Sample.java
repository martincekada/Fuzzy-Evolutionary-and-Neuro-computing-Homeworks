package hr.fer.zemris.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;



public class Sample {
    private static String FILE_PATH = "./src/main/resources/zad7-dataset.txt";
    private double[] input;
    private double[] output;

    public Sample(double[] input, double[] output) {
        this.input = input;
        this.output = output;
    }

    public double[] getInput() {
        return input;
    }

    public double[] getOutput() {
        return output;
    }

    public static List<Sample> loadSamples() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));
        List<Sample> samples = new ArrayList<>(lines.size());

        for (String line : lines) {
            String[] splitted = line.split("\t");

            double[] input = new double[2];
            double[] output = new double[3];

            input[0] = Double.valueOf(splitted[0]);
            input[1] = Double.valueOf(splitted[1]);

            output[0] = Double.valueOf(splitted[2]);
            output[1] = Double.valueOf(splitted[3]);
            output[2] = Double.valueOf(splitted[4]);


            samples.add(new Sample(input, output));
        }

        return samples;
    }

    public void setOutput(double[] predict) {
        this.output = predict;
    }
}
