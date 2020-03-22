package test;

import java.util.Scanner;
import jdk.nashorn.internal.parser.Token;
import src.*;

class TokenTest{
    public static void main(final String args[]) {
        Token token = new Token();
        Scanner in = new Scanner(System.in);
        String choose;
        do {
            System.out.println("Masukkan perintah:[add|del|set|delAll]");
            choose = in.nextLine()    
        } while (!choose.equals("9"));
        if (choose.equals("add")){
            System.out.println("Masukkan string ke token");
            String text = in.nextLine();
            token.addToToken(text);
            System.out.println("Token saat ini" + token.convertToString());
        } else if(choose.equals("del")){
            token.deleteFromBack();
            System.out.println("Token berhasil dihapus");
            System.out.println("Token saat ini" + token.convertToString());
        } else
        

        String text = in.nextLine();
    }
}