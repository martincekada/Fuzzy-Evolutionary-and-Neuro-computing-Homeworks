package hr.fer.zemris.util;

public class ClassDecoder {
    public static double[] decode(double[] prediction) {

        int largest = 0;
        for ( int i = 1; i < prediction.length - 1; i++ ) {
            if (prediction[i] > prediction[largest]) largest = i;
        }

//        System.out.println(Arrays.toString(prediction));

        switch(largest) {
            case 0:
                return new double[] {1, 0, 0};
            case 1:
                return new double[] {0, 1, 0};
            case 2:
                return new double[] {0, 0, 1};
            default:
                throw new UnsupportedOperationException("Unknown class");
        }
    }
}
