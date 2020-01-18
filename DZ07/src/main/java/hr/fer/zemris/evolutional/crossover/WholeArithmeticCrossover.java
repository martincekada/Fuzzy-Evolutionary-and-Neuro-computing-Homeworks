package hr.fer.zemris.evolutional.crossover;

import hr.fer.zemris.evolutional.Unit;

import java.util.Random;

public class WholeArithmeticCrossover extends AbstractCrossover {

    @Override
    public Unit createChild(Unit[] parents) {
        int genomeLength = parents[0].getGenom().length;
        double[] newGenom = new double[genomeLength];

        for (int i = 0; i < genomeLength; ++i) {
                newGenom[i] = (parents[0].getGenom()[i] + parents[1].getGenom()[i]) / 2.;
        }

        return new Unit(newGenom);
    }
}
