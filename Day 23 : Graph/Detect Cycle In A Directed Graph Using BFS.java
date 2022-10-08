// Detect Cycle in Directed graph using BFS 

// Approach 1: using topological sort we can detect the cycle in directed graph if we are able to do topological sort then no cycle is present else cycle is not present

// Time Complexity - O(N+E)
// Space Complexity - O(N)+O(N)

// Code:


import java.util.*;
public class Solution {
   
  public static boolean detectCycleInDirectedGraph(int n, ArrayList<ArrayList<Integer >> edges) {
    // Write your code here.
      ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
      boolean[] vis = new boolean[n+1];
      boolean[] dfsVis = new boolean[n+1];
      for(int i=0;i<=n;i++)    adj.add(new ArrayList<>());
      
      for(int i=0;i<edges.size();i++){
          adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
      }
      
      int[] indegree = new int[n+1];
      for(int i=1;i<=n;i++){
          for(Integer num : adj.get(i)){
              indegree[num]++;
          }
      }
      Queue<Integer> q = new LinkedList<>();
      for(int i=1;i<=n;i++){
          if(indegree[i]==0)
              q.offer(i);
      }
      int cnt = 0;
      while(!q.isEmpty()){
          Integer node = q.poll();
          cnt++;
          for(Integer num : adj.get(node)){
              indegree[num]--;
              if(indegree[num]==0){
                  q.offer(num);
              }
          }
      }
      
      if(cnt == n)    return false;
      return true;
      
  }
}
