package com.game.maang.queues;

public class QueueUsingLL {
    private Node front = null;
    private Node rear = null;
    int capacity;
    int size;
    QueueUsingLL(int capacity){
        this.capacity = capacity;
        size = 0;
    }
    public boolean enqueue(int data){
        if(size == capacity-1){
            System.out.println("[OVERFLOW]: Queue is full.");
            return false;
        }
        Node node = new Node(data);
        System.out.println("Added "+data+" to the queue");
        if(rear == null) {
            front = rear = node;
            return true;
        }
        rear.next = node;
        rear = node;
        size++;
        return true;
    }
    public int deque(){
        if(size == 0 ) {
            System.out.println("[UNDERFLOW]: Queue is empty.");
            return -1;
        }
        int value = front.data;
        System.out.println("Removed "+value);
        if(front == rear)front = rear = null;
        else front = front.next;
        size--;
        return value;
    }
    public int peek(){
        if(size == 0)return -1;
        return front.data;
    }
    public void display(){
        Node ptr = front;
        while(ptr != null){
            System.out.print(ptr.data+"|");
            ptr  = ptr.next;
        }
        System.out.println();
    }
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        QueueUsingLL queue = new QueueUsingLL(5);
        queue.display();
        queue.deque();
        queue.enqueue(5);
        queue.enqueue(4);
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(2);
        queue.display();
        System.out.println("Upcoming value:"+queue.peek());
        queue.enqueue(21);
        queue.deque();
        queue.enqueue(12);
        queue.display();

    }
}
