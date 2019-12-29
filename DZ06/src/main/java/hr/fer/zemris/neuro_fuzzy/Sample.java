package hr.fer.zemris.neuro_fuzzy;

import java.util.ArrayList;
import java.util.List;

public class Sample {
    public double x;
    public double y;
    public double f;

    private static List<Sample> samples;

    static {
        samples = new ArrayList<>(81);

        for (int i = -4; i < 5; ++i) {
            for (int j = -4; j < 5; ++j) {
                samples.add(new Sample(i, j, Function.valueFor(i, j)));
            }

        }
    }

    public Sample(double x, double y, double f) {
        this.x = x;
        this.y = y;
        this.f = f;
    }

    public static List<Sample> generateSamples() {
        return samples;
    }

    @Override
    public String toString() {
        return x + " " + y + " " + f;
    }
}
