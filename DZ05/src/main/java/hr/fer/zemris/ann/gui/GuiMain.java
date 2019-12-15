package hr.fer.zemris.ann.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuiMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        JFrame frame = new JFrame();
                        frame.setLayout(new BorderLayout());

                        BasicComponent c = new BasicComponent();
                        frame.add(c, BorderLayout.CENTER);
                        frame.setSize(1000, 500);
                        frame.setVisible(true);

                        String[] alphabet = { "alpha", "beta", "gamma", "delta", "epsilon" };
                        JComboBox alphabetList = new JComboBox(alphabet);

                        frame.add(alphabetList, BorderLayout.NORTH);

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
                                c.gestureFinished(alphabetList.getSelectedIndex());
                            }
                        });
                    }
                }
        );
    }
}
