// Rat in Maze problem
// Given us the arrray contain multiple path from (0,0) to (n-1,n-1)

// Approach :
// Use Recursion and continusly check for each way also carry one visited array to check whther the vertex is visited or not

// Time Complexity: O(4^(m*n))
// Space Complexity: O(N)+O(N)

// Code:
// GFG

class Solution {
    
    public static void solve(int i, int j ,int n, int[][] m , String move , ArrayList<String> ans, int[][] vis , int[] di , int[] dj){
        
        if(i == n-1 && j == n-1){
            ans.add(move);
            return;
        }
        
        String dir = "DLRU";
        for(int ind = 0;ind<4;ind++){
            
            int nexti = i+di[ind];
            int nextj = j+dj[ind];
            
            if(nexti >= 0 && nextj >= 0 && nexti < n && nextj < n && vis[nexti][nextj] == 0 && m[nexti][nextj]==1){
                vis[i][j]=1;
                solve(nexti,nextj,n,m,move+dir.charAt(ind),ans , vis , di , dj);
                vis[i][j]=0;
            }
        }
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> ans = new ArrayList<>();
        int[][] vis = new int[n][n];
        
        int[] di = {1,0,0,-1};
        int[] dj = {0,-1,1,0};
        
        if(m[0][0]==1)
            solve(0,0,n ,m,"",ans,vis,di,dj);
        
        return ans;
    }
}

// Coding Studio :

public class Solution {
    
    public static void solve(int i, int j ,int n, int[][] m , ArrayList<ArrayList<Integer>> ans, int[][] vis , int[] di , int[] dj){
        
        vis[i][j]=1;
        if(i == n-1 && j == n-1){
            ArrayList<Integer> path = new ArrayList<>();
            for(int a=0;a<n;a++){
                for(int b=0;b<n;b++){
                    path.add(vis[a][b]);
                }
            }
            ans.add(path);
            vis[i][j]=0;
            return;
        }
        
        for(int ind = 0;ind<4;ind++){
            
            int nexti = i+di[ind];
            int nextj = j+dj[ind];
            
            if(nexti >= 0 && nextj >= 0 && nexti < n && nextj < n && vis[nexti][nextj] == 0 && m[nexti][nextj]==1){
//                 vis[i][j]=1;
                solve(nexti,nextj,n,m,ans , vis , di , dj);
//                 vis[i][j]=0;
            }
        }
        vis[i][j]=0;
    }
    
    public static ArrayList<ArrayList<Integer>> ratInAMaze(int[][] m, int n) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[][] vis = new int[n][n];
        
        int[] di = {1,0,0,-1};
        int[] dj = {0,-1,1,0};
        
        if(m[0][0]==1)
            solve(0,0,n ,m,ans,vis,di,dj);
        
        return ans;
    }
}
