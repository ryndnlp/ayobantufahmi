//package data.expression;
package data.expression;

public interface Expression {
    public boolean checkSymbol(String inputString);
    public float solve();

    @Override
    public String toString();
}