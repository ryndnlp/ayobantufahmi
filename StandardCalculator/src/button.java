import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;

abstract class Button extends JButton {

    public Button(String text) {
        super(text);
    }
    abstract public void onClick(ActionEvent evt, JLabel Layar);
}