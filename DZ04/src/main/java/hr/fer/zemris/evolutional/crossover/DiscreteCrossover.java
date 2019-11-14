package hr.fer.zemris.evolutional.crossover;

import hr.fer.zemris.evolutional.Unit;

import java.util.Random;

import static hr.fer.zemris.evolutional.Unit.GENOM_LENGTH;

public class DiscreteCrossover extends AbstractCrossover {

    @Override
    public Unit createChild(Unit[] parents) {
        double[] newGenom = new double[GENOM_LENGTH];

        Random r = new Random();
        for (int i = 0; i < GENOM_LENGTH; ++i) {
            if (r.nextDouble() < 0.5) {
                newGenom[i] = parents[0].getGenom()[i];

            } else {
                newGenom[i] = parents[1].getGenom()[i];
            }
        }

        return new Unit(newGenom);
    }
}
