package com.game.maang.recursion;

class Reverse{
    public static String doReverse(String s){
        if(s.length() == 1) return s;
        char c = s.charAt(0);
        return doReverse(s.substring(1))+ c;
    }
    public static void main(String[] args){
        String s = "Happy";
        System.out.println("Reverse of "+s+" is "+doReverse(s));
    }
}
