package hr.fer.zemris.fuzzy.utils.sets;


import hr.fer.zemris.fuzzy.utils.Debug;
import hr.fer.zemris.fuzzy.utils.domain.Domain;
import hr.fer.zemris.fuzzy.utils.domain.DomainElement;
import hr.fer.zemris.fuzzy.utils.domain.IDomain;

public class Example {
    public static void main(String[] args) {
        IDomain d = Domain.intRange(0, 11); // {0,1,...,10}
        IFuzzySet set1 = new MutableFuzzySet(d)
                .set(DomainElement.of(0), 1.0)
                .set(DomainElement.of(1), 0.8)
                .set(DomainElement.of(2), 0.6)
                .set(DomainElement.of(3), 0.4)
                .set(DomainElement.of(4), 0.2);
        Debug.print(set1, "Set1:");
        IDomain d2 = Domain.intRange(-5, 6); // {-5,-4,...,4,5}
        IFuzzySet set2 = new CalculatedFuzzySet(
                d2,
                StandardFuzzySets.lambdaFunction(
                        d2.indexOfElement(DomainElement.of(-4)),
                        d2.indexOfElement(DomainElement.of( 0)),
                        d2.indexOfElement(DomainElement.of( 4))
                )
        );
        Debug.print(set2, "Set2 lambda:");

        set2 = new CalculatedFuzzySet(
                d2,
                StandardFuzzySets.gammaFunction(
                        d2.indexOfElement(DomainElement.of(-1)),
                        d2.indexOfElement(DomainElement.of( 4))
                )
        );
        Debug.print(set2, "Set2 gamma:");

        set2 = new CalculatedFuzzySet(
                d2,
                StandardFuzzySets.lFunction(
                        d2.indexOfElement(DomainElement.of(-1)),
                        d2.indexOfElement(DomainElement.of( 4))
                )
        );
        Debug.print(set2, "Set2 l:");
    }
}