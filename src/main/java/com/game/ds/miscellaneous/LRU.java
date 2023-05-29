package com.game.ds.miscellaneous;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCache{
    int key;
    String value;
    LRUCache(int key,String value){
        this.key = key;
        this.value = value;
    }
}
public class LRU {
    Map<Integer,LRUCache> map = new HashMap<>();
    Deque<Integer> queue = new LinkedList<>();
    private final int CAPACITY;

    public LRU(int capacity) {
        CAPACITY = capacity;
    }

    public void put(int key,String value){
        if(map.containsKey(key)){
            LRUCache temp = map.remove(key);
            queue.remove(temp.key);
            System.out.println("reshuffling..");
        }else{
            if(queue.size()==CAPACITY){
                int removed = queue.removeLast();
                System.out.println("Value removed from queue: "+removed);
            }
        }
        LRUCache temp = new LRUCache(key,value);
        map.put(key,temp);
        queue.addFirst(key);
        System.out.println("Successfully added to the queue:"+queue);
    }
    public String get(int key){
        if(map.containsKey(key)){
            return map.get(key).value;
        }
        return "NOT EXISTS";
    }
    public void display(){
        System.out.println("Current contents of cache: "+queue);
    }
    public static void main(String[] args){
        LRU lru = new LRU(3);

        lru.put(1,"one");
        lru.put(2,"two");
        lru.put(3,"three");
        lru.put(1,"ONE");
        lru.put(4,"four");
        System.out.println(lru.get(1));
        lru.put(5,"five");
        lru.display();

    }
}
