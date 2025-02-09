package hr.fer.zemris.fuzzy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));


        Defuzzifier def = new COADefuzzifier();

        FuzzySystem fsAkcel = new AkcelFuzzySystemMin(def);
        FuzzySystem fsHelm = new HelmFuzzySystemMin(def);




        int L=0,D=0,LK=0,DK=0,V=0,S=0,akcel,kormilo;
        String line = null;
        while(true){
            if((line = input.readLine())!=null){
                if(line.charAt(0)=='K') break;
                Scanner s = new Scanner(line);
                L = s.nextInt();
                D = s.nextInt();
                LK = s.nextInt();
                DK = s.nextInt();
                V = s.nextInt();
                S = s.nextInt();
            }

            akcel = fsAkcel.conclude(L, D, LK, DK, V, S);
            kormilo = fsHelm.conclude(L, D, LK, DK, V, S);
            System.out.println(akcel + " " + kormilo);
            System.err.println(akcel + " " + kormilo + " : V " + V + " L " + L + " D " + D + " LK " + LK + " DK" + DK);
            System.out.flush();
        }
    }
}
