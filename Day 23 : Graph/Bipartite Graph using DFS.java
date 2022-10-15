// Bipartite Graph using BFS 

// Approach :
// Bipartite Grpah :- Graph is coloured using only two color i.e no two adjacent nodes have a same color 

// We use a color array and fill it by -1
// while we visit node then the adjacent nodes of that nodes are not visited then we visit it and color it using opposite color of node
// if nodes alraedy visted then check the nodes have no same color if same color tehn return false

// Time Complexity - O(N+E)
// Space Complexity - O(N+E) + O(N) + O(N)

// Code:

class Solution {

    public static boolean dfs(int node , int[][] graph , int col, int[] color){
        color[node] = col;

        for(int it : graph[node]){
            if(color[it]==-1){
                if(!dfs(it , graph , 1-col , color))    return false;
            }
            else if(color[it]==col) return false;
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] color = new int[v];
        Arrays.fill( color , -1);

        for(int i=0;i<v;i++){
            if(color[i]==-1 && !dfs(i , graph , 0, color)) return false;
        }
        return true;
    }
}
