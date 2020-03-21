import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Del1Button extends Button{
    public String text;

    public Del1Button(String text) {
        super(text);
    }
        
    public void onClick(ActionEvent e, JLabel Layar) {
        //TODO
        String s = Layar.getText();
        System.out.println(s.length());
        Layar.setText(s.substring(0, s.length() - 1));
    }
}