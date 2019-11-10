package hr.fer.zemris.fuzzy.utils;

import hr.fer.zemris.fuzzy.utils.domain.DomainElement;
import hr.fer.zemris.fuzzy.utils.sets.CalculatedFuzzySet;
import hr.fer.zemris.fuzzy.utils.sets.IFuzzySet;
import hr.fer.zemris.fuzzy.utils.sets.StandardFuzzySets;

import static hr.fer.zemris.fuzzy.utils.ModelDomains.*;

public class ModelRelations {



    public static IFuzzySet GOING_SLOW = new CalculatedFuzzySet(
            VELOCITY,
            StandardFuzzySets.lFunction(VELOCITY.indexOfElement(DomainElement.of(0)), VELOCITY.indexOfElement(DomainElement.of(80)))
    );
    public static IFuzzySet ACCELERATE = new CalculatedFuzzySet(
            AKCELERATION,
            StandardFuzzySets.gammaFunction(AKCELERATION.indexOfElement(DomainElement.of(20)), AKCELERATION.indexOfElement(DomainElement.of(30)))
    );

    public static IFuzzySet CLOSE_TO_COAST = new CalculatedFuzzySet(
            DISTANCE,
            StandardFuzzySets.lFunction(DISTANCE.indexOfElement(DomainElement.of(30)), DISTANCE.indexOfElement(DomainElement.of(80)))
    );

    public static IFuzzySet TURN_LEFT = new CalculatedFuzzySet(
            ANGLE,
            StandardFuzzySets.gammaFunction(ANGLE.indexOfElement(DomainElement.of(60)), ANGLE.indexOfElement(DomainElement.of(80)))
    );


    public static IFuzzySet TURN_RIGHT = new CalculatedFuzzySet(
            ANGLE,
            StandardFuzzySets.lFunction(ANGLE.indexOfElement(DomainElement.of(-60)), ANGLE.indexOfElement(DomainElement.of(-80)))
    );

    public static IFuzzySet TURN_LEFT_EASY = new CalculatedFuzzySet(
            ANGLE,
            StandardFuzzySets.gammaFunction(ANGLE.indexOfElement(DomainElement.of(20)), ANGLE.indexOfElement(DomainElement.of(50)))
    );


    public static IFuzzySet TURN_RIGHT_EASY = new CalculatedFuzzySet(
            ANGLE,
            StandardFuzzySets.lFunction(ANGLE.indexOfElement(DomainElement.of(-20)), ANGLE.indexOfElement(DomainElement.of(-50)))
    );
}
