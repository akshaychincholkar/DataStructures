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



        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject(1,"Maths",100));
        subjects.add(new Subject(2,"English",81));
        subjects.add(new Subject(3,"Science",95));

        List<Student> students = new ArrayList<>();
        students.add(new Student(1,21,"Darshana",subjects));
        students.add(new Student(2,25,"Akshay",subjects));
        students.add(new Student(3,30,"Subhash",subjects));


        // create comparable for student based on name
        System.out.println(students);
        System.out.println("Sorted based on name");
        Collections.sort(students);
        System.out.println(students);

        System.out.println("sorted based on age");
        // Create comparator for student to sort based on age
        Collections.sort(students,(s1,s2)->s1.age-s2.age);
        System.out.println(students);
        // sort student lexicographically  with subject highest marks first
        Collections.sort(students);
        Collections.sort(subjects,(s1,s2)->s2.marks-s1.marks);
        System.out.println("sorted based on students alphabetically and marks in descending order");
        System.out.println(students);
    }
}
class Student implements Comparable<Student>{
    int id;
    int age;
    String name;
    List<Subject> subjects;
    Student(int id,int age,String name,List<Subject> subjects){
        this.id = id;
        this.age = age;
        this.name = name;
        this.subjects = subjects;
    }

    @Override
    public int compareTo(Student o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "\nStudent{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
class Subject{
    int id;
    String name;
    int marks;
    Subject(int id, String name, int marks){
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "\n \t \t Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}