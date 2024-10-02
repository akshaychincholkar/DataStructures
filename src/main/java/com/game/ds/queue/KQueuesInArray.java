package com.game.ds.queue;

public class KQueuesInArray{
    int[] front;
    int[] rear;
    int[] next;
    int[] a;
    int free;
    public KQueuesInArray(int k, int n){
        front = new int[k];
        rear = new int[k];

        for(int i = 0;i<k;i++){
            front[i]=-1;
            rear[i] =-1;
        }
        a = new int[n];
        next = new int[n];
        for(int i =0 ;i<n;i++){
            next[i]=i+1;
        }
        next[n-1] = -1;
    }
    public  boolean isFull(){
        return free == -1;
    }
    public boolean isEmpty(int queue){
        return front[queue] == -1;
    }
    public  void enque(int value,int queue){
        if(isFull()) {
            System.out.println("Full");
            return;
        }
        int nextFree = free;
        if(isEmpty(queue)){
            front[queue] = rear[queue] = free;
        }else{
            rear[queue] = free;
            next[free] = free;
        }
        a[free] = value;
        free = nextFree;
        System.out.println("Value added: "+value);
    }
    public  void deque(int queue){
        if(isEmpty(queue)) {
            System.out.println("Empty");
            return;
        }
        int frontIndex = front[queue];
        front[queue] = next[frontIndex];
        next[frontIndex] = free;
        free = frontIndex ;
        System.out.println("Removed");
    }
    public static void main(String[] args){
        KQueuesInArray queue = new KQueuesInArray(3,10);
        queue.enque(21,1);
        queue.enque(30,1);


    }
}

