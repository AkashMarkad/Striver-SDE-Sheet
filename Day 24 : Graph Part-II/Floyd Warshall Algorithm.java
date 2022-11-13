// Floyd Warshall Algorithm 
// Floyd Warshall Algorithm is used to find the minimum diatance between the source and the destinations

// Approach 1:

// Algorithm: 1) Intialize array of n*n i.e dp[n][n]
//            2) fill array by infinity and donals by zero
//            3) Now using three for loops check and assign min to the dp[i][j]
//            4) return dp

// Time Complexity - O(V*V*v)
// Space Compleity - O(N*N)

// Code:
// GFG
class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        // Code here 
        
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==-1)    matrix[i][j] = (int) (1e9);
                if(i==j)    matrix[i][j] = 0;
            }
        }
        
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    matrix[i][j] = Math.min(matrix[i][j] , matrix[i][k] + matrix[k][j]);
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == (int) (1e9)) matrix[i][j] = -1;
            }
        }
        
        // ------------------------------------------------------------------
        
        // int n = matrix.length;
        
        // for(int k=0; k<n; k++)
        // {
        //     for(int j=0; j<n; j++)
        //     {
        //         for(int i=0; i<n; i++)
        //         {
        //             if(matrix[i][k]==-1 || matrix[k][j]==-1) continue;
                    
        //             if(matrix[i][j]==-1 || (matrix[i][j] > matrix[i][k] + matrix[k][j]))
        //             {
        //                 matrix[i][j] = matrix[i][k] + matrix[k][j];
        //             }
        //         }
        //     }
        // }
    }
}

// CodingStudio Code : 


public class Solution {
  static int floydWarshall(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
      int dp[][] = new int[n+1][n+1];
     
      for(int arr[] : dp){
          Arrays.fill(arr,1000000000);
      }
       for(int i=1;i<=n;i++){
          dp[i][i]=0;
      }
      for(ArrayList<Integer> arr : edges){
          dp[arr.get(0)][arr.get(1)] = arr.get(2);
      }
      for(int k=1;k<=n;k++){
          for(int i=1;i<=n;i++){
              for(int j=1;j<=n;j++){
                  if(dp[i][k]!=1e9 && dp[k][j]!=1e9){
                      dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k][j]);
                  }
              }
          }
      } 
      return dp[src][dest];
  }

}
