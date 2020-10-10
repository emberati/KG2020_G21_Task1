package com.github.emberati.task.kg2020_g21_task1.gui.drawings.houses;

import com.github.emberati.task.kg2020_g21_task1.gui.drawings.Drawable;

import java.awt.*;

public class HouseMassive implements Drawable {

    private int x;
    private int y;
    private int width;
    private int height;
    private final Color color;
    private final PanelHouse[] houses;

    private final int distanceOx;
    private final int distanceOy;
    private final int houseCount;

    public HouseMassive(int firstHouseX, int firstHouseY, int width, int height, int houseCount, int distanceOx, int distanceOy, int horPanelCount, Color color) {
        this.x = firstHouseX;
        this.y = firstHouseY;
        this.width = width;
        this.height = height;
        this.houseCount = houseCount;
        this.distanceOx = distanceOx;
        this.distanceOy = distanceOy;
        this.color = color;

        houses = new PanelHouse[houseCount];
        for (int i = 0; i < houseCount; i++) {
            houses[i] = new PanelHouse(
                    x + i * distanceOx, y + i * distanceOy,
                    getRelativeHouseWidth(), getRelativeHouseHeight(),
                    horPanelCount, color);
        }
    }

    @Override
    public void draw(Graphics2D g2d) {
        for (int i = 0; i < houseCount; i++) {
            houses[i].draw(g2d);
        }
    }

    @Override
    public void update(int width, int height) {
        this.width = width;
        this.height = height;
        Color color = new Color(this.color.getRGB());

        final double saturation = 1.2;
        final double brightness = 1.25;
        for (int i = 0; i < houseCount; i++) {
            houses[i].update(x + i * distanceOx , y + i * distanceOy, getRelativeHouseWidth(), getRelativeHouseHeight(), color);
            color = new Color((int) (color.getRed() * brightness), (int) (color.getGreen() * saturation), (int) (color.getBlue() * saturation));
        }
    }

    private int getRelativeHouseWidth() {
        return (int) (width * 0.3);
    }

    private int getRelativeHouseHeight() {
        return (int) (height * 0.9);
    }
}
