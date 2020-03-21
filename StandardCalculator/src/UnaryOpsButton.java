import java.awt.event.ActionEvent;
import javax.swing.JLabel;

class UnaryOpsButton extends PrintButton{

    public UnaryOpsButton(String text) {
        super(text);
 
    }

        
    public void onClick(ActionEvent e, JLabel Layar, Token token) {
        //TODO
        token.addToToken(e.getActionCommand());
        if(Layar.getText().length()<24){
            Layar.setText(token.convertToString());
            if(this.text != "(" && this.text != ")"){
                Layar.setText(Layar.getText() + "(");
            }
        }
        
    }
}