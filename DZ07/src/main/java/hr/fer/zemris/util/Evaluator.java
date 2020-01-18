package hr.fer.zemris.util;

import hr.fer.zemris.ann.NeuralNetwork;
import hr.fer.zemris.evolutional.Unit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

public class Evaluator {
    private static List<Sample> samples;
    static {
        List<Sample> tmp = null;

        try {
            tmp = Sample.loadSamples();
        } catch (IOException e) {
            System.err.println("Could not read dataset!");
        }
        samples = tmp;
    }

    private NeuralNetwork network;

    public Evaluator(NeuralNetwork network) {
        this.network = network;
    }

    public void evaluate(List<Unit> population) {
        for (Unit u : population) {
            network.setGenome(u.getGenom());

            u.setPenalty(network.calculateError(samples) / samples.size());
        }

    }

    public List<Unit> generatePopulation(int population_size) {
        List<Unit> population = new ArrayList<>(population_size);

        for (int i = 0; i < population_size; ++i) {
            population.add(new Unit(new NeuralNetwork(network.getLayers()).getGenome()));
        }

        return population;
    }
}
