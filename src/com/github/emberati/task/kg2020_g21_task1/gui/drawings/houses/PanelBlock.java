package com.github.emberati.task.kg2020_g21_task1.gui.drawings.houses;

import com.github.emberati.task.kg2020_g21_task1.gui.drawings.Drawable;
import java.awt.*;

public class PanelBlock implements Drawable {

    private int width;
    private int height;
    private int x;
    private int y;
    private final Color color;

    public PanelBlock(int x, int y, int width, int height) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;

        int windowColor = (int) (Math.random() * 10) < 2 ? 1 : 0;
        if (windowColor == 1) color = new Color(255, 177, 61);
        else color = new Color(15, 15, 50);
    }

    @Override
    public void draw(Graphics2D g2d) {
        int windowWidth = (int) (width * 0.5);
        int windowHeight = (int) (height * 0.5);
        drawWindow(g2d, x + (width - windowWidth) / 2, y + (height - windowHeight) / 2, windowWidth, windowHeight);
    }

    private void drawWindow(Graphics2D g2d, int x, int y, int width, int height) {
        g2d.setColor(color);
        g2d.fillRect(x, y, width, height);
        g2d.setColor(Color.GRAY);
    }

    @Override
    public void update(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
