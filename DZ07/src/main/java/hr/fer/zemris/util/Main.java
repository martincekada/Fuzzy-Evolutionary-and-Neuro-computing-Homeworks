package hr.fer.zemris.util;

import hr.fer.zemris.ann.NeuralNetwork;
import hr.fer.zemris.evolutional.Trainer;
import hr.fer.zemris.evolutional.Unit;
import hr.fer.zemris.evolutional.crossover.*;
import hr.fer.zemris.evolutional.mutation.AbstractMutation;
import hr.fer.zemris.evolutional.mutation.AddMutation;
import hr.fer.zemris.evolutional.mutation.CompositeMutation;
import hr.fer.zemris.evolutional.mutation.ReplaceMutation;
import hr.fer.zemris.evolutional.selection.AbstractSelection;
import hr.fer.zemris.evolutional.selection.TournamentSelection;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {
//        network2();
        network3();
    }

    public static void network3() throws IOException {
        List<Sample> samples = Sample.loadSamples();


        NeuralNetwork network = new NeuralNetwork(2 , 6, 4, 3);
        Evaluator evaluator = new Evaluator(network);


        AbstractMutation mutation1 = new AddMutation(1, 0.05);
        AbstractMutation mutation2 = new AddMutation(3, 0.001);
        AbstractMutation mutation3 = new ReplaceMutation(2, 0.004);
        AbstractMutation mutation = new CompositeMutation(new int[] {6, 2, 4}, mutation1, mutation2, mutation3);


        AbstractCrossover crossover1 = new DiscreteCrossover();
        AbstractCrossover crossover2 = new WholeArithmeticCrossover();
        AbstractCrossover crossover3 = new KPointCrossover(15);
        AbstractCrossover crossover = new CompositeCrossover(crossover1, crossover2, crossover3);

        AbstractSelection selection = new TournamentSelection(3);
        int population_size = 50;
        int max_iterations = 200_000;

        List<Unit> population = evaluator.generatePopulation(population_size);
        Unit best = new Trainer().train(population, true, 2, crossover, selection, mutation, evaluator, max_iterations);

        network.setGenome(best.getGenom());

        System.out.println(Arrays.toString(best.getGenom()));

        printNetworkPredictions(network, samples);
        System.out.println("Finished!");
    }

    public static void network2() throws IOException {
        List<Sample> samples = Sample.loadSamples();


        NeuralNetwork network = new NeuralNetwork(2 , 8, 4, 3);
        Evaluator evaluator = new Evaluator(network);


        AbstractMutation mutation1 = new AddMutation(1, 0.05);
        AbstractMutation mutation2 = new AddMutation(3, 0.001);
        AbstractMutation mutation3 = new ReplaceMutation(2, 0.004);
        AbstractMutation mutation = new CompositeMutation(new int[] {6, 2, 4}, mutation1, mutation2, mutation3);


        AbstractCrossover crossover1 = new DiscreteCrossover();
        AbstractCrossover crossover2 = new WholeArithmeticCrossover();
        AbstractCrossover crossover3 = new KPointCrossover(15);
        AbstractCrossover crossover = new CompositeCrossover(crossover1, crossover2, crossover3);

        AbstractSelection selection = new TournamentSelection(3);
        int population_size = 50;
        int max_iterations = 200_000;

        List<Unit> population = evaluator.generatePopulation(population_size);
        Unit best = new Trainer().train(population, true, 2, crossover, selection, mutation, evaluator, max_iterations);

        network.setGenome(best.getGenom());

        System.out.println(Arrays.toString(best.getGenom()));

        printNetworkPredictions(network, samples);
        System.out.println("Finished!");
    }

    public static void network1() throws IOException {
        List<Sample> samples = Sample.loadSamples();


        NeuralNetwork network = new NeuralNetwork(2 , 8, 3);
        Evaluator evaluator = new Evaluator(network);


        AbstractMutation mutation1 = new AddMutation(1, 0.05);
        AbstractMutation mutation2 = new AddMutation(3, 0.001);
        AbstractMutation mutation3 = new ReplaceMutation(2, 0.004);
        AbstractMutation mutation = new CompositeMutation(new int[] {6, 2, 4}, mutation1, mutation2, mutation3);


        AbstractCrossover crossover1 = new DiscreteCrossover();
        AbstractCrossover crossover2 = new WholeArithmeticCrossover();
        AbstractCrossover crossover3 = new KPointCrossover(10);
        AbstractCrossover crossover = new CompositeCrossover(crossover1, crossover2, crossover3);

        AbstractSelection selection = new TournamentSelection(3);
        int population_size = 50;
        int max_iterations = 200_000;

        List<Unit> population = evaluator.generatePopulation(population_size);
        Unit best = new Trainer().train(population, true, 2, crossover, selection, mutation, evaluator, max_iterations);

        network.setGenome(best.getGenom());

        System.out.println(Arrays.toString(best.getGenom()));

        printNetworkPredictions(network, samples);
        System.out.println("Finished!");
    }


    public static void printNetworkPredictions(NeuralNetwork network, List<Sample> samples) {
        int wrongs = 0;
        for (Sample s : samples) {
            double[] prediction = ClassDecoder.decode(network.predict(s));

            boolean eq = Arrays.equals(prediction, s.getOutput());

            if (!eq) wrongs++;

            System.out.println("Ground truth: " + Arrays.toString(s.getOutput()) + ", Prediction: " + Arrays.toString(prediction) + ", Equal:  " + eq);
        }

        System.out.println("Number of wrong predictions: " + wrongs);
        System.out.println("Number of correct predictions: " + (samples.size() - wrongs));

    }

}








































































