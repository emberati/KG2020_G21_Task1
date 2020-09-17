package com.github.emberati.task.kg2020_g21_task1.gui;

import com.github.emberati.task.kg2020_g21_task1.GradientDrawer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MainPanel extends JPanel {

    @Override
    public void paint(Graphics g) {
        BufferedImage buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_BGR);

        Graphics2D g2d = buffer.createGraphics();


        drawSky(g2d);
        drawDistrictRect(g2d, 30, 4, 600, 300, 150, getHeight() - 150, new Color(48, 20, 20));

        g.drawImage(buffer, 0, 0, null);
        g.dispose();
    }

    public void drawDistrictRect(Graphics2D g2d, int distanceOy, int houseCount, int x, int y, int width, int height, Color color) {
        int dy = y;
        final double saturation = 1.2;
        final double brightness = 1.3;

        for (int i = 0; i < houseCount; i++) {
            drawPanelHouse(g2d, x, dy, width, height, color);
            dy += distanceOy;

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

        drawStars(g2d, 100);
    }

    private void drawStars(Graphics2D g2d, int count) {
        //g2d.setColor(Color.YELLOW);
        final int OFFSET = 20;
        Point star = new Point();
        for (int i = 0; i < count; i++) {
            star.x = (int) (OFFSET + Math.random() * getWidth() - OFFSET);
            star.y = (int) (OFFSET + Math.random() * getHeight() - OFFSET);
            g2d.fillOval(star.x, star.y, 3, 2);
        }
    }
}
