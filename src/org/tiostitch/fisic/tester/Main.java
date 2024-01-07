package org.tiostitch.fisic.tester;

import org.tiostitch.fisic.tester.solids.Square;

import javax.swing.*;

public class Main extends JFrame {

    public Main() {
        setTitle("Fisic Tester");
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Panel panel = new Panel(new Square());
        add(panel);

        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args) {
        new Main();
    }
}
