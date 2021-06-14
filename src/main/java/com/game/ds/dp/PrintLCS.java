package com.game.ds.dp;

import java.util.Collections;

import static com.game.ds.dp.LCS.getLCSCountTopDown;

public class PrintLCS {
    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "aedfhr";
        System.out.println(getLCSTopDown(s1,s2,s1.length(),s2.length()));
    }

    public static String getLCSTopDown(String s1, String s2, int n, int m) {
        int[][] t = new int[n+1][m+1];
        String ret_str = "";
        for(int i=1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if((s1.charAt(i-1)+"").equals(s2.charAt(j-1)+"")){
                    t[i][j] = 1+t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i][j-1],t[i-1][j]);
                }
            }
        }
        for(int i =0;i<=n;i++){

            for(int j=0;j<=m;j++){
//                if(i==0) System.out.println(j+"\t");
                if(j==0) System.out.print(i+"\t");
                System.out.print(t[i][j]+"\t");
            }
            System.out.println();
        }
        int i=n,j=m;
        int element = t[n][m];
        while(i>0 && j>0){
            if(t[i-1][j]==t[i][j-1] && element > t[i-1][j-1]){
                ret_str = ret_str + s1.charAt(i-1);
                element = t[i-1][j];
                i--;
                j--;
            }else {
                if(t[i-1][j]>t[i][j-1])i--;
                else j--;
            }
        }
        return new StringBuilder(ret_str).reverse().toString();
    }
    /**
     *         String s1 = "abcdgh";
     *         String s2 = "aedfhr";
     * 0	0	0	0	0	0	0	0
     * 1	0	1	1	1	1	1	1
     * 2	0	1	1	1	1	1	1
     * 3	0	1	1	1	1	1	1
     * 4	0	1	1	2	2	2	2
     * 5	0	1	1	2	2	2	2
     * 6	0	1	1	2	2	3	3
     */
}
