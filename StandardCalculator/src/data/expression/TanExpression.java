class TanExpression extends UnaryExpression {
    //protected String symbol = "-";


    public TanExpression(Expression x) {
        symbol = "tan";
        this.x = x;
    }

    public float solve() {
        return (float) Math.tan(x.solve());
    }
}