package hr.fer.zemris.evolutional.selection;

import hr.fer.zemris.evolutional.Unit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TournamentSelection extends AbstractSelection {
    private int k;

    public TournamentSelection(int k) {
        this.k = k;
    }

    @Override
    public Unit[] selectParents(List<Unit> population) {
        List<Integer> contenders = new ArrayList<>(k);

        int counter = 0;
        Random r = new Random();
        while (counter < k) {
            int index = r.nextInt(population.size());

            if (!contenders.contains(index)) {
                contenders.add(index);
                counter++;
            }
        }


        int firstParent = Collections.min(contenders);
        contenders.remove(Integer.valueOf(firstParent));
        int secondParent = Collections.min(contenders);

        return new Unit[] {population.get(firstParent), population.get(secondParent)};

    }

    @Override
    public void setPopulation(List<Unit> population) {
    }
}
