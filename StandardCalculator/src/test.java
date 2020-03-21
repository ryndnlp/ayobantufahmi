import data.expression.*;

class test {
    public static void main(String[] args) {
        String inString = "-3 * 2 + (5 * (19 + 1)) * (11 % 2) + 1 - 10";
        //inString = "-10";

        Expression outExp = null;
        try {
            // outExp = parse("5+2*3/2-3.9");
            ExpressionParser exParser = new ExpressionParser();
            outExp = exParser.parse(inString);
            System.out.println("outEXP = " + outExp);
            System.out.println(inString + " => " + outExp.solve());

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}