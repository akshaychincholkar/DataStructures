package com.game.maang.stacks;

import java.util.Stack;

public class InfixToPrefix {
    public static String reverseExpression(String s){
        StringBuilder reversed = new StringBuilder();
        for(int i =s.length()-1 ; i >=0;i--){
            if(s.charAt(i) == '(') {
                reversed.append(')');
                continue;
            }
            else if( s.charAt(i) == ')') {
                reversed.append('(');
                continue;
            }
            reversed.append(s.charAt(i));
        }
        return reversed.toString();
    }
    public static String convert(String s){
        String reversedExpression = reverseExpression(s);
        String postfix = InfixToPostfix.convert(reversedExpression);
        return new StringBuilder(postfix).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("Infix to prefix of a + b :"+convert("a+b"));
        System.out.println("Infix to prefix of ( a+b )*c :"+convert("( a+b )*c"));
        System.out.println("Infix to prefix of a+b*c :"+convert(" a+b*c"));
        System.out.println("Infix to prefix of (A – B/C) * (A/K-L) :"+convert("(A – (B/C)) * ((A/K)-L)"));
        System.out.println("Infix to prefix of (A-B/C)*(A/K-L) :"+convert("(A-B/C)*(A/K-L)"));
    }
}
