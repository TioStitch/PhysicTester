package org.tiostitch.fisic.tester;

import org.tiostitch.fisic.tester.solids.Solids;
import org.tiostitch.fisic.tester.utilities.SolidPlayer;

import javax.swing.*;
import java.awt.*;

public final class Panel extends JPanel {

    private static SolidPlayer solidPlayer;

    public Panel(Solids solido) {
        solidPlayer = new SolidPlayer();

        double x = solidPlayer.getX() + 0;
        double massa = solido.getMassa();

        solidPlayer.setX(x);
        solidPlayer.setMassa(massa);
        solidPlayer.setAceleracao(0.0);

        Timer timer = new Timer(1000/60, e -> reloadPaintTicks());
        timer.start();
    }

    private void reloadPaintTicks() {
        final double massa = solidPlayer.getMassa();

        final double fr_massa = 135;
        final double fr_acel = 6;
        final double fr_impul = (fr_massa * fr_acel);

        if (massa < fr_impul) {
            final double x = solidPlayer.getX();
            final double strength = (fr_impul - massa);

            solidPlayer.setX(x + strength);
            System.out.println(x);
            repaint();
            return;
        }

        System.out.println("Força nula!");
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        g2D.setColor(new Color(229, 211, 88, 255));
        g2D.fillRect(0, 0, 600, 400);

        int yHeight = 100;
        int xWidth = 600;
        int xPlan = 0;
        g2D.setColor(Color.GRAY);
        g2D.fillRect(xPlan, 280, xWidth, yHeight);

        solidFunction(g2D);
    }

    private void solidFunction(Graphics2D g2D) {


        g2D.setColor(new Color(112, 178, 21));
        g2D.fillRect((int) (solidPlayer.getX() + 2), 270, 50, 50);
    }
}
