/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.*;
/**
 *
 * @author ASUS
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CalcForm.setUITheme();

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalcForm().setVisible(true);
            }
        });
    }
    
}
