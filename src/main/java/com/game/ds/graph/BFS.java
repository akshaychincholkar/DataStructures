package com.game.ds.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private int vertices;
    private LinkedList<Integer> adj[];

    BFS(int vertices){
        this.vertices = vertices;
        adj = new LinkedList[vertices];
        for(int i = 0 ; i< vertices;i++){
            adj[i] = new LinkedList<>();
        }
    }
    public void addEdge(int source, int dest){
        adj[source].add(dest);
    }
    public static void main(String[] args) {
        BFS graph = new BFS(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        graph.traverseBfs(2);

    }

    private void traverseBfs(int source) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertices];

        visited[source] = true;
        queue.add(source);

        while(!queue.isEmpty()){
            int cur = queue.poll();
            System.out.print(cur+ "  ");
            adj[cur].forEach(n->{
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            });
        }

    }
}
