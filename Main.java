package java_project;

import java.io.*;
import java.text.ParseException;
import java.util.Scanner;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Telecom_panel().setVisible(true);
            }
        });
    }
}
