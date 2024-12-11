package com.game.maang.queues;

public class CustomQueue {
    private int[] arr;
    private int front, rear, capacity;

    // Constructor
    public CustomQueue(int size) {
        capacity = size;
        arr = new int[capacity];
        front = rear = 0;
    }

    // Enqueue method
    public void enqueue(int item) {
        if (rear == capacity) {
            System.out.println("Queue is full");
            return;
        }
        arr[rear++] = item;
    }

    // Dequeue method
    public int dequeue() {
        if (front == rear) {
            System.out.println("Queue is empty");
            return -1;
        }
        int item = arr[front++];
        return item;
    }

    // Display Queue
    public void display() {
        if (front == rear) {
            System.out.println("Queue is empty");
            return;
        }
        for (int i = front; i < rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        CustomQueue queue = new CustomQueue(3);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.print("Queue: ");
        queue.display();

        System.out.println("Removed: " + queue.dequeue());

        System.out.print("Queue after dequeue: ");
        queue.display();
        System.out.println("After removing all the elements");
        queue.dequeue();
        queue.dequeue();
        queue.display();
        System.out.println("Adding single element");
        queue.enqueue(50);
        queue.display();
    }
}



