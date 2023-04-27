package com.game.java8.lambda;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionExamples {
    public static void main(String[] args){
        int[] a = {5,1,2,4,3};
        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
        System.out.println(list);

        String[] strs = {"Akshay","Godu"};
        List<String> list2 = Arrays.asList(strs);
        System.out.println(list2);

        Map<String,Integer> map = new HashMap<>();
        map.put("One",1);
        map.put("Two",2);
        map.put("Three",3);
        map.put("Four",1);
        map.put("Five",1);
        for(Map.Entry<String,Integer> e:map.entrySet()){
            System.out.println(e.getKey()+" :"+e.getValue());
        }
        int[] b = new int[10];
        Arrays.fill(b,0,2,3);
        System.out.println(Arrays.toString(b));

        Stack<Integer> stack = new Stack();
        stack.push(2);
        stack.push(1);
        System.out.println("Stack peek(): "+stack.peek()+" stack: "+stack);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(2);
        queue.add(1);
        System.out.println("Queue poll: "+queue.poll()+" Queue:"+queue);

        Queue<Integer> minheap = new PriorityQueue<>();
        minheap.add(3);
        minheap.add(2);
        minheap.add(1);
        System.out.println("minheap top: "+minheap.peek()+" Minheap: "+minheap);

        Queue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        maxheap.add(3);
        maxheap.add(2);
        maxheap.add(1);
        System.out.println("Max heap: top: "+maxheap.peek()+" maxheap: "+maxheap);
        int i ;
        for(i = 0;i<10;i++){
            if(i==0){
                break;
            }
        }
        System.out.println(" Value of i after break: "+i);
    }
}
