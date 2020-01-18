package hr.fer.zemris.evolutional.crossover;

import hr.fer.zemris.evolutional.Unit;

import java.util.Random;

public class DiscreteCrossover extends AbstractCrossover {

    @Override
    public Unit createChild(Unit[] parents) {
        int genomeLength = parents[0].getGenom().length;
        double[] newGenom = new double[genomeLength];

        Random r = new Random();
        for (int i = 0; i < genomeLength; ++i) {
            if (r.nextDouble() < 0.5) {
                newGenom[i] = parents[0].getGenom()[i];

            } else {
                newGenom[i] = parents[1].getGenom()[i];
            }
        }

        return new Unit(newGenom);
    }
}
