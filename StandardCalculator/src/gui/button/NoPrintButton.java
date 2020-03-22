package gui.button;

import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import token.*;

public class NoPrintButton extends Button{

    public NoPrintButton(String text) {
        super(text);
    }
        
    public void onClick(ActionEvent e, JLabel Layar,Token token) {
        //Do no update to Layar
    }
}