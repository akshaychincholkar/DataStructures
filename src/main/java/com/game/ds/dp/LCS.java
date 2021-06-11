package com.game.ds.dp;

public class LCS {
    static int[][] t;
    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "aedfhr";
        int count = getLCSCountRecursive(s1,s2,s1.length(),s2.length());
        System.out.println("LCS count recursive is "+count);

        int count2 = getLCSCountMemoization(s1,s2,s1.length(),s2.length());
        System.out.println("LCS count memoization is "+count2);

        int count3 = getLCSCountTopDown(s1,s2,s1.length(),s2.length());
        System.out.println("LCS count top down is "+count3);
    }

    public static int getLCSCountRecursive(String s1, String s2, int n, int m) {
        if(n==0 || m==0){
            return 0;
        }
        if((s1.charAt(n-1)+"").equals(s2.charAt(m-1)+"")){
            return 1+ getLCSCountRecursive(s1,s2,n-1,m-1);
        }
        else{
            return Math.max(getLCSCountRecursive(s1,s2,n,m-1), getLCSCountRecursive(s1,s2,n-1,m));
        }
    }

    public static int getLCSCountMemoization(String s1, String s2, int n, int m) {
        int[][] t = new int[n+1][m+1];
        if(t[n][m]!=0){
            return t[n][m];
        }
        if(n==0 || m==0){
            return 0;
        }
        if((s1.charAt(n-1)+"").equals(s2.charAt(m-1)+"")){
            return t[n][m] = 1+ getLCSCountRecursive(s1,s2,n-1,m-1);
        }
        else{
            return t[n][m] = Math.max(getLCSCountRecursive(s1,s2,n,m-1), getLCSCountRecursive(s1,s2,n-1,m));
        }

    }
    public static int getLCSCountTopDown(String s1, String s2, int n, int m) {
        int[][] t = new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if((s1.charAt(i-1)+"").equals(s2.charAt(j-1)+"")){
                    t[i][j] = 1+t[i-1][j-1];
                }else{
                   t[i][j] = Math.max(t[i][j-1],t[i-1][j]);
                }
            }
        }
       /* for(int i =0;i<=n;i++){
            for(int j=0;j<=m;j++){
                System.out.print(t[i][j]+"_"+i+"_"+j+"\t");
            }
            System.out.println();
        }*/
        return t[n][m];
    }
}
/**
 *         String s1 = "abcdgh";
 *         String s2 = "aedfhr";
 * 0_0_0	0_0_1	0_0_2	0_0_3	0_0_4	0_0_5	0_0_6
 * 0_1_0	1_1_1	1_1_2	1_1_3	1_1_4	1_1_5	1_1_6
 * 0_2_0	1_2_1	1_2_2	1_2_3	1_2_4	1_2_5	1_2_6
 * 0_3_0	1_3_1	1_3_2	1_3_3	1_3_4	1_3_5	1_3_6
 * 0_4_0	1_4_1	1_4_2	2_4_3	2_4_4	2_4_5	2_4_6
 * 0_5_0	1_5_1	1_5_2	2_5_3	2_5_4	2_5_5	2_5_6
 * 0_6_0	1_6_1	1_6_2	2_6_3	2_6_4	3_6_5	3_6_6
 */