package com.game.faang.arrays;

public class MyArray {
    int[] arr;
    int size;
    int capacity;

    MyArray(int capacity){
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.size = 0;
    }

    public void insert(int element){
        if(size == capacity){
            System.out.println("[OVERFLOW] Could not insert the element to the array.");
            return;
        }
        arr[size]=element;
        System.out.println("Element "+element+" added at position "+size);
        size++;
    }
    public int search(int value){
        for(int i=0;i<=size;i++){
            if(arr[i]==value)return i;
        }
        return -1;
    }
    public void delete(int value){
        int index = search(value);
        if(index == -1){
            System.out.println("[NOT FOUND] Element doesn't exists in array");
            return;
        }
        for(int i=index;i<size;i++){
            if(i!=size-1) arr[i] = arr[i+1];
        }
        size--;
    }
    public int getElementAtIndex(int index){
        if(index < 0 || index > size) return -1;
        return arr[index];
    }
    public void display(){
        if(size ==0 ) return;
        System.out.print("\n[ ");
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+( i == size - 1?"":", "));
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        MyArray array = new MyArray(5);
        array.insert(3);
        array.insert(12);
        array.insert(6);
        array.insert(21);
        array.insert(9);
        array.insert(15);

        array.display();
        System.out.println("Element at index 2 is :"+array.getElementAtIndex(2));
        array.delete(6);
        System.out.println("Element deleted :"+6);
        System.out.println("Element at index 2 is :"+array.getElementAtIndex(2));
        array.display();
        array.delete(30);
        System.out.println("Element 21 is present at "+array.search(21));
    }
}
