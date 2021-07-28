package com.game.ds.graph;

import java.util.*;

public class Graph {
    Map<Integer,List<Integer>> graph = new HashMap<>();

    public void addEdge(int value,int adj_node,boolean isBidirectional){
        if(isBidirectional){
            if(!graph.containsKey(value)){
                List<Integer> list = new LinkedList<>();
                list.add(adj_node);
                graph.put(value,list);
            }else{
                List<Integer> valList = graph.get(value);
                valList.add(adj_node);
            }
            if(graph.containsKey(adj_node)){
                List<Integer> list = graph.get(adj_node);
                list.add(value);
            }else{
                List<Integer> list = new LinkedList<>();
                list.add(value);
                graph.put(adj_node,list);
            }
        }
    }

    public int getVertexCount(){
        return graph.size();
    }
    public int getEdgeCount(){
        int count=0;
        for(Map.Entry<Integer,List<Integer>> entry: graph.entrySet()){
            for(Integer element:entry.getValue())count++;
        }
        return count/2;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer,List<Integer>> entry: graph.entrySet()){
            sb.append(entry.getKey()+" :- ");
            List<Integer> list=entry.getValue();
            for(Integer element:list) sb.append("->"+"\t"+element);
            sb.append("\n");
        }
        return new String(sb);
    }
    public boolean hasVertex(int vertex){
        if(graph.containsKey(vertex))return true;
        return false;
    }
    public boolean hasEdge(int vertex,int edge){
        if(graph.containsKey(vertex)){
            List<Integer> list = graph.get(vertex);
            for(Integer element: list){
                if(element == edge)return true;
            }
        }
        return false;
    }
    public void bfs(int start){
        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> visited = new HashSet<>();
        if(graph.containsKey(start)){
            System.out.print(start+"\t");
            ((LinkedList<Integer>) queue).add(start);
            visited.add(start);
            while (!queue.isEmpty()){
                int temp = queue.remove();
                List<Integer> list = graph.get(temp);
                for(Integer element:list){
                    if(!visited.contains(element)){
                        System.out.print(element+"\t");
                        ((LinkedList<Integer>) queue).add(element);
                        visited.add(element);
                    }
                }
            }

        }else{
            System.out.println("Enter valid start vertex..");
        }
        System.out.println();
    }
    public void dfs(int start){
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        if(graph.containsKey(start)){
//            System.out.print(start+"\t");
            stack.push(start);
            visited.add(start);
            while(!stack.isEmpty()){
                int temp =stack.pop();
                System.out.print(temp+"\t");
                for(Integer element:graph.get(temp)){
                    if(!visited.contains(element)){
                        visited.add(element);
                        stack.push(element);
                    }
                }
            }
        }else{
            System.out.println("Enter valid start vertex..");
        }
        System.out.println();
    }
    public boolean isCyclic(int start){
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        if(graph.containsKey(start)){
            stack.push(start);
            visited.add(start);
            while(!stack.isEmpty()){
                int temp = stack.pop();
//                System.out.print(temp+"\t");
                List<Integer> list = graph.get(temp);
                for(Integer element:list){
                    if(!visited.contains(element)){
                        stack.push(element);
                        visited.add(element);
                    }else{
                        if(stack.contains(element))return true;
                    }
                }
            }
        }
        System.out.println();
        return false;
    }
    public static void main(String[] args) {
        Graph graph=new Graph();
        graph.addEdge(1,2,true);
        graph.addEdge(2,3,true);
        graph.addEdge(1,4,true);
        graph.addEdge(3,5,true);
        graph.addEdge(3,6,true);
        graph.addEdge(6,7,true);
        graph.addEdge(7,5,true);

        System.out.println(graph);
        System.out.println("Graph has "+graph.getVertexCount()+" number of vertices");
        System.out.println("Graph has "+graph.getEdgeCount()+" number of edges");
        System.out.println("Graph has edge between 1 & 3 ?:"+graph.hasEdge(1,3)+" number of edges");
        System.out.println("Graph has vertex  4? :"+graph.hasVertex(4));

        graph.bfs(1);
        graph.dfs(1);
        System.out.println("Is cyclic graph:"+graph.isCyclic(1));
    }
}
