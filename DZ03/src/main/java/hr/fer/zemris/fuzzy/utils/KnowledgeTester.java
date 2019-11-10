package hr.fer.zemris.fuzzy.utils;

import hr.fer.zemris.fuzzy.*;
import hr.fer.zemris.fuzzy.utils.sets.IFuzzySet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KnowledgeTester {

    public static void main(String[] args) throws IOException {
//        firstHelper();
        secondHelper();
    }

    public static void firstHelper() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));


        Defuzzifier def = new COADefuzzifier();

        System.out.println("Write rule number and L, D, LK, DK, V, S");

        int L=0,D=0,LK=0,DK=0,V=0,S=0, rule = 0,akcel,kormilo;

        String line = null;
        if ((line = input.readLine()) != null) {
            Scanner s = new Scanner(line);
            rule = s.nextInt();
            L = s.nextInt();
            D = s.nextInt();
            LK = s.nextInt();
            DK = s.nextInt();
            V = s.nextInt();
            S = s.nextInt();
        }

//        akcel = fsAkcel.conclude(L, D, LK, DK, V, S);
//        0 45 0 0 0 80 0


        List<Rule> rules = new ArrayList<>();
        rules.add(ModelRules.IF_CLOSE_RIGHT_TURN_LEFT);

        IFuzzySet result = rules.get(rule).resolve(L, D, LK, DK, V, S);

//        Debug.print(ModelRelations.ACCELERATE, "rule");

        Debug.print(result, "Result set");

        System.out.println(def.decode(result));
    }

    public static void secondHelper() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));


        Defuzzifier def = new COADefuzzifier();
        FuzzySystem fsAkcel = new HelmFuzzySystemMin(def);

        System.out.println("Write rule number and L, D, LK, DK, V, S");

        int L=0,D=0,LK=0,DK=0,V=0,S=0, rule = 0,akcel,kormilo;

        String line = null;
//        if ((line = input.readLine()) != null) {
            line = "0 229 38 0 0 80 0";
            Scanner s = new Scanner(line);
            rule = s.nextInt();
            L = s.nextInt();
            D = s.nextInt();
            LK = s.nextInt();
            DK = s.nextInt();
            V = s.nextInt();
            S = s.nextInt();
//        }

//        0 229 38 0 0 80 0


//        Debug.print(ModelRelations.ACCELERATE, "rule");

        Debug.print(fsAkcel.getConclusion(L, D, LK, DK, V, S), "Result set");
        System.out.println(fsAkcel.conclude(L, D, LK, DK, V, S));
    }
}
