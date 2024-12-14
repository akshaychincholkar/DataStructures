package com.game.maang.queues;

public class CustomCircularQueue {
    int[] queue;
    int capacity;
    int front;
    int rear;
    int size;
    public CustomCircularQueue(int capacity){
        this.capacity = capacity;
        queue = new int[capacity];
        size = front = rear = 0;
    }
    public boolean add(int value){
        if(size == capacity && front == rear){
            System.out.println("[OVERFLOW]: Queue is full");
            return false;
        }
        queue[rear] = value;
        rear = (rear + 1) % capacity;
        size++;
        System.out.println("value added: "+value);
        return true;
    }
    public boolean remove(){
        if(size ==0 && front == rear){
            System.out.println("[UNDERFLOW]: Queue is empty");
            return false;
        }
        System.out.println("Value removed: "+queue[front]);
        front = (front +1 )%capacity;
        size--;
        return true;
    }
    public void display(){
        int pointer=front;
        for(int i = 0;i<size;i++,pointer=(pointer+1)%capacity){
            System.out.print("|"+queue[pointer]+"|");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CustomCircularQueue queue = new CustomCircularQueue(8);
        queue.display();
        queue.add(3);
        queue.add(4);
        queue.display();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.add(8);
        queue.add(7);
        queue.add(6);
        queue.add(5);
        queue.add(4);
        queue.add(3);
        queue.add(2);
        queue.add(1);
        queue.add(0);
        queue.display();
        queue.remove();
        queue.display();
    }
}
