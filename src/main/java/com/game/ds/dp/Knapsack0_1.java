package com.game.ds.dp;

public class Knapsack0_1 {
    static int[][] t;
    public static void main(String[] args) {
//        int[] wt ={ 10, 20, 30 };
//        int[] val = { 60, 100, 120 };
        int[] wt ={ 1,3,4,7 };
        int[] val = { 1,4,5,7 };

        int W = 7;
        int maxProfit = knapSack(W, wt, val, wt.length);
        System.out.println("Maximum profit: "+maxProfit);

//        knapSackMemoization
        t = new int[wt.length+2][W+2];
        int memoizationProfit = knapSackMemoization(W, wt, val, wt.length);
        System.out.println("Maximum memoizationProfit profit: "+memoizationProfit);


        int topDownProfit = knapSackTopDown(W, wt, val, wt.length);
        System.out.println("Maximum Topdown profit: "+topDownProfit);
    }

    private static int knapSack(int w, int[] wt, int[] val, int n) {
        if(w == 0 || n ==0)return 0;
        if(wt[n-1]<=w){
            return Math.max(val[n-1]+knapSack(w-wt[n-1],wt,val,n-1),knapSack(w,wt,val,n-1));
        }else{
            return knapSack(w,wt,val,n-1);
        }
    }//O(2^n)
    private static int knapSackMemoization(int w, int[] wt, int[] val, int n) {
        if(w == 0 || n ==0)return 0;
        if(t[n][w]!=0){
            return t[w][n];
        }
        if(wt[n-1]<=w){
            return t[n][w]=Math.max(val[n-1]+knapSackMemoization(w-wt[n-1],wt,val,n-1),
                    knapSackMemoization(w,wt,val,n-1));
        }else{
            return t[n][w]=knapSackMemoization(w,wt,val,n-1);
        }
    }//O(n*w)
    private static int knapSackTopDown(int w,int[] wt,int[] val,int n){
        int[][] t = new int[n+1][w+1];

        for(int i=1;i<n+1;i++)
            for(int j = 1;j<w+1;j++){
                //i is n and j is weight j = W
                if(wt[i-1]<=j){
                    t[i][j] = Math.max(val[i-1]+t[i-1][j-wt[i-1]],t[i-1][j]);
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        for(int i =0;i<=wt.length;i++){
            for(int j=0;j<=w;j++){
                System.out.print(t[i][j]+"_"+i+"_"+j+"\t");
            }
            System.out.println();
        }
        return t[n][w];
    }//O(n*w)

/**
 *         int[] wt  = { 1,3,4,7 };
 *         int[] val = { 1,4,5,7 };
 *         W= 7;
 *
 * 0_0_0	0_0_1	0_0_2	0_0_3	0_0_4	0_0_5	0_0_6	0_0_7
 * 0_1_0	1_1_1	1_1_2	1_1_3	1_1_4	1_1_5	1_1_6	1_1_7
 * 0_2_0	1_2_1	1_2_2	4_2_3	5_2_4	5_2_5	5_2_6	5_2_7
 * 0_3_0	1_3_1	1_3_2	4_3_3	5_3_4	6_3_5	6_3_6	9_3_7
 * 0_4_0	1_4_1	1_4_2	4_4_3	5_4_4	6_4_5	6_4_6	9_4_7
 *
 */
}
