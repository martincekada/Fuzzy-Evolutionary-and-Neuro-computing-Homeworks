package hr.fer.zemris.evolutional.mutation;

import hr.fer.zemris.evolutional.Unit;

import java.util.Random;

public class AddMutation extends AbstractMutation {
    private double deviation;
    private double mutationProbability;

    public AddMutation(double deviation, double mutationProbability) {
        this.deviation = deviation;
        this.mutationProbability = mutationProbability;
    }

    @Override
    public void mutate(Unit u) {
        double[] newGenom = u.getGenom();

        Random r = new Random();
        for (int i = 0; i < newGenom.length; ++i) {

            if (r.nextDouble() < mutationProbability) {
                newGenom[i] += (r.nextGaussian() * deviation);
            }
        }

        u.setGenom(newGenom);
    }
}
