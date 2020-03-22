import java.awt.event.ActionEvent;
import javax.swing.JLabel;

class PrintButton extends Button{

    public PrintButton(String text) {
        super(text);
    }
    public void onClick(ActionEvent e, JLabel Layar,Token token){
        token.addToToken(e.getActionCommand());
        if(Layar.getText().length()<24){
            Layar.setText(token.convertToString());
        }
    }
}