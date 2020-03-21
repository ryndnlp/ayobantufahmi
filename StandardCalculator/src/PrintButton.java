import java.awt.event.ActionEvent;
import javax.swing.JLabel;

abstract class PrintButton extends Button{

    public PrintButton(String text) {
        super(text);
    }
    abstract public void onClick(ActionEvent e, JLabel Layar,Token token);
}