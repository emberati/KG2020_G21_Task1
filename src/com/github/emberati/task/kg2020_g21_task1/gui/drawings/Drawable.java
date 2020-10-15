package com.github.emberati.task.kg2020_g21_task1.gui.drawings;

import java.awt.*;

public interface Drawable {

    void draw(Graphics2D g2d);

    void update(int x, int y, int width, int height);
}
