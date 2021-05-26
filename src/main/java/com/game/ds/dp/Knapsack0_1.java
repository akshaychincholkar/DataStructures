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
    }
    private static int knapSackMemoization(int w, int[] wt, int[] val, int n) {
        if(w == 0 || n ==0)return 0;
        if(t[n][w]!=0){
            return t[w][n];
        }
        if(wt[n-1]<=w){
            return t[n][w]=Math.max(val[n-1]+knapSackMemoization(w-wt[n-1],wt,val,n-1),knapSack(w,wt,val,n-1));
        }else{
            return t[n][w]=knapSackMemoization(w,wt,val,n-1);
        }
    }
    private static int knapSackTopDown(int w,int[] wt,int[] val,int n){
        int[][] t = new int[n+1][w+1];

        for(int i=1;i<n+1;i++)
            for(int j = 1;j<w+1;j++){
                //i is n and j is weight
                if(wt[i-1]<=j){
                    t[i][j] = Math.max(val[i-1]+t[i-1][j-wt[i-1]],t[i-1][j]);
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        return t[n][w];
    }
}
