package hr.fer.zemris.ann;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static hr.fer.zemris.ann.gui.GesturesConverter.FILE_PATH;
import static hr.fer.zemris.ann.gui.GesturesConverter.M;

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

    public static List<Sample> loadGesture() throws IOException {
        List<Sample> samples = new ArrayList<>(110);

        List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));

        for (String line : lines) {
            String[] splitted = line.split(" ");

            double[] input = new double[M * 2];
            double[] output = new double[5];
            for (int i = 0; i < splitted.length; ++i) {
                if (i < M * 2) {
                    input[i] = Double.valueOf(splitted[i]);
                } else {
                    output[i - M * 2] = Double.valueOf(splitted[i]);
                }
            }

            samples.add(new Sample(input, output));
        }

        return samples;
    }
}
