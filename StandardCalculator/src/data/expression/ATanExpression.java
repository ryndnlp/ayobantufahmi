class ATanExpression extends UnaryExpression {
    //protected String symbol = "-";


    public ATanExpression(Expression x) {
        symbol = "tan";
        this.x = x;
    }

    public float solve() {
        return (float) Math.atan(x.solve());
    }
}