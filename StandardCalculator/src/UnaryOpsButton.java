import java.awt.event.ActionEvent;
import javax.swing.JLabel;

class UnaryOpsButton extends Button implements PrintButton{
    
    public UnaryOpsButton(String text) {
        super(text);
    }
        
    public void onClick(ActionEvent e, JLabel Layar) {
        //TODO
        Layar.setText(Layar.getText() + this.text);
        if(this.text != "(" && this.text != ")"){
            Layar.setText(Layar.getText() + "(");
        }
        if(this.getText() == "Sin1Button"){

        }
    }
}