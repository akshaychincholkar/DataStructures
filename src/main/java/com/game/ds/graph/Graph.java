package com.game.ds.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
    public static void main(String[] args) {
        Graph graph=new Graph();
        graph.addEdge(1,2,true);
        graph.addEdge(1,3,true);
        graph.addEdge(1,4,true);

        System.out.println(graph);
        System.out.println("Graph has "+graph.getVertexCount()+" number of vertices");
        System.out.println("Graph has "+graph.getEdgeCount()+" number of edges");
        System.out.println("Graph has edge between 1 & 3 ?:"+graph.hasEdge(1,3)+" number of edges");
        System.out.println("Graph has vertex  4? :"+graph.hasVertex(4));
    }
}
