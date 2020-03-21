

import data.expression.*;
import data.expression.binaryExpressions.*;
import data.expression.unaryExpressions.*;

import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import data.expression.Expression;

public class DelAllButton extends Button{

    public DelAllButton(String text) {
        super(text);
    }
        
    public void onClick(ActionEvent e, JLabel Layar) {
        //TODO
        String inString;
        inString = Layar.getText();
        Expression outExp = null;
        ExpressionDriver ed = new ExpressionDriver();
        try {
            // outExp = parse("5+2*3/2-3.9");
            outExp = ed.parse(inString);
            Layar.setText(Float.toString(outExp.solve()));

        } catch (Exception err) {
            // TODO Auto-generated catch block
            err.printStackTrace();
        }
    }
}