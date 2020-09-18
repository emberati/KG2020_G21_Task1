package com.github.emberati.task.kg2020_g21_task1.gui;

import com.github.emberati.task.kg2020_g21_task1.GradientDrawer;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;

import static java.lang.Math.pow;

public class MainPanel extends JPanel {

    @Override
    public void paint(Graphics g) {
        BufferedImage buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_BGR);

        Graphics2D g2d = buffer.createGraphics();


        drawSky(g2d);
        //drawDistrictRect(g2d, 40, 4, 400, 200, 500, getHeight() - 150, new Color(52, 56, 56));

        g.drawImage(buffer, 0, 0, null);
        g.dispose();
    }

    public void drawDistrictRect(Graphics2D g2d, int distanceOy, int houseCount, int x, int y, int width, int height, Color color) {

        final double saturation = 1.2;
        final double brightness = 1.25;

        for (int i = 0; i < houseCount; i++) {
            drawPanelHouse(g2d, x, y, width, height, color);
            y += distanceOy;
            x -= 10;

            color = new Color((int) (color.getRed() * brightness), (int) (color.getGreen() * saturation), (int) (color.getBlue() * saturation));
        }
    }

    public void drawPanelHouse(Graphics2D g2d, int x, int y, int width, int height, Color color) {
        g2d.setColor(color);
        g2d.fillRect(x, y, width, height);
    }

    private void drawSky(Graphics2D g2d) {

        GradientDrawer dw = new GradientDrawer();
        g2d.drawImage(dw.gradient(
                new Polygon(
                        new int[]{0, getWidth(), getWidth(), 0},
                        new int[]{0, 0, getHeight(), getHeight()},
                        4
                ),
                new Point(getWidth() / 2, -getHeight() / 2), new Point(getWidth() / 2, (int) (1.2 * getHeight())),
                new float[]{.000005f, .6f, 1f},
                new Color[]{Color.BLACK, new Color(7, 12, 96), new Color(66, 155, 122)}
        ), 0, 0, null);

        /*
        GradientDrawer dw = new GradientDrawer();
        g2d.drawImage(dw.gradient(
                new Polygon(
                        new int[]{0, getWidth(), getWidth(), 0},
                        new int[]{0, 0, getHeight(), getHeight()},
                        4
                ),
                new Point(getWidth() / 2, -100), new Point(getWidth() / 2, (int) (1.2 * getHeight())),
                new float[]{.1f, .3f, .4f, .5f, .7f, 1f},
                new Color[]{Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE}
        ), 0, 0, null);
         */

        drawStars(g2d);
    }

    private void drawStars(Graphics2D g2d) {
        //g2d.setColor(Color.YELLOW);
        final int OFFSET = 50;
        Point star = new Point();
        for (int i = 0; i < 100; i++) {
            star.x = OFFSET + (int) (Math.random() * (getWidth() - 2 * OFFSET));
            star.y = OFFSET + (int) (Math.random() * (getHeight() - 2 * OFFSET));

            g2d.fillOval(star.x, star.y, 3, 2);
        }

        drawEllipse(g2d);
    }

    void drawEllipse(Graphics2D g)
    {
        /*
         * Скругление
         * < 1 - вогнутый суперэллипс
         * > 1 - выпуклый суперэллипс
         * = 2 - круг
         */
        double exp = .3;

        // a ~ радиус опис. ок-ти
        final int a = 10; // a = b
        double[] points = new double[a + 1];
        Point[] coordinates;

        Path2D p = new Path2D.Double();
        p.moveTo(a, 0);

        // calculate first quadrant
        for (int x = a; x >= 0; x--) {
            points[x] = pow(pow(a, exp) - pow(x, exp), 1 / exp); // solve for y
            p.lineTo(x, -points[x]);

        }

        // mirror to others

        for (int x = 0; x <= a; x++)
            p.lineTo(x, points[x]);

        for (int x = a; x >= 0; x--)
            p.lineTo(-x, points[x]);

        for (int x = 0; x <= a; x++)
            p.lineTo(-x, -points[x]);

        g.translate(getWidth() / 2, getHeight() / 2);
        g.setStroke(new BasicStroke(2));

        g.setColor(new Color(0x25B0C4DE, true));
        g.fill(p);

        g.draw(p);
        g.setStroke(new BasicStroke(1));
        g.translate(- getWidth() / 2, - getHeight() / 2);
    }
}
