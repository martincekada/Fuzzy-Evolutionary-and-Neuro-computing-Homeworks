package hr.fer.zemris.evolutional;

import hr.fer.zemris.evolutional.crossover.AbstractCrossover;
import hr.fer.zemris.evolutional.mutation.AbstractMutation;
import hr.fer.zemris.evolutional.selection.AbstractSelection;
import hr.fer.zemris.util.Evaluator;

import java.util.*;

public class Trainer {

    public Unit train(List<Unit> population, boolean elitism, int elite_size, AbstractCrossover crossover, AbstractSelection selection, AbstractMutation mutation, Evaluator evaluator, int max_iterations) {
        int populationSize = population.size();

        Unit best = new Unit(null);
        best.setPenalty(Double.MAX_VALUE);

        int iter_counter = 0;
        while (true) {
            if (iter_counter > max_iterations) {
                return best;
            }

            iter_counter++;

            evaluator.evaluate(population);

            population.sort(Comparator.comparing(Unit::getPenalty));

            if (best.getPenalty() > population.get(0).getPenalty()) {
                best = population.get(0);
                System.out.println(best.getPenalty());
                System.out.println("Current iteration: " + iter_counter);
            }

//            System.out.println(population.get(0).getPenalty());

            if (best.getPenalty() == 0) {
                return best;
            }


            if (elitism) {
                List<Integer> contenders = new ArrayList<>(3);

                int counter = 0;
                Random r = new Random();
                while (counter < 3) {
                    int index = r.nextInt(population.size());

                    if (!contenders.contains(index)) {
                        contenders.add(index);
                        counter++;
                    }
                }


                int firstParent = Collections.min(contenders);
                contenders.remove(Integer.valueOf(firstParent));

                int secondParent = Collections.min(contenders);
                contenders.remove(Integer.valueOf(secondParent));


                Unit child = crossover.createChild(new Unit[] {population.get(firstParent), population.get(secondParent)});
                mutation.mutate(child);

                population.set(contenders.get(0), child);



            } else {
                List<Unit> newPopulation = new ArrayList<>(populationSize);
                for (int i = 0; i < elite_size; ++i) {
                    newPopulation.add(population.get(i));
                }

                selection.setPopulation(population);
                for (int i = 0; i < populationSize - elite_size; ++i) {
                    Unit[] parents = selection.selectParents(population);
                    Unit child = crossover.createChild(parents);
                    mutation.mutate(child);
                    newPopulation.add(child);
                }
                population = newPopulation;
            }



        }
    }
}
