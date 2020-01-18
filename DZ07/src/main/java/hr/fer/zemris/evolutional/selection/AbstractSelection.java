package hr.fer.zemris.evolutional.selection;

import hr.fer.zemris.evolutional.Unit;

import java.util.List;

public abstract class AbstractSelection {

    public abstract Unit[] selectParents(List<Unit> population);

    public abstract void setPopulation(List<Unit> population);
}
