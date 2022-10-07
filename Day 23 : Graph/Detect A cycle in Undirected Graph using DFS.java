// Detect Cycle in a Graph using a DFS Traversal

// Approach 1:

// Do the DFS Traveral and pass the parent node and node and check the node is already visited or not if already visited and node != parent then cycle is detected 

// Code:

public class Solution {
  
    public static boolean dfs(int node , int parent , boolean[] vis , ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        for(int adjNode : adj.get(node)){
            if(!vis[adjNode]){
                if(dfs(adjNode , node , vis , adj))
                    return true;
            }
            else if(adjNode != parent)
                return true;
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
       
//         Using DFS Traversal
        for(int i=0;i<=n;i++){
            if(!vis[i]){
                if(dfs(i , -1 , vis , adj))
                    return "Yes";
            }
        }
        return "No";
    }
}
