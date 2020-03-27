package gui.button;

import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import token.*;

public class Del1Button extends Button{

    public Del1Button(String text) {
        super(text);
    }
        
    public void onClick(ActionEvent e, JLabel Layar, Token token) {
        String s = Layar.getText();
        token.deleteFromBack();
        if(s.length()>0){
            Layar.setText(token.convertToString());
        }
    }
}
