package hr.fer.zemris.neuro_fuzzy;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        thirdTask();
//        forthTask();
//        fifthTask();
//        seventhTask();
//        eightTask();

        List<Sample> samples = Sample.generateSamples();

        ANFIS anfis = new ANFIS(10_000, 5, 0.0001, samples);
        anfis.run(false);

    }

    private static void eightTask() {
        List<Sample> samples = Sample.generateSamples();

//        GRUPNI
//        ANFIS anfis = new ANFIS(10_000, 5, 0.0009, samples);
//        anfis.run(false);

//        ANFIS anfis = new ANFIS(10_000, 5, 0.0001, samples);
//        anfis.run(false);
////
//        ANFIS anfis = new ANFIS(10_000, 5, 0.00001, samples);
//        anfis.run(false);

//        STOHASTICKI
//        ANFIS anfis = new ANFIS(10_000, 5, 0.0009, samples);
//        anfis.run(true);

//        ANFIS anfis = new ANFIS(10_000, 5, 0.0001, samples);
//        anfis.run(true);
////
//        ANFIS anfis = new ANFIS(10_000, 5, 0.00001, samples);
//        anfis.run(true);
    }


    private static void seventhTask() {
        List<Sample> samples = Sample.generateSamples();
//        ANFIS anfis = new ANFIS(10_000, 5, 0.0001, samples);
//
//        anfis.run(true);

        ANFIS anfis = new ANFIS(10_000, 5, 0.0001, samples);
        anfis.run(false);
    }

    private static void fifthTask() {
        List<Sample> samples = Sample.generateSamples();
        ANFIS anfis = new ANFIS(10_000, 5, 0.0001, samples);

        anfis.run(false);



        for (Rule r : anfis.getRules()) {
            System.out.println("(1 / (1 + exp(" + r.b + " * (x - " + r.a + ")))) title 'X',\\");
            System.out.println("(1 / (1 + exp(" + r.d + " * (x - " + r.c + ")))) title 'Y'");
            System.out.println("--");
        }

    }

    private static void forthTask() {
        List<Sample> samples = Sample.generateSamples();

//        ANFIS anfis = new ANFIS(10_000, 1, 0.0001, samples);
//        ANFIS anfis = new ANFIS(10_000, 2, 0.0001, samples);
        ANFIS anfis = new ANFIS(10_000, 50, 0.0001, samples);

        anfis.run(false);

//        for (Sample s : samples) {
//            System.out.println(s.toString() + anfis.predict(s));
//        }

        for (Sample s : samples) {
            System.out.println(s.toString() + (anfis.predict(s) - s.f));
        }


    }

    public static void thirdTask() {
        List<Sample> samples = Sample.generateSamples();

        for (Sample s : samples) {
            System.out.println(s);
        }
    }



}

