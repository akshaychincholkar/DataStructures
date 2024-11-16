package com.game.maang.stacks;

import java.util.Stack;

public class InfixToPostfix {
    public static boolean isOperator(char c){
        return c == '+' || c == '-' || c == '*' || c == '/' || c =='^';
    }
    public static int precedence(char c){
        switch (c){
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
            case '^': return 3;
            default: return -1;
        }
    }
    public static String convert(String s){
        s = "("+s+")";
        s = s.replaceAll(" ","");
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c == '('){
                stack.push(c);
            }else if(c == ')'){
                while(!stack.isEmpty() && stack.peek()!='(') postfix.append(stack.pop());
                if(!stack.isEmpty())stack.pop();
            }else if(!isOperator(c)){
                postfix.append(c);
            }else{
                while(!stack.isEmpty() && precedence(stack.peek()) > precedence(c)){
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }
        return postfix.toString();
    }

    public static void main(String[] args) {
        System.out.println("Infix to postfix conversion of (a+b*c):"+convert("(a+b*c)"));
        System.out.println("Infix to postfix conversion of (a+b)*c:"+convert("(a+b)*c"));
    }
}
