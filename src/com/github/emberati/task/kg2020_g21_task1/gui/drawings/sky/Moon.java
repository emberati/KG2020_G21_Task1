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
        g2d.setColor(Color.WHITE);
        g2d.fillOval(x, y,width, height);
    }

    @Override
    public void update(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void update(int x, int y, int width, int height) {
        update(width, height);
        this.x = x;
        this.y = y;
    }
}
