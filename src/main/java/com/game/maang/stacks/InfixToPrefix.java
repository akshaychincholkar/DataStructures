package com.game.maang.stacks;

import java.util.Stack;

public class InfixToPrefix {
    public static String convert(String s){
        Stack<Character> stack = new Stack<>();
        s = "("+s+")";
        String prefix = "";
        // operators can be + , - , * , (, ) , ' '
        for(char c:s.toCharArray()){
            if(c == ' ')continue;
            if(c == '+' || c == '-' || c == '*'|| c == '/' || c =='(' )stack.push(c);
            else if( c == ')'){
                while(stack.peek() != '('){
                    prefix = stack.pop()+""+prefix;
                }
            }else {
                prefix +=c;
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        System.out.println("Infix to prefix of a + b :"+convert("a+b"));
        System.out.println("Infix to prefix of a + b :"+convert("( a+b )*c"));
        System.out.println("Infix to prefix of (A – B/C) * (A/K-L) :"+convert("(A – (B/C)) * ((A/K)-L)"));
    }
}
