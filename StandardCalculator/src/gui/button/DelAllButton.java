package gui.button;

import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import token.*;

public class DelAllButton extends Button{

    public DelAllButton(String text) {
        super(text);
    }
        
    public void onClick(ActionEvent e, JLabel Layar,Token token) {
        Layar.setText("");
    }
}