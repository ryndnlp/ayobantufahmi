package data.expression;

public class TerminalExpression implements Expression {
    protected String[] symbol = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
    protected float x;

    public TerminalExpression(float x) {
        this.x = x;
    }

    public TerminalExpression(String s) {
        this.x = Float.parseFloat(s);
    }

    public boolean checkSymbol(String inputString) {
        String testString = inputString.replaceFirst("\\.", "");

        for (String string : symbol) {
            testString = testString.replaceAll(string, "");
        }
        
        return testString.trim().equals("");
    }

    public float solve() {
        return this.x;
    }

    @Override
    public String toString() {
        return String.valueOf(x);
    }
}