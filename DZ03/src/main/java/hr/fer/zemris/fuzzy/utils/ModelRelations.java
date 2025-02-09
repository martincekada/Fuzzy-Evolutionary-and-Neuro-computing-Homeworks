package hr.fer.zemris.fuzzy.utils;

import hr.fer.zemris.fuzzy.utils.domain.DomainElement;
import hr.fer.zemris.fuzzy.utils.sets.CalculatedFuzzySet;
import hr.fer.zemris.fuzzy.utils.sets.IFuzzySet;
import hr.fer.zemris.fuzzy.utils.sets.StandardFuzzySets;

import static hr.fer.zemris.fuzzy.utils.ModelDomains.*;

public class ModelRelations {



    public static IFuzzySet GOING_SLOW = new CalculatedFuzzySet(
            VELOCITY,
            StandardFuzzySets.lFunction(VELOCITY.indexOfElement(DomainElement.of(0)), VELOCITY.indexOfElement(DomainElement.of(50)))
    );
    public static IFuzzySet ACCELERATE = new CalculatedFuzzySet(
            AKCELERATION,
            StandardFuzzySets.gammaFunction(AKCELERATION.indexOfElement(DomainElement.of(10)), AKCELERATION.indexOfElement(DomainElement.of(30)))
    );

    public static IFuzzySet CLOSE_TO_COAST = new CalculatedFuzzySet(
            DISTANCE,
            StandardFuzzySets.lFunction(DISTANCE.indexOfElement(DomainElement.of(50)), DISTANCE.indexOfElement(DomainElement.of(65)))
    );

    public static IFuzzySet REALLY_CLOSE_TO_COAST = new CalculatedFuzzySet(
            DISTANCE,
            StandardFuzzySets.lFunction(DISTANCE.indexOfElement(DomainElement.of(40)), DISTANCE.indexOfElement(DomainElement.of(50)))
    );

    public static IFuzzySet TURN_LEFT = new CalculatedFuzzySet(
            ANGLE,
            StandardFuzzySets.gammaFunction(ANGLE.indexOfElement(DomainElement.of(70)), ANGLE.indexOfElement(DomainElement.of(90)))
    );


    public static IFuzzySet TURN_RIGHT = new CalculatedFuzzySet(
            ANGLE,
            StandardFuzzySets.lFunction(ANGLE.indexOfElement(DomainElement.of(-70)), ANGLE.indexOfElement(DomainElement.of(-90)))
    );

    public static IFuzzySet TURN_LEFT_EASY = new CalculatedFuzzySet(
            ANGLE,
            StandardFuzzySets.gammaFunction(ANGLE.indexOfElement(DomainElement.of(60)), ANGLE.indexOfElement(DomainElement.of(70)))
    );


    public static IFuzzySet TURN_RIGHT_EASY = new CalculatedFuzzySet(
            ANGLE,
            StandardFuzzySets.lFunction(ANGLE.indexOfElement(DomainElement.of(-60)), ANGLE.indexOfElement(DomainElement.of(-70)))
    );

    public static IFuzzySet BACKWARDS = new CalculatedFuzzySet(
            DIRECTION,
            StandardFuzzySets.lFunction(DIRECTION.indexOfElement(DomainElement.of(0)), DIRECTION.indexOfElement(DomainElement.of(1)))
    );
}
