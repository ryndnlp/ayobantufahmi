class TerminalExpression implements Expression {
    protected String[] symbol = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
    protected float x;

    public TerminalExpression(float x) {
        this.x = x;
    }

    public TerminalExpression(String s) {
        this.x = Float.parseFloat(s);
    }

    public boolean checkSymbol(String inputString) {
        inputString.replaceFirst(".", "");

        for (String string : symbol) {
            inputString.replaceAll(string, "");
        }

        return inputString.equals("") ? true : false;
    }

    public float solve() {
        return this.x;
    }
}