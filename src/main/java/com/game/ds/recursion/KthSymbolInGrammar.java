package com.game.ds.recursion;

public class KthSymbolInGrammar {
    public static void main(String[] args) {
        int symbol =getKthSymbolInGrammar(4,5);
        System.out.println("Kth symbol is :"+symbol);
    }

    private static int getKthSymbolInGrammar(int n, int k) {
        if(n==1 && k==1)return 0;
        int middle = (int) Math.ceil(Math.pow(2,n-1)/2);
        if(k<=middle) {
         return    getKthSymbolInGrammar(n-1,k);
        }     else{
            return (Math.abs(~getKthSymbolInGrammar(n-1,k-middle)));
        }
    }
}
