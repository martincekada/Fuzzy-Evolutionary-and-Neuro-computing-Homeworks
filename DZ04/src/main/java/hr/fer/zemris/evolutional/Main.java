package hr.fer.zemris.evolutional;

import hr.fer.zemris.evolutional.crossover.AbstractCrossover;
import hr.fer.zemris.evolutional.crossover.DiscreteCrossover;
import hr.fer.zemris.evolutional.mutation.AbstractMutation;
import hr.fer.zemris.evolutional.mutation.Mutation;
import hr.fer.zemris.evolutional.selection.AbstractSelection;
import hr.fer.zemris.evolutional.selection.TournamentSelection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
//        Current iteration: 80000
//                [0.3717879852995899, -0.12248780777917442, 3.520103910475043, 1.3240780727507064, -1.33156958248034]
//        3.8353245912228525E-5
//        pop = 50, elite= 2, mut(3, 0.5), tournament(3)


//[2.7724311925749596, 0.12248892697782074, 3.5162445480978795, 1.3165427494771502, -1.3234180356468213]
//        4.815536871489194E-6
        //        pop = 10, elite= 1, mut(3, 0.5), tournament(3)


        AbstractMutation mutation = new Mutation(3, 0.4);
        AbstractCrossover crossover = new DiscreteCrossover();
        AbstractSelection selection = new TournamentSelection(5);

        int population_size = 50;

        new Trainer().train(population_size, true, 1, crossover, selection, mutation);

    }
}
