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
        setPreferredSize(frameDimension);
        setUndecorated(true);
        init();
        setLocationRelativeTo(null);
    }

    private void init() {
        mainPanel = new MainPanel(frameDimension);
        mainPanel.init();
        mainPanel.setVisible(true);
        //getContentPane().setPreferredSize(frameDimension);
        //getContentPane().add(mainPanel);
        add(mainPanel);
        pack();
    }
}
