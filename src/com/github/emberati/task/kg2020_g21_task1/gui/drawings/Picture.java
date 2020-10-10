package com.github.emberati.task.kg2020_g21_task1.gui.drawings;

import com.github.emberati.task.kg2020_g21_task1.gui.drawings.houses.HouseMassive;
import com.github.emberati.task.kg2020_g21_task1.gui.drawings.sky.Sky;
import com.github.emberati.task.kg2020_g21_task1.gui.drawings.sky.RectStars;

import java.awt.*;

public class Picture implements Drawable {

    private final Sky sky;
    private final HouseMassive houses;
    private final RectStars stars;

    public Picture(int width, int height) {
        sky = new Sky(width, height);
        stars = new RectStars(width, height);
        houses = new HouseMassive(100, 100, width, height, 4, 40, 20, 5, new Color(65, 40, 45));
    }

    @Override
    public void draw(Graphics2D g2d) {
        sky.draw(g2d);
        stars.draw(g2d);
        houses.draw(g2d);
    }

    @Override
    public void update(int width, int height) {
        sky.update(width, height);
        stars.update(width, height);
        houses.update(width, height);
    }
}
