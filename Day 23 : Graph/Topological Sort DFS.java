// Topological Sort Using DFS Algorithm 

// Topological Sort - Suppose is a directed graph the edge between the u->v then u must appears before the v
// We can solve this problem using dfs algorithm and stack 

// after completion of all call for perticular node we can put it into the stack
// at the end pop all elements from the stack and return ans

// Code:

import java.util.* ;
import java.io.*; 
public class Solution 
{
    
    public static void topoSort(int node , Stack<Integer> st , boolean[] vis , ArrayList<ArrayList<Integer>> adj){
        
        vis[node] = true;
        for(int it : adj.get(node)){
            if(!vis[it]){
                topoSort(it , st , vis , adj);
            }
        }
        st.push(node);
    }
    
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) 
    {
        // Write your code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean[] vis = new boolean[v];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<v;i++)    adj.add(new ArrayList<>());
        
        for(int i=0;i<edges.size();i++){
            adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
        }
        for(int i=0;i<v;i++){
            if(!vis[i]){
                topoSort(i , st , vis , adj);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        return ans;
    }
}
