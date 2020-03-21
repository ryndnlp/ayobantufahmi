import java.awt.event.ActionEvent;
import javax.swing.JLabel;

class SupButton extends UnaryOpsButton{
    private String printed;

    public SupButton(String text, String printed) {
        super(text);
        this.printed = printed;
    }
        
    public void onClick(ActionEvent e, JLabel Layar) {
        //TODO
        if(Layar.getText().length()<24){
            Layar.setText(Layar.getText() + this.printed + "(");
            if(this.printed == "^2"){
                Layar.setText(Layar.getText() + ")");
            }
        }
    }
}