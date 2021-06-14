package com.game.ds.dp;

public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        String s = "AABCBEDD";
        int count = getLongestRepeatingSubsequence(s);
        System.out.println("Count : "+count);
    }

    private static int getLongestRepeatingSubsequence(String s) {
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
        for(int j=0;j<=s.length();j++){
            System.out.print("\t"+j);
        }
        System.out.println();
        for(int i =0;i<=s.length();i++){
            for(int j=0;j<=s.length();j++){
//                if(i==0) System.out.println(j+"\t");
                if(j==0) System.out.print(i+"\t");
                System.out.print(t[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println();
        return t[s.length()][s.length()];
    }
}
