import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;

public class ModeButton extends JCheckBox {

    public ModeButton() {
        super();
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