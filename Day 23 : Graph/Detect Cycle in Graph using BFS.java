// Detect Cycle Using BFS Algorithm

// Approch:
// Using a Queue Data Structure and Parent node pair we can do the bfs traversal and detect cycle is present
// Node and Parent node save in queue and do travrsing in the graph also maintain the visited array

// Code:

import java.util.*;
class Pair{
        int node;
        int parent;
        Pair(int node , int parent){
            this.node = node;
            this.parent = parent;
        }
}

public class Solution {
    
    public static boolean detect(ArrayList<ArrayList<Integer>> adj , int src , boolean[] vis){
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src , -1));
        vis[src] = true;
        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int num : adj.get(p.node)){
                if(!vis[num]){
                    vis[num] = true;
                    q.add(new Pair(num , p.node));
                }
                else if(p.parent != num){
                    return true;
                }
            }
        }
        return false;
    }
    
    public static String cycleDetection(int[][] edges, int n, int m) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        boolean[] vis = new boolean[n+1];
        for(int i=0;i<=n;i++){
            if(!vis[i] && detect(adj , i , vis)){
                return "Yes";
            }
        }
        return "No";
    }
    
}
