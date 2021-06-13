package com.game.ds.dp;

public class StringConversionInsertionDeletion {
    public static void main(String[] args) {
        String s1="heap";
        String s2 ="pea";
        printInsertionAndDeletion(s1,s2);
    }

    public static void printInsertionAndDeletion(String s1, String s2) {
        String lcs = PrintLCS.getLCSTopDown(s1,s2,s1.length(),s2.length());
        for(int i=0;i<lcs.length();i++){
            s1 = s1.replace(lcs.charAt(i)+"","");
            s2 = s2.replace(lcs.charAt(i)+"","");
        }
        System.out.println("Insertion : "+s1.length()+" deletion: "+s2.length());
    }
}
