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

    /**
     * Рисует многоуровневый градиент цветав colors[] c акцентом цветов в points[]
     * @param polygon       Какую фигуру рисовать градиентом
     * @param point0        Точка, от которой начинается рисование градиента
     * @param point1        Точка, в которой заканчивается рисование градиента
     * @param fractions     Точки градиента (промежуточный градиент от какой точки к какой)
     * @param colors        Массив цветов градиента
     * @throws NullPointerException     Если один из агрументов равен null
     */
    public Image gradient(Polygon polygon, Point point0, Point point1, float[] fractions, Color[] colors) {

        if (polygon == null || colors == null || fractions == null) {
            throw new NullPointerException("Gradient must have a polygon, colors and color accent points!");
        }

        Rectangle bounds = polygon.getBounds();
        final BufferedImage image = new BufferedImage(bounds.width, bounds.height, BufferedImage.TYPE_INT_RGB);
        final Graphics2D g = image.createGraphics();
        MultipleGradientPaint mp = new LinearGradientPaint(point0, point1, fractions, colors, MultipleGradientPaint.CycleMethod.NO_CYCLE);

        g.setPaint(mp);
        g.fillPolygon(polygon);
        g.dispose();
        return image;
    }

    @Deprecated
    public Image gradient(Shape shape, Point center, float radius, float[] fractions, Color[] colors) {
        if (shape == null || center == null || fractions == null) {
            throw new NullPointerException("Gradient must have a shape, colors and color accent points!");
        }
        if (radius < 0) throw new IllegalArgumentException("Radius must be bigger than 0");

        Rectangle bounds = shape.getBounds();
        final BufferedImage image = new BufferedImage(bounds.width, bounds.height, BufferedImage.TYPE_INT_RGB);
        final Graphics2D g = image.createGraphics();
        MultipleGradientPaint mp = new RadialGradientPaint(center, radius, fractions, colors);

        return image;
    }
}