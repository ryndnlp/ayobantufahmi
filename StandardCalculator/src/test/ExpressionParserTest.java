package test;

import data.expression.*;

class ExpressionParserTest {
    public static void main(String[] args) {
        String[] inString = {"-3 * 2 + (5 * (19 + 1)) * (11 % 2) + 1 - 10",
                            "",
                            "3 ** 2",
                            "3 +- 2",
                            "3 +",
                            "5 + sqrt(5)",
                            "sin()",
                            "cos() + 5",
                            "((((((((((5))))))))))",
                            "3 * (23 + 5",
                            "+ 5",
                            " + "};

        for (int i = 0; i < inString.length; i++) {
            Expression<Double> outExp = null;
            try {
                ExpressionParser exParser = new ExpressionParser();
                outExp = exParser.parse(inString[i]);
                System.out.println("");
                System.out.println("outEXP = " + outExp);
                System.out.println(inString[i] + " => " + outExp.solve());
                System.out.println("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
}