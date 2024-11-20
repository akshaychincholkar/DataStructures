package com.game.maang.stacks;

import java.util.Stack;

public class PostfixEvaluation{
    public static int evaluate(String expression){
        Stack<Integer> stack = new Stack<>();
        for(String s:expression.split(" ")){
            if(isOperator(s)){
                stack.push(operate(stack.pop(),stack.pop(),s));
            }else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
    public static boolean isOperator(String c){
        return c == "+" || c == "-" || c == "*" || c == "/";
    }
    public static int operate(int a,int b,String c){
        switch(c){
            case "+": return b+a;
            case "-": return b-a;
            case "*": return b*a;
            case "/": return b/a;
            default: return 0;
        }
    }
    public static void main(String[] args){
//        System.out.println("postfix evaluation of “2 3 1 * + 9 -“: "+evaluate("2 3 1 * + 9 -"));
        System.out.println("postfix evaluation of “100 200 + 2 / 5 * 7 +“: "+evaluate("100 200 + 2 / 5 * 7 +"));
    }
}

