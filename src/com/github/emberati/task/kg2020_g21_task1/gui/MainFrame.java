package com.github.emberati.task.kg2020_g21_task1.gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private final Dimension frameDimension;

    {
        frameDimension = new Dimension(800, 600);
    }

    public MainFrame() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(frameDimension);
        setUndecorated(true);
        init();
        setLocationRelativeTo(null);
    }

    private void init() {
        MainPanel mainPanel = new MainPanel(frameDimension);
        mainPanel.setVisible(true);
        add(mainPanel);
        pack();
    }
}
