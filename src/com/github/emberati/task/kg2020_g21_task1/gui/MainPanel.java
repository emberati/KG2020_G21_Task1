package com.github.emberati.task.kg2020_g21_task1.gui;

import com.github.emberati.task.kg2020_g21_task1.GradientDrawer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MainPanel extends JPanel {

    @Override
    public void paint(Graphics g) {
        BufferedImage buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_BGR);

        drawSky(buffer);
        //drawDistrictRect(buffer, 10, 4, 600, 300, 150, getHeight() - 150, new Color(7, 12, 96));
        g.drawImage(buffer, 0, 0, null);
        g.dispose();
    }

    public void drawDistrictRect(BufferedImage buffer, int distanceOy, int houseCount, int x, int y, int width, int height, Color color) {
        int dy = y;

        for (int i = 0; i < houseCount; i++) {
            drawPanelHouse(buffer, x, dy, width, height, color);
            dy += distanceOy;

            /*color = Color.RGBtoHSB(
                    color.getRed(), color.getGreen(), color.getBlue(), new float[]{236, 92, 37}
            );

             */
        }
    }

    public void drawPanelHouse(BufferedImage buffer, int x, int y, int width, int height, Color color) {
        buffer.getGraphics().setColor(color);
        buffer.getGraphics().fillRect(x, y, width, height);
    }

    public void drawSky(BufferedImage buffer) {
        GradientDrawer dw = new GradientDrawer();
        buffer.getGraphics().drawImage(dw.gradient(
                new Polygon(
                        new int[] {0, getWidth(), getWidth(), 0},
                        new int[] {0, 0, getHeight(), getHeight()},
                        4
                ),
                new Point(getWidth() / 2, - getHeight() / 2), new Point(getWidth() / 2,  (int) (1.2 * getHeight())),
                new float[] {.000005f, .6f, 1f},
                new Color[]{Color.BLACK, new Color(7, 12, 96), new Color(66, 155, 122)}
        ), 0, 0, null);
    }
}
