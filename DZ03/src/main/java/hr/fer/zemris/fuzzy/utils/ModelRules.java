package hr.fer.zemris.fuzzy.utils;

import hr.fer.zemris.fuzzy.Rule;;
import hr.fer.zemris.fuzzy.utils.sets.IFuzzySet;

import static hr.fer.zemris.fuzzy.utils.ModelRelations.*;

public class ModelRules {

    public static Rule IF_GOING_SLOW_THEN_ACCELERATE = new Rule(
            new IFuzzySet[] {null, null, null, null, GOING_SLOW, null},
            ACCELERATE
    );

    //    L, D, LK, DK, V, S

    public static Rule IF_CLOSE_RIGHT_TURN_LEFT = new Rule(
            new IFuzzySet[] {null, REALLY_CLOSE_TO_COAST, null, null, null, null},
            TURN_LEFT
    );


    public static Rule IF_CLOSE_LEFT_TURN_RIGHT = new Rule(
            new IFuzzySet[] {REALLY_CLOSE_TO_COAST, null, null, null, null, null},
            TURN_RIGHT
    );

    public static Rule IF_CLOSE_RIGHT_FRONT_TURN_LEFT_EASY = new Rule(
            new IFuzzySet[] {null, null, null, CLOSE_TO_COAST, null, null},
            TURN_LEFT_EASY
    );


    public static Rule IF_CLOSE_LEFT_FRONT_TURN_RIGHT_EASY = new Rule(
            new IFuzzySet[] {null, null, CLOSE_TO_COAST, null, null, null},
            TURN_RIGHT_EASY
    );
}
