package gui.button;

import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import token.*;

public class SupButton extends UnaryOpsButton{

    public SupButton(String text) {
        super(text);
    }
        
    public void onClick(ActionEvent e, JLabel Layar, Token token) {
        //TODO
        
        token.addToToken(e.getActionCommand());
        if(Layar.getText().length()<24){
            if(!e.getActionCommand().equals("<html>x<sup>2</sup></html>")){
                token.addToToken("(");
            }
            Layar.setText(token.convertToString());
        }
    }
}