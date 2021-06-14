package com.game.ds.dp;

public class PrintLongestRepeatingSubsequence {
    public static void main(String[] args) {
        String s = "AABCBEDD";
//        printLongestRepeatingSubsequence(s);
        System.out.println(printLongestRepeatingSubsequence(s));
    }

    public static String printLongestRepeatingSubsequence(String s) {
        //Longest Repeating Subsequence code
        int[][] t = new int[s.length()+1][s.length()+1];

        for(int i =1;i<=s.length();i++){
            for(int j=1;j<=s.length();j++){
                if((s.charAt(i-1)+"").equals(s.charAt(j-1)+"") && i!=j){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i][j-1],t[i-1][j]);
                }
            }
        }
        LCS.printMatrix(s,s,t);
        //LRS code end
        int i = s.length(), j = s.length();
        String ret_str = "";
        while(i>0 && j>0){
            if(t[i-1][j] == t[i][j-1] && t[i-1][j-1] == t[i][j]-1  && i!=j){
                ret_str = ret_str + s.charAt(i-1);
                j--;
                i--;
            }else{
                if(t[i-1][j] > t[i][j-1])i--;
                else j--;
            }
        }
        return new StringBuilder(ret_str).reverse().toString();
    }
}
