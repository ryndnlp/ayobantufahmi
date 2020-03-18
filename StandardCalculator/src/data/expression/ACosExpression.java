class ACosExpression extends UnaryExpression {
    //protected String symbol = "-";

    public ACosExpression(Expression x) {
        symbol = "acos";
        this.x = x;
    }

    public float solve() {
        return (float) Math.acos(x.solve());
    }
}