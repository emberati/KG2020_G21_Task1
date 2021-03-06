package com.github.emberati.task.kg2020_g21_task1.gui.drawings.sky;

import com.github.emberati.task.kg2020_g21_task1.gui.drawings.Drawable;
import java.awt.*;

public class Moon implements Drawable {

    private int x;
    private int y;
    private int width;
    private int height;

    public Moon(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics2D g2d) {
        int radius = (int) (width * 0.15);
        g2d.setColor(new Color(255, 255, 255, 32));
        g2d.fillOval(x - radius, y - radius, width + 2 * radius, height + 2 * radius);
        g2d.setColor(Color.WHITE);
        g2d.fillOval(x, y,width, height);
    }

    @Override
    public void update(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
