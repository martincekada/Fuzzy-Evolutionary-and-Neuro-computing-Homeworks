package hr.fer.zemris.ann.gui;

import hr.fer.zemris.ann.LetterDecoder;
import hr.fer.zemris.ann.NeuralNetwork;
import hr.fer.zemris.ann.Sample;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BasicComponent extends JComponent {
    List<Point> points = new ArrayList<>();

    public BasicComponent() {

    }



    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        for (Point p : points) {
            g2.drawRect( (int) p.x, (int) p.y, 1, 1);
        }
    }

    public void addPoint(java.awt.Point locationOnScreen) {
        points.add(new Point(locationOnScreen.x, locationOnScreen.y));

//        System.out.println(new Point(locationOnScreen.x, locationOnScreen.y));
    }

    public void gestureFinished(int index) {
        GesturesConverter.writeGestureToFile(points, index);

        points.clear();
    }

    public String guessAlphabet(NeuralNetwork network) {
        double[] input = GesturesConverter.getVector(points);

        try {
            double[] prediction = network.predict(new Sample(input, null));
            String letter = LetterDecoder.decode(prediction);
            points.clear();
            return letter;
        } catch (IllegalArgumentException e) {
            points.clear();
            return "Draw a bit slower please";
        }
    }
}
