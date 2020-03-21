import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Del1Button extends Button{

    public Del1Button(String text) {
        super(text);
    }
        
    public void onClick(ActionEvent e, JLabel Layar) {
        //TODO
        String s = Layar.getText();
        if(s.length()>0){
            Layar.setText(s.substring(0, s.length() - 1));
        }
    }
}