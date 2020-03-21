import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class NumButton extends PrintButton {

    public NumButton(String text) {
        super(text);
    }
        
    public void onClick(ActionEvent e, JLabel Layar,Token token) {
        //TODO
        token.addToToken(e.getActionCommand());
        if(Layar.getText().length()<24){
            Layar.setText(token.convertToString());
        }
    }
}