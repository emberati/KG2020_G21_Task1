package com.github.emberati.task.kg2020_g21_task1.gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private Dimension screenDimension;
    private Dimension frameDimension;

    private MainPanel mainPanel;

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
        mainPanel = new MainPanel();
        add(mainPanel);
        mainPanel.setVisible(true);
    }
}
