package com.github.emberati.task.kg2020_g21_task1.gui.drawings.sky;

import com.github.emberati.task.kg2020_g21_task1.GradientDrawer;
import com.github.emberati.task.kg2020_g21_task1.gui.drawings.Drawable;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Sky implements Drawable {
    private int width;
    private int height;

    private final Moon moon;

    public Sky(int width, int height) {
        this.width = width;
        this.height = height;

        moon = new Moon((int) (width * 0.2), (int) (0.1 * height), (int) (0.05 * width), (int) (0.05 * width));
    }

    @Override
    public void draw(Graphics2D g2d) {
        drawRectangleSky(g2d);
        drawGradientSky(g2d);

        moon.draw(g2d);
    }

    @Override
    public void update(int width, int height) {
        this.width = width;
        this.height = height;
        moon.update((int) (width * 0.2), (int) (0.1 * height), (int) (0.05 * width), (int) (0.05 * width));
    }

    private void drawRectangleSky(Graphics2D g2d) {
        g2d.setColor(new Color(4, 6, 52));
        g2d.fillRect(0, 0, width, (int) (0.45 * height));

        g2d.setColor(new Color(15, 15, 65));
        g2d.fillRect(0, (int) (0.45 * height), width, (int) (0.7 * height));

        g2d.setColor(new Color(38, 11, 75));
        g2d.fillRect(0, (int) (0.7 * height), width, (int) (0.85 * height));

        g2d.setColor(new Color(119, 52, 158));
        g2d.fillRect(0, (int) (0.85 * height), width, (int) (0.93 * height));

        g2d.setColor(new Color(170, 75, 109));
        g2d.fillRect(0, (int) (0.93 * height), width, (int) (0.96 * height));

        g2d.setColor(new Color(251, 95, 98));
        g2d.fillRect(0, (int) (0.96 * height), width, (int) (0.99 * height));

        g2d.setColor(new Color(252, 215, 108));
        g2d.fillRect(0, (int) (0.99 * height), width, height);
    }

    private void drawGradientSky(Graphics2D g2d) {
        final GradientDrawer dw = new GradientDrawer();
        final int alpha = 70;
        g2d.drawImage(dw.gradient(
                new Polygon(
                        new int[]{0, width, width, 0},
                        new int[]{0, 0, height, height},
                        4
                ),
                new Point(width / 2, 0), new Point(width / 2, (int) (1.0 * height)),
                new float[]{.45f, 1f},
                new Color[]{
                        new Color(4, 6, 52, alpha), new Color(252, 215, 108, alpha),
                },
                BufferedImage.TYPE_INT_ARGB
        ), 0, 0, null);
    }
}
