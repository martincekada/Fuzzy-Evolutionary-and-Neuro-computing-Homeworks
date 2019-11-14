package hr.fer.zemris.evolutional.crossover;

import hr.fer.zemris.evolutional.Unit;

public abstract class AbstractCrossover {

    public abstract Unit createChild(Unit[] parents);
}
