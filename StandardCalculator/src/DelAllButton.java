

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
        
    public void onClick(ActionEvent e, JLabel Layar,Token token) {
        //TODO
        Token T = new Token();
        String inString;
        inString = token.convertToString();
        Expression outExp = null;
        ExpressionDriver ed = new ExpressionDriver();
        try {
            // outExp = parse("5+2*3/2-3.9");
            outExp = ed.parse(inString);
            if (outExp.solve() - (int)outExp.solve() == 0){
                T.addToToken(Integer.toString((int)outExp.solve()));
            } else{
                T.addToToken(Float.toString(outExp.solve()));
            }
            token.setToken(T);
            Layar.setText(token.convertToString());


        } catch (Exception err) {
            // TODO Auto-generated catch block
            err.printStackTrace();
        }
    }
}