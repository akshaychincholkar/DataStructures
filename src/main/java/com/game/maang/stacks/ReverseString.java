package com.game.maang.stacks;

import java.util.Stack;

public class ReverseString {
        public static String reverseSimple(String s){
            Stack<Character> stack = new Stack<>();
            for(int i=0;i<s.length();i++){
                stack.push(s.charAt(i));
            }
            String result = "";
            for(int i=0;i<s.length();i++){
                result = result + stack.pop();
            }
            return result;
        }
        public static String reverse(String s){
            Stack<Character> stack = new Stack<>();
            for(char c: s.toCharArray())stack.push(c);
            StringBuilder result = new StringBuilder();
            while(!stack.isEmpty())result.append(stack.pop());
            return result.toString();
        }
        public static void main(String[] args){
            System.out.println("Reverse of Welcome: "+reverseSimple("Welcome"));
            System.out.println("Reverse of Welcome: "+reverse("Welcome"));
        }
    }

