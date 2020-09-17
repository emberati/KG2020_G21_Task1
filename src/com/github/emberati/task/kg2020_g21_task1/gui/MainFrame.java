package com.github.emberati.task.kg2020_g21_task1.gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private Dimension screenDimension;
    private Dimension frameDimension;

    private Drawings0 drawings0;

    {
        screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        frameDimension = new Dimension(800, 600);
    }

    public MainFrame() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(frameDimension);
        setLocation(
                (int) (screenDimension.getWidth() - getWidth()) / 2,
                (int) (screenDimension.getHeight() - getHeight()) / 2);
        init();
    }

    private void init() {
        drawings0 = new Drawings0();
        add(drawings0);
        drawings0.setVisible(true);
    }
}
