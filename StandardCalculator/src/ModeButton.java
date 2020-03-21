import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;

public class ModeButton extends JCheckBox {
    String label;

    public ModeButton(String label) {
        super(label);  // Explicitly Invoking the parent parameterized constructor 
        this.label = label;
    }
    public ModeButton() {
        super();  // Explicitly Invoking the parent parameterized constructor     
    }
    public void onClick(Button B[], JLabel Layar, JPanel MainPanel) {
        if(!this.isSelected()){
            for(int i=0; i<B.length;i++){
                B[i].setVisible(false);
            }
            Layar.setSize(285, Layar.getHeight());
            MainPanel.setSize(290, MainPanel.getHeight());
        }else{
            for(int i=0; i<B.length;i++){
                B[i].setVisible(true);
            }
            Layar.setSize(getPreferredSize());  
        }
        
    }
}