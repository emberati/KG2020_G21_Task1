package com.github.emberati.task.kg2020_g21_task1.gui;

import com.github.emberati.task.kg2020_g21_task1.gui.drawings.Picture;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;

import static java.lang.Math.pow;

public class MainPanel extends JPanel {

    private final Picture picture;

    public MainPanel(Dimension dimension) {
        setSize(dimension);
        setPreferredSize(dimension);
        picture = new Picture(getWidth(), getHeight());
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_BGR);
        Graphics2D g2d = buffer.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        picture.update(0, 0, getWidth(), getHeight());
        picture.draw(g2d);

        g.drawImage(buffer, 0, 0, null);
        g.dispose();
    }

    private Polygon superEllipse(int radius, double exp) {
        Polygon superEllipse;
        int points = (4 + radius) * 4;
        int[] x = new int[points];
        int[] y = new int[points];

        int i;
        for (i = 0; i <= radius; i++) {
            x[i] = i;
            y[i] = (int) pow(pow(radius, exp) - pow(i, exp), 1 / exp);
        }
        System.out.println(y[0]);
        //i--;

        int j;
        for (j = radius; j > 0; j--) {
            x[i + j] = x[j];
            y[i + j] = -y[j];
        }
        j = radius + 2;

        int k;
        for (k = 0; k < radius; k++) {
            x[i + j + k] = -x[k];
            y[i + j + k] = -y[k];
        }
        j--;
        j--;
        int l;
        for (l = radius; l > 0; l--) {
            x[i + j + k + l] = -x[l];
            y[i + j + k + l] = y[l];
        }


        superEllipse = new Polygon(x, y, points);
        return superEllipse;
    }

    void drawEllipse(Graphics2D g) {
        /*
         * Скругление
         * < 1 - вогнутый суперэллипс
         * > 1 - выпуклый суперэллипс
         * = 2 - круг
         */
        double exp = .3;

        // a ~ радиус опис. ок-ти
        final int a = 100; // a = b
        double[] points = new double[(a + 1) * 4];
        int[] cx = new int[(a + 1) * 4];
        int[] cy = new int[(a + 1) * 4];

        Path2D p = new Path2D.Double();
        p.moveTo(a, 0);

        // calculate first quadrant
        for (int x = a; x >= 0; x--) {
            points[x] = pow(pow(a, exp) - pow(x, exp), 1 / exp); // solve for y

            cy[x] = (int) pow(pow(a, exp) - pow(x, exp), 1 / exp);
            cx[x] = x;

            p.lineTo(x, -points[x]);
        }

        // mirror to others

        for (int x = 0; x <= a; x++)
            p.lineTo(x, points[x]);

        for (int x = a; x >= 0; x--)
            p.lineTo(-x, points[x]);

        for (int x = 0; x <= a; x++)
            p.lineTo(-x, -points[x]);

        g.translate(getWidth() / 2, getHeight() / 2);
        g.setStroke(new BasicStroke(2));

        g.setColor(new Color(0x25B0C4DE, true));
        g.fill(p);

        g.draw(p);
        g.setStroke(new BasicStroke(1));
        g.translate(- getWidth() / 2, - getHeight() / 2);
    }
}
