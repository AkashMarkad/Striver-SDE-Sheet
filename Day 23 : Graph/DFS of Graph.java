// DFS Traversal of Graph

// Given : Graph 
// We need to return one of the traversal of the graph 

// Aproach 1: Recursive Solution 

// maintain boolean to check whether vertex is visited or not if !vis then vis and add it to solution 
// return ans;

// Time Complexity - O(N+E)
// Space Complexity  -O(N+E)

// Code:

import java.util.ArrayList;

public class Solution {
    
    private static void dfs(int node, boolean[] vis , ArrayList<ArrayList<Integer>> adj , ArrayList<Integer> arr){
        
        arr.add(node);
        vis[node] = true;
        for(int num : adj.get(node)){
            if(!vis[num]){
                dfs(num , vis , adj , arr);
            }
        }
        
    }
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<e;i++){
            adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
            adj.get(edges.get(i).get(1)).add(edges.get(i).get(0));
        }
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean[] vis = new boolean[v];
        for(int i=0;i<v;i++){
            if(!vis[i]){
                ArrayList<Integer> arr = new ArrayList<>();
                dfs( i , vis , adj , arr);
                ans.add(arr);
            }
        }
        return ans;
    }
} 

// Code : 

import java.util.ArrayList;

public class Solution {
    
    private static void dfs(int node, boolean[] vis , ArrayList<ArrayList<Integer>> adj , ArrayList<Integer> arr){
        
        arr.add(node);
        vis[node] = true;
        for(int num : adj.get(node)){
            if(!vis[num]){
                dfs(num , vis , adj , arr);
            }
        }
        
    }
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<e;i++){
            adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
            adj.get(edges.get(i).get(1)).add(edges.get(i).get(0));
        }
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean[] vis = new boolean[v];
        for(int i=0;i<v;i++){
            if(!vis[i]){
                ArrayList<Integer> arr = new ArrayList<>();
                dfs( i , vis , adj , arr);
                ans.add(arr);
            }
        }
        return ans;
    }
}
