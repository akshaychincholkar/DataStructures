package com.game.ds.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinimumRooms {
    public static void main(String[] args) {
        int lectures[][] = {{0, 5}, {1, 2}, {6, 10}};
        int minRooms = getMinimumRooms(lectures);
        System.out.println("Minimum rooms required : "+minRooms);
    }

    private static int getMinimumRooms(int[][] lectures) {
        int rooms = 0;
        List<Pair> list = new ArrayList<>();
        for(int i = 0;i<lectures.length;i++){
            list.add(new Pair(lectures[i][0],1));
            list.add(new Pair(lectures[i][1],-1));
        }
        Collections.sort(list);
        int count = 0;
        for(Pair pair:list){
            count+=pair.getFlag();
            rooms = Math.max(count,rooms);
        }
        return rooms;
    }
}
class Pair implements Comparable<Pair> {
    private int start;
    private int flag;
    Pair(int start,int flag){
        this.start = start;
        this.flag = flag;
    }
    int getStart(){
        return start;
    }
    int getFlag(){
        return flag;
    }

    @Override
    public int compareTo(Pair p1) {
        return this.getStart()-p1.getStart();
    }
}