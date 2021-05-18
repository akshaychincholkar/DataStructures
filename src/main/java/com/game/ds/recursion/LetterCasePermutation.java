package com.game.ds.recursion;

public class LetterCasePermutation {
    public static void main(String[] args) {
        String ip = "a1b2";
        getLetterCasePermutation("",ip);
    }

    private static void getLetterCasePermutation(String op, String ip) {
        if(ip.equals("")) {
            System.out.print(op+",");
            return;
        }
        char firstChar = ip.charAt(0);
        ip = ip.substring(1);
        if((firstChar+"").matches("[0-9]+"))getLetterCasePermutation(op+firstChar,ip);
        else {
            getLetterCasePermutation(op+firstChar,ip);
            getLetterCasePermutation( op+(firstChar+"").toUpperCase(),ip);
        }
    }
}
