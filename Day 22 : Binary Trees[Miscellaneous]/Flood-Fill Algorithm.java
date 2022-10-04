// Flood-fill Algorithm

// Input Matrix :
// output : Change the all adjcaent same value to the new value

// Recursion: Recursively call the function and check adjcent have same value or nor if same value then update it to the new value
// go four directionally of given value

// Code:

// 1) 

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color) return image;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr,sc});
        // image[sr][sc] = color;
        int row[] = new int[]{-1,1,0,0};
        int col[] = new int[]{0,0,-1,1};
        int c=image[sr][sc];
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int arr[] = q.poll();
                for(int i=0;i<4;i++){
                    int nr = arr[0]+row[i];
                    int nc = arr[1]+col[i];
                    if(nr>=0 && nc>=0 && nr<image.length && nc<image[0].length && c==image[nr][nc] ){
                        // System.out.println(nr+" "+nc);
                        q.offer(new int[]{nr,nc});
                    }
                }
                image[arr[0]][arr[1]] = color;
            }
        }
        return image;
    }
}

// 2) CodingStudio Solution : 

import java.util.*;
public class Solution
{
    public static void dfs(int [][] image , int r , int c , int color , int newColor){
        if(image[r][c] == color){
            image[r][c] = newColor;
            if(r>=1){
                dfs(image , r-1 , c , color , newColor);
            }
            if(c>=1){
                dfs(image , r , c-1 , color , newColor);
            }
            if(r+1<image.length){
                dfs(image , r+1 , c , color , newColor);
            }
            if(c+1 < image[0].length){
                dfs(image , r , c+1 , color , newColor);
            }
        }
    }
    public static int[][] floodFill(int[][] image, int x, int y, int newColor)
    {
        // Write your code here
        int color = image[x][y];
        if(color != newColor){
            dfs(image , x , y , color , newColor);
        }
        return image;
        
    }
}
