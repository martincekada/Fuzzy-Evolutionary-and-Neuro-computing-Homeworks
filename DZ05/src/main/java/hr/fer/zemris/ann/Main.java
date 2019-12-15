package hr.fer.zemris.ann;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        System.out.println(Arrays.toString(new NeuralNetwork(1, 2, 3, 1).predict(new double[] {3})));

        List<Sample> samples = new ArrayList<>();

//        {(-1,1), (-0.8, 0.64), (-0.6,0.36), (-0.4,0.16), (-0.2,0.04), (0,0), (0.2,0.04), (0.4,0.16), (0.6,0.36),
//            (0.8,0.64), (1,1)}

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


        NeuralNetwork network = new NeuralNetwork(1, 2, 2, 1);
        network.train(samples, 1);

        System.out.println("0.4 " + Arrays.toString(network.predict(new Sample(new double[] {0.4}, null))));
        System.out.println("-0.6 " + Arrays.toString(network.predict(new Sample(new double[] {-0.6}, null))));
        System.out.println("2 " + Arrays.toString(network.predict(new Sample(new double[] {2}, null))));




    }
}
