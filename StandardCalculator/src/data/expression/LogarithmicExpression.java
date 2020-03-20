class LogarithmicExpression extends UnaryExpression {
    //protected String symbol = "-";
    //protected Expression x;

    public LogarithmicExpression(Expression x) {
        symbol = "log";
        this.x = x;
    }

    public float solve() {
        return (float) Math.log(x.solve());
    }
}