//package data.expression;
package data.expression;

public interface Expression {
    public boolean checkSymbol(String inputString);
    public String getSymbol();
    public double solve();

    @Override
    public String toString();
}
