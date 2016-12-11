package java_project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Frame_ extends JFrame {
    public Frame_() {
        JFrame frame = new JFrame();
        frame.setTitle("TELECOM");
        JFrame.setDefaultLookAndFeelDecorated(true);
        Telecom_panel panel = new Telecom_panel();
        panel.setLayout(new GridLayout(6, 1));
        add(panel);
    }
}
