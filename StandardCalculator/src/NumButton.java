import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class NumButton extends PrintButton {

    public NumButton(String text) {
        super(text);
    }
        
    public void onClick(ActionEvent e, JLabel Layar) {
        //TODO
        
        Layar.setText(Layar.getText() + e.getActionCommand());
    }
}