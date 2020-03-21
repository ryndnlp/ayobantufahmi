import java.awt.event.ActionEvent;
import javax.swing.JLabel;

class BinaryOpsButton extends Button implements PrintButton {
    
    public BinaryOpsButton(String text) {
        super(text);
    }
        
    public void onClick(ActionEvent e, JLabel Layar) {
        //TODO
        Layar.setText(Layar.getText() + " " + this.text + " ");
    }
}