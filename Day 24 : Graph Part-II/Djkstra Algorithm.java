// Djkstra Algorithm 
// Djkstra Algorithm is most popular algorithm to find the shortest path from source to all nodes

// Apprioach 1: Using PriorityQueue Data structure we can find the minimum distance from the source 
// priorityqueue is useful because it will always give minimum element on the top

// Time Complexity - O((N+E)logN)
// Space Complexity - O(N)+O(N)

// Code:

//GFG

//User function Template for Java
class Pair{
    int distance;
    int node;
    Pair(int distance , int node){
        this.distance = distance;
        this.node = node;
    }
    
}

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        PriorityQueue<Pair> q = new PriorityQueue<>((x,y)-> x.distance - y.distance);
        int[] dist = new int[V];
        for(int i=0;i<V;i++)    dist[i] = (int) (1e9);
        
        dist[S] = 0;
        q.offer(new Pair(0 , S));
        
        while(q.size() != 0){
            int dis =  q.peek().distance;
            int node = q.peek().node;
            q.remove();
            
            for(int i=0;i<adj.get(node).size();i++){
                int edgeWeight = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                if(dis + edgeWeight < dist[adjNode]){
                    dist[adjNode] = dis+edgeWeight;
                    q.offer(new Pair(dist[adjNode] , adjNode));
                }
            }
        }
        return dist;
    }
}

//CodingStudio

import java.util.*;
import java.io.*;

public class Solution {
	
	public static ArrayList < Integer > dijkstra(ArrayList< ArrayList < Integer > > vec, int vertices, int edges, int source){
        // Write your code here.
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0; i<vertices; i++) adj.add(new ArrayList<int[]>());
        
        //creating graph
        for(int i=0; i<edges; i++)
        {
            int u = vec.get(i).get(0);
            int v = vec.get(i).get(1);
            int w = vec.get(i).get(2);
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
            
        }
        //filled distance array with maximum distance
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        //pushed source node with distance 0.
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        q.add(new int[]{0, 0});
        distance[0] = 0;
        while(!q.isEmpty())
        {
            int dist = q.peek()[0];
            int node = q.poll()[1];
            
            for(int[] adjacentNode : adj.get(node))
            {
                if(dist + adjacentNode[1] < distance[adjacentNode[0]])
                {
                    distance[adjacentNode[0]] = dist + adjacentNode[1];
                    q.add(new int[]{distance[adjacentNode[0]], adjacentNode[0]});
                }
            }
        }
        ArrayList<Integer> dist = new ArrayList<>();
        for(int x : distance) dist.add(x);
        return dist;
    }
}
