package org.tiostitch.fisic.tester;

import org.tiostitch.fisic.tester.solids.Solids;
import org.tiostitch.fisic.tester.utilities.SolidPlayer;

import javax.swing.*;
import java.awt.*;

public final class Panel extends JPanel {

    private static SolidPlayer solidPlayer;

    public Panel(Solids solido) {
        solidPlayer = new SolidPlayer();

        final double x = solidPlayer.getX();
        final double massa = solido.getMassa();

        solidPlayer.setX(x);
        solidPlayer.setMassa(massa);
        solidPlayer.setName(solido.getName());

        final double fr_result = 140;
        final double fr_massa = solidPlayer.getMassa();
        final double fr_aceleration = (fr_result / fr_massa);

        final Timer timer = new Timer(1000/60, e -> reloadPaintTicks(fr_aceleration));
        timer.start();
    }

    private void reloadPaintTicks(double aceleracao) {
        final double x = solidPlayer.getX();

        solidPlayer.setX((x + aceleracao));
        System.out.println(x);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        final Graphics2D g2D = (Graphics2D) g;

        //Criação do Fundo
        final int nulledSize = 0;
        final int width = 600, height = 400;

        g2D.setColor(new Color(229, 211, 88, 255));
        g2D.fillRect(nulledSize, nulledSize, width, height);

        //Criação do Piso
        final int yPlan = 280;
        final int yHeight = 100;
        final int xWidth = 600;

        g2D.setColor(Color.GRAY);
        g2D.fillRect(nulledSize, yPlan, xWidth, yHeight);

        solidFunction(g2D);
    }

    private void solidFunction(Graphics2D g2D) {
        g2D.setColor(new Color(112, 178, 21));
        g2D.drawString(solidPlayer.getName(), (int) solidPlayer.getX(), 270);
        g2D.fillRect((int) solidPlayer.getX(), 270, 50, 50);
    }
}
