import java.awt.event.ActionEvent;
import javax.swing.JLabel;

class UnaryOpsButton extends PrintButton{

    public UnaryOpsButton(String text) {
        super(text);
 
    }

        
    public void onClick(ActionEvent e, JLabel Layar) {
        //TODO
        if(Layar.getText().length()<24){
            Layar.setText(Layar.getText() + this.text);
            if(this.text != "(" && this.text != ")"){
                Layar.setText(Layar.getText() + "(");
            }
        }
        
    }
}