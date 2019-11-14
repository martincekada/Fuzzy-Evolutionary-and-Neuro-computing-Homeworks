package hr.fer.zemris.evolutional.mutation;

import hr.fer.zemris.evolutional.Unit;

import java.util.Random;

import static hr.fer.zemris.evolutional.Unit.GENOM_LENGTH;

public class Mutation extends AbstractMutation {
    private double mutationStrength;
    private double mutationProbability;

    public Mutation(double mutationStrength, double mutationProbability) {
        this.mutationStrength = mutationStrength;
        this.mutationProbability = mutationProbability;
    }

    @Override
    public void mutate(Unit u) {
        double[] newGenom = u.getGenom();

        Random r = new Random();
        for (int i = 0; i < GENOM_LENGTH; ++i) {

            if (r.nextDouble() < mutationProbability) {
                newGenom[i] = newGenom[i] * (r.nextDouble() * 2 * mutationStrength - mutationStrength);
            }
        }

        u.setGenom(newGenom);
    }
}
