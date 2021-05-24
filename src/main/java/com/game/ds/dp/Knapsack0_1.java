package com.game.ds.dp;

public class Knapsack0_1 {
    public static void main(String[] args) {
        int[] wt ={ 10, 20, 30 };
        int[] val = { 60, 100, 120 };
        int W = 50;
        int maxProfit = knapSack(W, wt, val, wt.length);
        System.out.println("Maximum profit: "+maxProfit);
    }

    private static int knapSack(int w, int[] wt, int[] val, int n) {
        if(w == 0 || n ==0)return 0;
        if(wt[n-1]<=w){
            return Math.max(val[n-1]+knapSack(w-wt[n-1],wt,val,n-1),knapSack(w,wt,val,n-1));
        }else{
            return knapSack(w,wt,val,n-1);
        }
    }
}
