package hr.fer.zemris.evolutional.crossover;

import hr.fer.zemris.evolutional.Unit;

public class CompositeCrossover extends AbstractCrossover {
    private AbstractCrossover[] crossovers;
    private int rotateCounter = 0;

    public CompositeCrossover(AbstractCrossover... crossovers) {
        this.crossovers = crossovers;
    }

    public Unit createChild(Unit[] parents) {
        rotateCounter++;

        return crossovers[rotateCounter % crossovers.length].createChild(parents);
    }
}
