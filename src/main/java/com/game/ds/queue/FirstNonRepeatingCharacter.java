package com.game.ds.queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstNonRepeatingCharacter{
    public static void main(String[] args){
        String s = "geeksforgeeks";
        System.out.println("First Non repeating character: "+solve(s));
    }
    public static char solve(String s){
        Map<Character,Integer> map = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();

        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                if(!queue.isEmpty()) removeElement(queue,c);
            }else{
                map.put(c,1);
                queue.add((char)c);
            }
        }
        return queue.remove();
    }
    public static void removeElement(Queue queue, char c){
        for(int i = 0 ;i<queue.size();i++){
            if((char)queue.peek() == c) {
                queue.remove();
            }
            queue.add(queue.remove());
        }
    }
}