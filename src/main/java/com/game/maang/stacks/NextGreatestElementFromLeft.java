package com.game.maang.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NextGreatestElementFromLeft {
    public static List<Integer> get(int[] a){
        List<Integer> list = new ArrayList<>();
        if(a.length == 1) {
            list.add(-1);
        }
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<a.length;i++){
            while(!stack.isEmpty() && stack.peek()<a[i])stack.pop();
            if(stack.isEmpty())list.add(-1);
            else list.add(stack.peek());
            stack.push(a[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println("Output of [4,5,2,25]:"+get(new int[]{4,5,2,25}));
        System.out.println("Output of [60,5,2,15,4,13,50,3,8,25]:"+get(new int[]{60,5,2,15,4,13,50,3,8,25}));
    }
}
