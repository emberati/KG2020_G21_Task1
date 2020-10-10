package com.github.emberati.task.kg2020_g21_task1.gui.drawings.sky;

import com.github.emberati.task.kg2020_g21_task1.gui.drawings.Drawable;

import java.awt.*;

public class RectStars implements Drawable {

    private int width;
    private int height;

    public RectStars(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics2D g2d) {
        final int OFFSET = 50;
        Point star = new Point();
        g2d.setColor(Color.WHITE);
        for (int i = 0; i < 100; i++) {
            star.x = OFFSET + (int) (Math.random() * (width - 2 * OFFSET));
            star.y = OFFSET + (int) (Math.random() * (height - 2 * OFFSET));

            g2d.fillOval(star.x, star.y, 3, 2);
        }
    }

    @Override
    public void update(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
