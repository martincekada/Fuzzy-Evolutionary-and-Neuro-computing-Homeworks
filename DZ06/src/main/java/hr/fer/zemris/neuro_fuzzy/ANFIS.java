package hr.fer.zemris.neuro_fuzzy;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class ANFIS {
    private int noOfEpochs;
    private int noOfRules;
    private double learningRate;
    private List<Sample> samples;
    private List<Rule> rules;

    public ANFIS(int noOfEpochs, int noOfRules, double learningRate, List<Sample> samples) {
        this.noOfEpochs = noOfEpochs;
        this.noOfRules = noOfRules;
        this.learningRate = learningRate;
        this.samples = samples;
        this.rules = new ArrayList<>(noOfRules);

        for (int i = 0; i < noOfRules; ++i) {
            rules.add(Rule.generateRandomRule());
        }

    }

    public void run(boolean stohastic) {
        for (int i = 0; i < noOfEpochs; ++i) {
            runEpoche(stohastic);

//            if (i % 100 == 0) {
                System.out.println(i + " " + getAbsError());
//            }
        }
    }

    private void runEpoche(boolean stohastic) {
        for (Sample sample : samples) {
            double out = predict(sample);


            double weightedZSum = getWeightedZSum(sample);
            double PISum = getPISum(sample);

            double predictDiff = sample.f - out;

            for (Rule r : rules) {


                r.accumulateRuleChange(predictDiff, weightedZSum, PISum, sample, learningRate);

                boolean test = stohastic == true;
                if (stohastic == true) {
                    r.changeRuleParams();
                }
            }
        }

        if (!stohastic) {
            for (Rule r : rules) {
                r.changeRuleParams();
            }
        }
    }

    private double getPISum(Sample example) {
        double denominatorSum = 0;

        for (Rule rule : rules) {
            denominatorSum += rule.getPI(example.x, example.y);
        }

        return denominatorSum;
    }

    private double getWeightedZSum(Sample example) {
        double nominatorSum = 0;

        for (Rule rule : rules) {
            nominatorSum += (rule.getPI(example.x, example.y) * rule.getZ(example.x, example.y));
        }

        return nominatorSum;
    }


    public double predict(Sample example) {
        double nominatorSum = 0;
        double denominatorSum = 0;

        for (Rule rule : rules) {
            nominatorSum += (rule.getPI(example.x, example.y) * rule.getZ(example.x, example.y));
            denominatorSum += rule.getPI(example.x, example.y);
        }


        return nominatorSum / denominatorSum;
    }

    public double getAbsError() {
        double error = 0;

        for (Sample s : samples) {
            error += abs(predict(s) - s.f);
        }

        return error / samples.size();
    }

    public List<Rule> getRules() {
        return rules;
    }

    //    public double getSquareError() {
//        double error = 0;
//
//        for (Sample s : samples) {
//            error += (0.5 * pow(predict(s) - s.f, 2));
//        }
//
//        return error;
//    }
}
