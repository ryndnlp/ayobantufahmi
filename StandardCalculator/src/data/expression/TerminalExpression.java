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
        //System.out.println("    TermExp check 1 string : " + inputString);
        String testString = inputString.replaceFirst("\\.", "");
        //System.out.println("    TermExp check 2 string : " + testString);

        for (String string : symbol) {
            testString = testString.replaceAll(string, "");
            //System.out.println("    TermExp check " + string + " string : " + testString);
        }

        //System.out.println("    TermExp check last string : " + testString);
        

        return testString.trim().equals("");
    }

    public float solve() {
        return this.x;
    }

    @Override
    public String toString() {
        System.out.println("Called terminal to string");
        return String.valueOf(x);
    }
}