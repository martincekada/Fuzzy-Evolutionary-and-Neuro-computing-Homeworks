package hr.fer.zemris.ann;

import java.util.Arrays;

public class LetterDecoder {
    public static String decode(double[] prediction) {

        int largest = 0;
        for ( int i = 1; i < prediction.length - 1; i++ ) {
            if (prediction[i] > prediction[largest]) largest = i;
        }

        System.out.println(Arrays.toString(prediction));

        switch(largest) {
            case 0:
                return "Alpha";
            case 1:
                return "Beta";
            case 2:
                return "Gamma";
            case 3:
                return "Delta";
            case 4:
                return "Epsilon";
            default:
                throw new UnsupportedOperationException("Nema slova");
        }
    }
}
