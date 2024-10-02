package com.game.ds.arrays;

import java.util.HashSet;
import java.util.Set;

public class RatInMazeProblem {
    public static void main(String[] args) {
        int maze[][] = { { 1, 0, 0, 0 },
                         { 1, 1, 1, 1 },
                         { 0, 1, 0, 0 },
                         { 1, 1, 1, 1 } };
        System.out.println("Path found: "+findPath(maze));
    }

    private static boolean findPath(int[][] maze) {
        if(maze[0][0] == 0) return false;
        Set<String> visited = new HashSet<>();
        visited.add(""+0+""+0);
        if(isSafe(maze,0,0,visited))return true;
        return false;
    }

    private static boolean isSafe(int[][] maze, int i, int j, Set<String> visited) {
        if(i == maze.length-1 && j == maze[i].length-1) return true;
        // check for down
        if(i +1 < maze.length && maze[i+1][j] == 1 && !visited.contains(""+(i+1)+""+j)) {
            visited.add(""+(i+1)+""+j);
            if(isSafe(maze,i+1,j, visited)) return true;
            visited.remove(""+(i+1)+""+j);
        }
        // check for right
        if(j+1 < maze[i].length && maze[i][j+1] == 1 && !visited.contains(""+i+""+(j+1))) {
            visited.add(""+i+""+(j+1));
            if(isSafe(maze,i,j+1, visited)) return true;
            visited.remove(""+i+""+(j+1));
        }
        // check for up
        if(i -1 > 0 && maze[i-1][j] == 1 && !visited.contains(""+(i-1)+""+j)) {
            visited.add(""+(i-1)+""+j);
            if(isSafe(maze,i-1,j, visited)) return true;
            visited.remove(""+(i-1)+""+j);
        }
        // check for left
        if(j-1 >0 && maze[i][j-1] == 1 && !visited.contains(""+i+""+(j-1))) {
            visited.add(""+i+""+(j-1));
            if(isSafe(maze,i,j-1, visited)) return true;
            visited.remove(""+i+""+(j-1));
        }
        return false;
    }
}
