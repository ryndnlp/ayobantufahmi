package data.expression;

public abstract class NonTerminalExpression implements Expression {
    //static private String symbol;
    protected String symbol;
    
    //abstract public boolean checkSymbol(String inputString);
    public boolean checkSymbol(String inputString) {
        inputString.replaceAll(" ", "");
        return inputString.equals(symbol) ? true : false;
    }
    public String getSymbol() {
        return symbol;
    }
    abstract public double solve();
}
