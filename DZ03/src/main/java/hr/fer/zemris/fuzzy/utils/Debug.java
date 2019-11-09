package hr.fer.zemris.fuzzy.utils;


import hr.fer.zemris.fuzzy.utils.domain.DomainElement;
import hr.fer.zemris.fuzzy.utils.domain.IDomain;
import hr.fer.zemris.fuzzy.utils.sets.IFuzzySet;

public class Debug {

    public static void print(IDomain domain, String headingText) {
        if(headingText!=null) {
            System.out.println(headingText);
        }
        for(DomainElement e : domain) {
            System.out.println("Element domene: " + e);
        }
        System.out.println("Kardinalitet domene je: " + domain.getCardinality());
        System.out.println();
    }

    public static void print(IFuzzySet set, String headingText) {
        if(headingText!=null) {
            System.out.println(headingText);
        }
        for(DomainElement e : set.getDomain()) {
            System.out.println(String.format("d(%s) = %.2f", printElement(e), set.getValueAt(e)));
        }
        System.out.println();
    }

    private static String printElement(DomainElement e) {
        return String.valueOf(e.getComponentValue(0));
    }
}
