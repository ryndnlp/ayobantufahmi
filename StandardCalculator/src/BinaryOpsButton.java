import java.awt.event.ActionEvent;
import javax.swing.JLabel;

class BinaryOpsButton extends PrintButton {
    
    public BinaryOpsButton(String text) {
        super(text);
    }
        
    public void onClick(ActionEvent e, JLabel Layar) {
        //TODO
        if(Layar.getText().length()<24){
            Layar.setText(Layar.getText() + " " + this.text + " ");
        }
    }
}