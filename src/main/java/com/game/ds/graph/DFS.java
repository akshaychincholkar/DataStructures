package com.game.ds.graph;

import java.util.LinkedList;
import java.util.Stack;

public class DFS {
    private int vertices;
    private LinkedList<Integer>[] adj;

    DFS(int vertices){
        this.vertices = vertices;
        adj = new LinkedList[vertices];
        for(int i = 0; i < vertices;i++){
            adj[i] = new LinkedList<>();
        }
    }
    public void addEdge(int source, int dest){
        adj[source].add(dest);
    }
    public static void main(String[] args) {
        DFS graph = new DFS(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        boolean[] visited = new boolean[4];
        graph.traverseDfs(2, visited);
    }

    private void traverseDfs(int source, boolean[] visited) {
        visited[source] = true;
        System.out.print(source+"  ");
        adj[source].forEach(n->{
                    if(!visited[n]){
                        visited[n] = true;
                        traverseDfs(n,visited);
                    }
                });
    }
}
