package hr.fer.zemris.evolutional.crossover;

import hr.fer.zemris.evolutional.Unit;

public class KPointCrossover extends AbstractCrossover {
    private int numberOfKPoints;

    public KPointCrossover(int numberOfKPoints) {
        this.numberOfKPoints = numberOfKPoints;
    }

    @Override
    public Unit createChild(Unit[] parents) {
        int genomeLength = parents[0].getGenom().length;
        double[] newGenom = new double[genomeLength];

        int k = genomeLength / numberOfKPoints;

        boolean change = true;
        for (int i = 0; i < genomeLength; ++i) {
            if (i >= k) {
                change = !change;
                k += k;
            }


            if (change) {
                newGenom[i] = parents[0].getGenom()[i];

            } else {
                newGenom[i] = parents[1].getGenom()[i];
            }
        }

        return new Unit(newGenom);
    }
}
