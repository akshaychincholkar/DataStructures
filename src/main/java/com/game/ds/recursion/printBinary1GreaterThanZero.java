package com.game.ds.recursion;

public class printBinary1GreaterThanZero {
    public static void main(String[] args){
        int ones = 0;
        int zeros = 0;
        int n = 3;
        String op = "";
        printBinary1GreaterThanZero(ones,zeros,n,op);
    }
    public static void printBinary1GreaterThanZero(int ones,int zeros,int n,String op){
        if(n == 0 ){
            System.out.println(op);
            return;
        }
        String op1 = op+"1";
        printBinary1GreaterThanZero(ones+1,zeros,n-1,op1);

        if(ones>zeros){
            String op2 = op + "0";
            printBinary1GreaterThanZero(ones,zeros+1,n-1,op2);
        }
    }
}
