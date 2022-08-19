// Rotten Oranges
// Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4

// Problem LeetCode : https://leetcode.com/problems/rotting-oranges/
    
// Approach 1: BFS
// Use Queue to store all initial rotten elements in queue and pop each element and check for 4 direction any fresh oranges if present then convert it into rotten and add it into int the queue and count all the elements entered in queue 
// Intially count the all oranges int the grid

// if total oaranges and inserted ornges are equal then return the countMin steps i. how many times we use BFS
// else retun -1

// Time Complexity - O(N*N)*4
// Space Complexity - O(N*N)

// Code:

class Solution {
    public int orangesRotting(int[][] grid) {
        
        if(grid == null || grid.length==0)  return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int count_fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == 2)
                    q.offer(new int[]{i,j});
                
                if(grid[i][j] != 0)
                    count_fresh++;
            }
        }
        
        if(count_fresh==0)  return 0;
        int countMin = 0 , cnt = 0;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        
        // bfs started from initially rotten oranges
        while(!q.isEmpty()){
            int size = q.size();
            cnt += size;
            for(int i=0;i<size;i++){
                int[] point = q.poll();
                for(int j=0;j<4;j++){
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];

                    if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y]==2)    continue;

                    grid[x][y] = 2;

                    q.offer(new int[]{x,y});
                }
            }
            if(q.size() != 0)
                countMin++;
        }
        
        return count_fresh == cnt ? countMin : -1;
    }
}
