package hr.fer.zemris.evolutional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Unit {
    public static double GENOM_UPPER_BOUND = 4;
    public static double GENOM_LOWER_BOUND = -4;

    public static int GENOM_LENGTH = 5;

    private double[] genom;
    private double penalty;

    public Unit(double[] genom) {
        this.genom = genom;
    }

    public static List<Unit> generatePopulation(int n) {
        List<Unit> units = new ArrayList<>(n);

        for (int i = 0; i < n; ++i) {
            units.add(new Unit(generateRandomGenome()));
        }

        return units;
    }

    public static double[] generateRandomGenome() {
        Random r = new Random();
        double[] genom = new double[GENOM_LENGTH];

        for (int i = 0; i < GENOM_LENGTH; ++i) {
            genom[i] = r.nextDouble() * 8 - 4;
        }

        return genom;
    }

    public double[] getGenom() {
        return genom;
    }

    public void setGenom(double[] genom) {
        for (int i = 0; i < GENOM_LENGTH; ++i) {
            if (genom[i] > GENOM_UPPER_BOUND) {
                genom[i] = GENOM_UPPER_BOUND;

            } else if (genom[i] < GENOM_LOWER_BOUND) {
                genom[i] = GENOM_LOWER_BOUND;
            }
        }

        this.genom = genom;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }
}
