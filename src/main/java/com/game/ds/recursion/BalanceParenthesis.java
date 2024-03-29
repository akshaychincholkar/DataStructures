package com.game.ds.recursion;

import java.util.ArrayList;
import java.util.List;

public class BalanceParenthesis {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int n = 3;
        String op = "";
        getParenthesisPermutations(n,n,op,list);
        System.out.println(list);
    }

    private static void getParenthesisPermutations(int open, int close, String op, List<String> list) {
        if(open == 0 && close ==0){
            list.add(op);
            return;
        }
         if(open!=0){
            String op1 = op+"(";
            getParenthesisPermutations(open-1,close,op1,list);
        }
        if(close>open){
            String op2 = op +")";
            getParenthesisPermutations(open,close-1,op2,list);
        }
    }
}
