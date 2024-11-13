package com.game.maang.stacks;

import java.util.Stack;

public class BalanceParenthesis{
    public static boolean balance(String s){
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c == '}' && stack.peek() == '{' ) stack.pop();
			else if(c == ']' && stack.peek() == '[') stack.pop();
			else if(c == ')' && stack.peek() == '(') stack.pop();
			else stack.push(c);
        }
        return stack.isEmpty();
    }
    public static void main(String[] args){
        System.out.println("Is the string balanced :"+(balance("[()]{}{[()()]()}" )?"Yes":"No"));
        System.out.println("Is the string balanced :"+(balance("[()]{}{[()()]()" )?"Yes":"No"));
    }
}

