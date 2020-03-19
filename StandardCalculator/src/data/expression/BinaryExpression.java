abstract class BinaryExpression extends NonTerminalExpression {
    protected Expression x;
    protected Expression y;

    //abstract public Boolean checkSymbol();
    abstract public float solve();
}