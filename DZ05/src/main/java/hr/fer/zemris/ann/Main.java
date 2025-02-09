package hr.fer.zemris.ann;

import hr.fer.zemris.ann.gui.BasicComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static hr.fer.zemris.ann.gui.GesturesConverter.M;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Sample> samples = Sample.loadGesture();

//        za M = 5, GesturesConverter(m, path)
        NeuralNetwork network = new NeuralNetwork(2 * M, 6, 6, 5);
        network.train(samples, 3);

//        M = 20
//        NeuralNetwork network = new NeuralNetwork(2 * M, 50, 10, 5);
//        network.train(samples, 1);


        System.out.println("Finished!");

        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        JFrame frame = new JFrame();
                        frame.setLayout(new BorderLayout());

                        BasicComponent c = new BasicComponent();
                        frame.add(c, BorderLayout.CENTER);
                        frame.setSize(1000, 500);
                        frame.setVisible(true);

                        c.addMouseMotionListener(new MouseMotionAdapter() {
                            @Override
                            public void mouseDragged(MouseEvent e) {
                                c.addPoint(e.getLocationOnScreen());
                                c.repaint();
                            }
                        });

                        c.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseReleased(MouseEvent e) {
                                String letter = c.guessAlphabet(network);
                                System.out.println(letter);
                            }
                        });
                    }
                }
        );

    }
}
