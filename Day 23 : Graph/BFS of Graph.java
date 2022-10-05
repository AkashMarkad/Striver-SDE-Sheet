// BFS Traversal of Graph 

// Input : Graph
// Output: BFS Traversal

// Approach 1: Using Queue Data Structure

// Code:

//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                // adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
            
        q.add(0);
        vis[0] = true;
            
        while(!q.isEmpty())
        {
            int num = q.poll();
            bfs.add(num);
            for(int node : adj.get(num))
            {
                if(!vis[node])
                {
                    q.add(node);
                    vis[node] = true;
                }
            }
            
        }
        
        return bfs;

    }
}

// CodingStudio Code :

import java.util.* ;
import java.io.*; 
public class Solution {
    
    public static void bfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> ans){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = true;
        ans.add(node);
        while(!q.isEmpty()){
            Collections.sort(adj.get(q.peek()));
            for(int i : adj.get(q.poll())){
                if(!vis[i]){
                    vis[i] = true;
                    ans.add(i);
                    q.add(i);
                }
            }
        }
    }
    public static ArrayList<Integer> BFS(int vertex, int edges[][]){
        // WRITE YOUR CODE HERE
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean vis[] = new boolean[vertex];
        for(int i=0;i<vertex;i++){
            adj.add(new ArrayList<>());
        }
         for(int i=0;i<edges[0].length;i++){
            adj.get(edges[1][i]).add(edges[0][i]);
            adj.get(edges[0][i]).add(edges[1][i]);
        }
        for(int i=0;i<vertex;i++){
            if(!vis[i]){
                bfs(i,adj,vis,ans);
            }
        }
        return ans;
    }
}
