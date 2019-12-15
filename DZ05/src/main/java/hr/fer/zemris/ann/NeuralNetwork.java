package hr.fer.zemris.ann;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.lang.Math.pow;

public class NeuralNetwork {
    private List<Layer> layers;
    private static int MAX_ITERS = 5_000;


    public NeuralNetwork(int... layers) {
        this.layers = new ArrayList<>();

        for (int i = 1; i < layers.length; ++i) {
            this.layers.add(new Layer(layers[i], layers[i - 1] + 1));
        }
    }

    public double[] predict(Sample sample) {
        double[] result = sample.getInput();

        for (Layer l : layers) {
            result = l.getOutputFor(result);
        }

        return result;
    }

    public void train(List<Sample> samples, int algorithmCode) {

        if (algorithmCode == 1) groupLearning(samples);
        else if (algorithmCode == 2) stohasticLearning(samples);
        else if (algorithmCode == 3) miniBathesLearning(samples);
        else throw new UnsupportedOperationException("Nepoznati broj algoritma");

        learnOn(samples);
    }

    private void groupLearning(List<Sample> samples) {
        int iter = 0;
        while(calculateError(samples) > 0.00000001 && iter < MAX_ITERS) {
            learnOn(samples);

            if (iter % 10_00 == 0) {
                printError(samples);
            }
            iter++;
        }

    }

    private void stohasticLearning(List<Sample> samples) {
        Random r = new Random();

        List<Sample> oneSampleList = new ArrayList<>();
        int iter = 0;
        while(calculateError(samples) > 0.0000001 && iter < MAX_ITERS * 5) {
            for (Sample s : samples) {
                oneSampleList.add(s);
                learnOn(oneSampleList);
                oneSampleList.clear();

                if (iter % (5_000) == 0) {
                    System.out.println(iter);
                    printError(samples);
                }
                iter++;
            }
        }

    }


    private void miniBathesLearning(List<Sample> samples) {
        List<Sample> mini1 = new ArrayList<>();
        List<Sample> mini2 = new ArrayList<>();
        List<Sample> mini3 = new ArrayList<>();
        List<Sample> mini4 = new ArrayList<>();
        List<Sample> mini5 = new ArrayList<>();


        int batchCounter = 0;
        int samplesCounter = 0;
        for (int i = 0; i < samples.size(); ++i) {
            if (samplesCounter++ == 2) {
                samplesCounter = 0;
                batchCounter += 1;
                batchCounter %= 5;
            }

            switch (batchCounter){
                case(0):
                    mini1.add(samples.get(i));
                    break;
                case(1):
                    mini2.add(samples.get(i));
                    break;
                case(2):
                    mini3.add(samples.get(i));
                    break;
                case(3):
                    mini4.add(samples.get(i));
                    break;
                case(4):
                    mini5.add(samples.get(i));
                    break;
            }

        }



        int iter = 0;
        while(calculateError(samples) > 0.00000001 && iter < MAX_ITERS) {
            learnOn(mini1);
            learnOn(mini2);
            learnOn(mini3);
            learnOn(mini4);
            learnOn(mini5);

            if (iter % 10_00 == 0) {
                System.out.println(iter);
                printError(samples);
            }
            iter++;
        }

    }



    private void learnOn(List<Sample> samples) {

        for (Sample s : samples) {
            addOutputFor(s);
            addErrorFor(s);
        }

        generateNewWeights(samples);
        startUsingNewWeights();
        resetAllData();
    }

    private void resetAllData() {
        for (Layer l : layers) {
            l.resetAllData();
        }
    }

    private void startUsingNewWeights() {
        for (Layer l : layers) {
            l.startUsingNewWeights();
        }
    }

    private void generateNewWeights(List<Sample> samples) {
        Layer firstLayer = layers.get(0);

        firstLayer.generateNewWeights(samples);

        for (int i = 1, n = layers.size(); i < n; ++i) {
            layers.get(i).genereteNewWeights(layers.get(i - 1));
        }


    }

    private void addOutputFor(Sample sample) {
        double[] result = sample.getInput();

        for (Layer l : layers) {
            result = l.addOutputFor(result);
        }
    }

    private void addErrorFor(Sample sample) {
        Layer outputLayer = layers.get(layers.size() - 1);

        outputLayer.addErrorFor(sample);

        for (int i = layers.size() - 2; i >= 0; i--) {
            layers.get(i).addErrorFor(layers.get(i + 1));
        }

    }


    private void printError(List<Sample> samples) {
        System.out.println("Current error: " + calculateError(samples));

    }

    private double calculateError(List<Sample> samples) {
        double[] prediction;
        double error = 0;

        for (Sample s : samples) {
            prediction = predict(s);

            double[] target = s.getOutput();

            for (int i = 0; i < target.length; ++i) {
                error += pow(target[i] - prediction[i], 2);
            }
        }

        return error;
    }
}
