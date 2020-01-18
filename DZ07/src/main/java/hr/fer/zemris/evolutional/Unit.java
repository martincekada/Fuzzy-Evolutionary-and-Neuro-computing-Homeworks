package hr.fer.zemris.evolutional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Unit {
    private double[] genom;
    private double penalty;

    public Unit(double[] genom) {
        this.genom = genom;
    }

    public double[] getGenom() {
        return genom;
    }

    public void setGenom(double[] genom) {
        this.genom = genom;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }
}
