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

public class GradientDrawer {

    @Deprecated
    public Image gradient(Polygon polygon, Color[] colors, Point[] points) {
        Rectangle bounds = polygon.getBounds();

        final BufferedImage image = new BufferedImage(bounds.width, bounds.height, BufferedImage.TYPE_INT_RGB);
        final Graphics g = image.createGraphics();


        return image;
    }

    public Image gradient(int width, int height, Color origin, Color shade, Point point0, Point point1) {
        final BufferedImage image = new BufferedImage(
                width, height, BufferedImage.TYPE_INT_RGB);

            Graphics2D g = image.createGraphics();
            GradientPaint primary = new GradientPaint(
                    (float) point0.x, (float) point0.y,
                    origin, (float) point1.x, (float) point1.y,
                    shade
            );

            g.setPaint(primary);
            g.fillRect(0, 0, width, height);
            return image;
    }

}