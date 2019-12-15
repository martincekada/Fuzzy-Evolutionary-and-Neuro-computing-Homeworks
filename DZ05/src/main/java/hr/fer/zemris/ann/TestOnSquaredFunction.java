package hr.fer.zemris.ann;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static hr.fer.zemris.ann.gui.GesturesConverter.M;

public class TestOnSquaredFunction {

    public static void main(String[] args) {
        List<Sample> samples = new ArrayList<>();

        samples.add(new Sample(new double[] {-1}, new double[] {1}));
        samples.add(new Sample(new double[] {-0.8}, new double[] {0.64}));
        samples.add(new Sample(new double[] {-0.6}, new double[] {0.36}));
        samples.add(new Sample(new double[] {-0.4}, new double[] {0.16}));
        samples.add(new Sample(new double[] {-0.2}, new double[] {0.04}));
        samples.add(new Sample(new double[] {0}, new double[] {0}));
        samples.add(new Sample(new double[] {0.2}, new double[] {0.04}));
        samples.add(new Sample(new double[] {0.4}, new double[] {0.16}));
        samples.add(new Sample(new double[] {0.6}, new double[] {0.36}));
        samples.add(new Sample(new double[] {0.8}, new double[] {0.64}));
        samples.add(new Sample(new double[] {1}, new double[] {1}));

        NeuralNetwork network = new NeuralNetwork(1, 6, 6, 1);
        network.train(samples, 2);

        System.out.println("0.4 " + Arrays.toString(network.predict(new Sample(new double[] {0.4}, null))));
        System.out.println("-0.6 " + Arrays.toString(network.predict(new Sample(new double[] {-0.6}, null))));
        System.out.println("1 " + Arrays.toString(network.predict(new Sample(new double[] {2}, null))));



    }
}
