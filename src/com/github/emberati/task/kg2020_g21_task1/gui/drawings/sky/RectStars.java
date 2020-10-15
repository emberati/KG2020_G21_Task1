package com.github.emberati.task.kg2020_g21_task1.gui.drawings.sky;

import com.github.emberati.task.kg2020_g21_task1.gui.drawings.Drawable;

import java.awt.*;

public class RectStars implements Drawable {

    private int width;
    private int height;
    private final double[] x;
    private final double[] y;
    private final int COUNT;
    private final Color color;

    private final Stroke stroke = new BasicStroke(1);

    public RectStars(int width, int height, int count, final int OFFSET) {
        COUNT = count;
        this.width = width;
        this.height = height;
        color = new Color(255, 255, 255, 128);

        x = new double[COUNT];
        y = new double[COUNT];
        double starDist = (width * 0.05);
        for (int i = 0; i < COUNT; i++) {
            x[i] = OFFSET + starDist * ((int) (Math.random() * 20));
            y[i] = OFFSET + starDist * ((int) (Math.random() * 20));
        }
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.setStroke(stroke);
        for (int i = 0; i < COUNT; i++) {
            g2d.fillRect((int) x[i], (int) y[i], 3, 3);
        }
    }

    @Override
    public void update(int x, int y, int width, int height) {
        double dx = (double) width / this.width;
        double dy = (double) height / this.height;

        for (int i = 0; i < COUNT; i++) {
            this.x[i] *= dx;
            this.y[i] *= dy;
        }

        this.width = width;
        this.height = height;
    }
}
