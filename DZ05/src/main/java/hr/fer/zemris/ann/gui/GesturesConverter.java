package hr.fer.zemris.ann.gui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class GesturesConverter {

    public static int M = 5;
    public static String FILE_PATH = "./src/main/resources/gestures.txt";

    public static void writeGestureToFile(List<Point> points, int alphabetIndex) {
        Point center = findCenter(points);

        substractCenterFromAllPoints(points, center);

        double m = findBigestCoordinate(points);

        scalePoints(points, m);

        List<Point> relevantPoints = findRelevantPoints(points);

        try {
            writeToFile(relevantPoints, alphabetIndex);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ooupsy daisy");
        }
    }

    public static double[] getVector(List<Point> points) {
        Point center = findCenter(points);

        substractCenterFromAllPoints(points, center);

        double m = findBigestCoordinate(points);

        scalePoints(points, m);

        List<Point> relevantPoints = findRelevantPoints(points);

        double[] vector = new double[relevantPoints.size() * 2];

        int i = 0;
        for (Point p : relevantPoints) {
            vector[i++] = p.x;
            vector[i++] = p.y;
        }

        return vector;
    }

    private static void writeToFile(List<Point> relevantPoints, int alphabetIndex) throws IOException {
        StringJoiner sj = new StringJoiner(" ");

        for (Point p : relevantPoints) {
            sj.add(String.valueOf(p.x));
            sj.add(String.valueOf(p.y));
        }

//        for (Point p : relevantPoints) {
//            sj.add("(" + p.x + ", " + p.y + ")");
////            sj.add(String.valueOf(p.y));
//        }



        for (int i = 0; i < 5; ++i) {
            if (i == alphabetIndex) {
                sj.add("1");
            } else {
                sj.add("0");
            }
        }

        File file = new File(FILE_PATH);
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter br = new BufferedWriter(fr);
        br.write(sj.toString() + "\n");

        br.flush();
        fr.flush();

        br.close();
        fr.close();

    }

    private static List<Point> findRelevantPoints(List<Point> points) {
        List<Point> relevant = new ArrayList<>();
        relevant.add(points.get(0));

        double d = calculateGestureLenght(points);
        double distance = d / M;

        double accumulate = 0;
        for (int i = 1, n = points.size(); i < n; ++i) {
            double currX = points.get(i).x;
            double currY = points.get(i).y;

            double prevX = points.get(i - 1).x;
            double prevY = points.get(i - 1).y;

            double diffXsq = Math.pow(currX - prevX, 2);
            double diffYsq = Math.pow(currY - prevY, 2);

            accumulate += Math.sqrt(diffXsq + diffYsq);

            if (accumulate >= distance) {
                relevant.add(points.get(i - 1));
                accumulate = 0;
            }
        }

        System.out.println("Relevant size: " + relevant.size());

        return relevant;
    }

    private static double calculateGestureLenght(List<Point> points) {
        double lenght = 0;

        for (int i = 1, n = points.size(); i < n; ++i) {
            double currX = points.get(i).x;
            double currY = points.get(i).y;

            double prevX = points.get(i - 1).x;
            double prevY = points.get(i - 1).y;

            double diffXsq = Math.pow(currX - prevX, 2);
            double diffYsq = Math.pow(currY - prevY, 2);

            lenght += Math.sqrt(diffXsq + diffYsq);
        }

        return lenght;
    }

    private static void scalePoints(List<Point> points, double m) {
        for (Point p : points) {
            p.x /= m;
            p.y /= m;
        }
    }

    private static double findBigestCoordinate(List<Point> points) {
        double maxi = -1;

        for (Point p : points) {
            if (Math.abs(p.x) > maxi) {
                maxi = Math.abs(p.x);
            }

            if (Math.abs(p.y) > maxi) {
                maxi = Math.abs(p.y);
            }
        }

        return maxi;
    }

    private static void substractCenterFromAllPoints(List<Point> points, Point center) {
        for (Point p : points) {
            p.x -= center.x;
            p.y -= center.y;
        }
    }

    private static Point findCenter(List<Point> points) {
        double sumX = 0;
        double sumY = 0;

        for (Point p : points) {
            sumX += p.x;
            sumY += p.y;
        }

        return new Point(sumX / points.size(), sumY / points.size());
    }
}
