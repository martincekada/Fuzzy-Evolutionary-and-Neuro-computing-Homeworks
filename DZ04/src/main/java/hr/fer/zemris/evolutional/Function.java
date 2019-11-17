package hr.fer.zemris.evolutional;

import java.io.IOException;
import java.util.List;

import static java.lang.Math.*;

public class Function {
    private static List<Record> records;
    static {
        List<Record> tmp = null;

        try {
            tmp = Record.loadRecordsFromFile("./src/main/resources/zad4-dataset1.txt");
        } catch (IOException e) {
            System.err.println("Could not read dataset!");
        }
        records = tmp;
    }


    public static double valueFor(double x, double y, double[] params) {

        double first = sin(params[0] + params[1] * x);
        double second = params[2] * cos(x * (params[3] + y));
        double third = 1 / (1 + exp(pow(x - params[4], 2)));

        return first + second * third;
    }

    public static void evaluate(List<Unit> population) {

        for (Unit u : population) {
            double penalty = 0;

            for (Record r : records) {
                double unit_output = valueFor(r.x, r.y, u.getGenom());

                penalty += pow(unit_output - r.out, 2);
            }

            u.setPenalty(penalty / records.size());
        }

    }
}
