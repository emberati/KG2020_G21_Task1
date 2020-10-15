package com.github.emberati.task.kg2020_g21_task1.gui.drawings.houses;

import com.github.emberati.task.kg2020_g21_task1.gui.drawings.Drawable;

import java.awt.*;

public class PanelHouse implements Drawable {

    private int x;
    private int y;
    private int width;
    private int height;
    private final Color color;
    private final int horPanelCount;
    private final int verPanelCount;

    private final PanelBlock[][] blocks;

    public PanelHouse(int x, int y, int width, int height, int horPanelCount, int verPanelCount, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.horPanelCount = horPanelCount;
        this.verPanelCount = verPanelCount;

        final int panelWidth = width / this.horPanelCount;
        final int panelHeight = height / this.verPanelCount;
        int offsetTop = (int) (panelHeight * 0.5);
        y += offsetTop;

        blocks = new PanelBlock[verPanelCount][horPanelCount];

        // FILL
        int i = 0;
        int j;
        while (i < verPanelCount) {
            j = 0;
            while (j < horPanelCount) {
                blocks[i][j] = new PanelBlock(
                        x + j * panelWidth,y + i * panelHeight,
                        panelWidth, panelHeight
                );
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
        while (i < verPanelCount) {
            j = 0;
            while (j < horPanelCount) {
                blocks[i][j].draw(g2d);
                j++;
            }
            i++;
        }
    }

    @Override
    public void update(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        final int panelWidth = width / horPanelCount;
        final int panelHeight = height / verPanelCount;
        int offsetTop = (int) (panelHeight * 0.5);
        y += offsetTop;

        int i = 0;
        int j;
        while (i < verPanelCount) {
            j = 0;
            while (j < horPanelCount) {
                blocks[i][j].update(
                        x + j * panelWidth,
                        y + i * panelHeight,
                        panelWidth,
                        panelHeight
                );
                j++;
            }
            i++;
        }
    }
}
