package com.github.emberati.task.kg2020_g21_task1;

import java.awt.*;
import java.awt.image.BufferedImage;

/*
    Муфты, переходники
    Входная труба
    Канализационная труба
    длина труб не более трёх метров
    развилки

    Через графы

    Проверить валидность трубопроводной системы
 */

public class ThreeWayGradient {

    public Image gradient(int width, int height, Color origin, Color shade, Point point0, Point point1) {
        final BufferedImage image = new BufferedImage(
                width, height, BufferedImage.TYPE_INT_RGB);

            Graphics2D g = image.createGraphics();
            GradientPaint primary = new GradientPaint(
                    (float) point0.x, (float) point0.y, origin, (float) point1.x, (float) point1.y, shade);

            /*
            GradientPaint shade = new GradientPaint(

                    0f, 0f, new Color(0, 0, 0, 0),
                    0f, 200f, new Color(0, 0, 0, 255));
             */
            g.setPaint(primary);
            g.fillRect(0, 0, width, height);
            //g.setPaint(shade);
            //g.fillRect(0, 0, 200, 200);
            return image;
    }
}