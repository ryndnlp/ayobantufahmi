import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class DelAllButton extends Button{

    public DelAllButton(String text) {
        super(text);
    }
        
    public void onClick(ActionEvent e, JLabel Layar) {
        //TODO
        Layar.setText("");
    }
}