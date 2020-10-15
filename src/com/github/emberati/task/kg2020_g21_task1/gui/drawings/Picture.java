package com.github.emberati.task.kg2020_g21_task1.gui.drawings;

import com.github.emberati.task.kg2020_g21_task1.gui.drawings.houses.HouseMassive;
import com.github.emberati.task.kg2020_g21_task1.gui.drawings.sky.Sky;
import com.github.emberati.task.kg2020_g21_task1.gui.drawings.sky.RectStars;

import java.awt.*;

public class Picture implements Drawable {

    private final Sky sky;
    private final HouseMassive houses0;
    private final HouseMassive houses1;
    private final RectStars stars;

    public Picture(int width, int height) {
        final int houses0X = (int) (width * 0.05);
        final int houses0Y = (int) (height * 0.4);
        final int houses0Width = (int) (width * 0.2);
        final int houses0Height = (int) (height * 0.9);

        final int houses1X = (int) (width * 0.4);
        final int houses1Y = (int) (height * 0.5);
        final int houses1Width = (int) (width * 0.3);
        final int houses1Height = (int) (height * 0.7);

        sky = new Sky(width, height);
        houses0 = new HouseMassive(
                houses0X, houses0Y, houses0Width, houses0Height,
                4, 40, 20,
                5, 10, new Color(65, 40, 45)
        );
        houses1 = new HouseMassive(
                houses1X, houses1Y, houses1Width, houses1Height,
                6, 20, 10,
                8, 12, new Color(65, 40, 45)
        );
        stars = new RectStars(width, height, 300, 20);
    }

    @Override
    public void draw(Graphics2D g2d) {
        sky.draw(g2d);
        stars.draw(g2d);
        houses0.draw(g2d);
        houses1.draw(g2d);
    }

    @Override
    public void update(int x, int y, int width, int height) {
        final int houses0X = (int) (width * 0.05);
        final int houses0Y = (int) (height * 0.4);
        final int houses0Width = (int) (width * 0.2);
        final int houses0Height = (int) (height * 0.9);

        final int houses1X = (int) (width * 0.4);
        final int houses1Y = (int) (height * 0.5);
        final int houses1Width = (int) (width * 0.3);
        final int houses1Height = (int) (height * 0.7);

        sky.update(x, y, width, height);
        stars.update(x, y, width, height);
        houses0.update(houses0X, houses0Y, houses0Width, houses0Height);
        houses1.update(houses1X, houses1Y, houses1Width, houses1Height);
    }
}
