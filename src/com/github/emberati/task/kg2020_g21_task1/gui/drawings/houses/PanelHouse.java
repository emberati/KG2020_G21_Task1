package com.github.emberati.task.kg2020_g21_task1.gui.drawings.houses;

import com.github.emberati.task.kg2020_g21_task1.gui.drawings.Drawable;

import java.awt.*;

public class PanelHouse implements Drawable {

    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    private int panels;


    private PanelBlock[][] blocks;

    public PanelHouse(int x, int y, int width, int height, int panels, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;

        blocks = new PanelBlock[panels][panels];
        this.panels = panels;

        // FILL
        int i = 0;
        int j;
        while (i < panels) {
            j = 0;
            while (j < panels) {
                blocks[i][j] = new PanelBlock(x + j * getRelativePanelWidth(), y + i * getRelativePanelHeight(), getRelativePanelWidth(), getRelativePanelHeight());
                //drawPanelBlock(g2d, x + j * panelWidth, y + i * panelHeight, );
                j++;
            }
            i++;
        }
    }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fillRect(x, y, width, height);

        int i = 0;
        int j;
        while (i < panels) {
            j = 0;
            while (j < panels) {
                blocks[i][j].draw(g2d);
                j++;
            }
            i++;
        }
    }

    @Override
    public void update(int width, int height) {
        this.width = width;
        this.height = height;
    }

    void update(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        update(width, height);
        this.color = color;

        int i = 0;
        int j;
        while (i < panels) {
            j = 0;
            while (j < panels) {
                blocks[i][j].update(x + j * getRelativePanelWidth(), y + i * getRelativePanelHeight(), getRelativePanelWidth(), getRelativePanelHeight());
                //drawPanelBlock(g2d, x + j * panelWidth, y + i * panelHeight, );
                j++;
            }
            i++;
        }
    }

    private int getRelativePanelWidth() {
        return width / panels;
    }

    private int getRelativePanelHeight() {
        return height / panels;
    }
}
