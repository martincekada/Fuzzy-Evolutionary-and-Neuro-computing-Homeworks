package hr.fer.zemris.neuro_fuzzy;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Sample> samples = Sample.generateSamples();

//        for (Sample s : samples) {
//            System.out.println(s);
//        }
//        System.out.println(samples.size());

        ANFIS anfis = new ANFIS(20, 2, 0.001, samples);

//        System.out.println(anfis.getSquareError());

        anfis.run(false);
    }



}
