package com.game.ds;

import java.util.*;

public class Test {

    public static void main(String[] args){
        String s1 = "abcdgh";
        String s2 = "aedfhr";
        printLCS(s1,s2,s1.length(),s2.length());
    }
    public static void printLCS(String s1, String s2, int n, int m) {
        int[][] t = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                if ((s1.charAt(i - 1) + "").equals(s2.charAt(j - 1) + "")) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
                }
            }

        System.out.println("LCS:" + t[n][m]);
        System.out.println("Printing: ");
        StringBuffer sb = new StringBuffer();
        int i = n, j = m;

        while (j > 0 && i > 0) {
            if((s1.charAt(i-1)+"").equals(s2.charAt(j-1)+"")){
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (t[i - 1][j] == t[i][j]) i--;
                else {
                    j--;
                }
            }
        }
        System.out.println(sb.reverse());
    }
}
