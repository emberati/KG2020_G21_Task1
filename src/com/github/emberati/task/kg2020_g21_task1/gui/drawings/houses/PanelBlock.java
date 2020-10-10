package com.github.emberati.task.kg2020_g21_task1.gui.drawings.houses;

import com.github.emberati.task.kg2020_g21_task1.gui.drawings.Drawable;
import java.awt.*;

public class PanelBlock implements Drawable {

    private int width;
    private int height;
    private int x;
    private int y;

    public PanelBlock(int x, int y, int width, int height) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setStroke(new BasicStroke(3));
        g2d.setColor(Color.BLACK);
        //g2d.drawRect(x, y, width, height);

        int windowWidth = (int) (width * 0.5);
        int windowHeight = (int) (height * 0.5);
        drawWindow(g2d, x + (width - windowWidth) / 2, y + (height - windowHeight) / 2, windowWidth, windowHeight);
    }

    private void drawWindow(Graphics2D g2d, int x, int y, int width, int height) {
        Color windowLight;
        int case_ = (int) Math.round(Math.random());
        if (case_ == 0) windowLight = new Color(255, 177, 61);
        else windowLight = new Color(15, 15, 50);

        g2d.setColor(windowLight);
        g2d.fillRect(x, y, width, height);
        g2d.setColor(Color.GRAY);
        //g2d.drawRect(x, y, width, height);
    }

    @Override
    public void update(int width, int height) {
        this.width = width;
        this.height = height;
    }

    void update(int x, int y, int width, int height) {
        update(width, height);
        this.x = x;
        this.y = y;
    }
}
