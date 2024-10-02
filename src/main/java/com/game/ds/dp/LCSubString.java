package com.game.ds.dp;

import java.util.ArrayList;
import java.util.List;

public class LCSubString {
    public static void main(String[] args) {
        String s1 = "abcdghmrs";
        String s2 = "abedfhmrzr";

        int count3 = getLCSubStringCountTopDown(s1,s2,s1.length(),s2.length());
        System.out.println("LCSubstring count top down is "+count3);
    }

    public static int getLCSubStringCountTopDown(String s1, String s2,
                                                 int n, int m) {
        int[][] t = new int[n+1][m+1];
        int max =0;
        List<String> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if((s1.charAt(i-1)+"").equals(s2.charAt(j-1)+"")){
                    t[i][j] = 1+t[i-1][j-1];
                }else{
                    t[i][j] =0;
                }
                if(max<t[i][j]) max+=1;

                System.out.print(t[i][j]+"\t");
            }
            System.out.println();
        }
        return max;
    }
    public static int getLCSubStringCountTopDownWithOutput(String s1, String s2,
                                                 int n, int m, List<String> list) {
        int[][] t = new int[n+1][m+1];
        int max =0;
        int initialIndex = 0;
        for(int i=1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if((s1.charAt(i-1)+"").equals(s2.charAt(j-1)+"")){
                    t[i][j] = 1+t[i-1][j-1];
                }else{
                    t[i][j] =0;
                    initialIndex = i;
                }
                if(max<t[i][j]) {
                    max+=1;
                    list.removeAll(list);
                    list.add(s1.substring(i-max,i));
                }
                System.out.print(t[i][j]+"\t");
            }
            System.out.println();
        }
        return max;
    }
}
