package hr.fer.zemris.evolutional.mutation;

import hr.fer.zemris.evolutional.Unit;

import java.util.Arrays;
import java.util.Random;

public class CompositeMutation extends AbstractMutation {
    private double[] probabilities;
    private AbstractMutation[] mutations;

    public CompositeMutation(int[] ratios, AbstractMutation... mutations) {
        this.mutations = mutations;

        this.probabilities = new double[ratios.length];

        double sum = 0;

        for (int i = 0; i < ratios.length; ++i) {
            sum += ratios[i];
        }

        for (int i = 0; i < ratios.length; ++i) {
            probabilities[i] = ratios[i] / sum;
        }

        System.out.println(Arrays.toString(probabilities));


    }

    @Override
    public void mutate(Unit u) {
        double prob = new Random().nextDouble();

        double sum = 0;

        for (int i = 0, n = probabilities.length; i < n; ++i) {
            sum += probabilities[i];
            if (prob < sum) {
                mutations[i].mutate(u);
                return;
            }
        }

        mutations[mutations.length - 1].mutate(u);

    }
}
