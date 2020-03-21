import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;

abstract class Button extends JButton {
    protected String text;
    public Button(String text) {
        super(text);
        this.text = text;
    }
    abstract public void onClick(ActionEvent evt, JLabel Layar, Token token);
}