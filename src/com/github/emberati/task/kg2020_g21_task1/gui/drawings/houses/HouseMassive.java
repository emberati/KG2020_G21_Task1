package com.github.emberati.task.kg2020_g21_task1.gui.drawings.houses;

import com.github.emberati.task.kg2020_g21_task1.gui.drawings.Drawable;

import java.awt.*;

public class HouseMassive implements Drawable {

    private final int expansionX;
    private final int expansionY;
    private final int distanceOx;
    private final int distanceOy;
    private final int houseCount;
    private final PanelHouse[] houses;

    public HouseMassive(
            int x, int y,
            int firstHouseWidth, int firstHouseHeight,
            int houseCount, int offsetOx, int offsetOy,
            int horPanelCount, int verPanelCount,
            Color color
    ) {
        this.houseCount = houseCount;
        this.distanceOx = offsetOx;
        this.distanceOy = offsetOy;

        int tempWidth = firstHouseWidth;
        int tempHeight = firstHouseHeight;
        expansionX = 10;
        expansionY = 0;
        final double saturation = 1.2;
        final double brightness = 1.25;
        houses = new PanelHouse[houseCount];
        for (int i = 0; i < houseCount; i++) {
            houses[i] = new PanelHouse(
                    x + i * offsetOx, y + i * offsetOy,
                    tempWidth, tempHeight,
                    horPanelCount, verPanelCount, color);
            color = new Color(
                    (int) (color.getRed() * brightness),
                    (int) (color.getGreen() * saturation),
                    (int) (color.getBlue() * saturation)
            );
            tempWidth += expansionX;
            tempHeight += expansionY;
        }
    }

    @Override
    public void draw(Graphics2D g2d) {
        for (int i = 0; i < houseCount; i++) {
            houses[i].draw(g2d);
        }
    }

    @Override
    public void update(int x, int y, int width, int height) {
        int tempWidth = width;
        int tempHeight = height;
        for (int i = 0; i < houseCount; i++) {
            houses[i].update(x + i * distanceOx , y + i * distanceOy, tempWidth, tempHeight);
            tempWidth += expansionX;
            tempHeight += expansionY;
        }
    }
}
