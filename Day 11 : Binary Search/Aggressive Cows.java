// Aggresive Cows
// Given the number of cows and array having distance we need to place all the cows and return the maximum minimum distance between the cows

//Appraoch: Binary Search (Optimised Approach)
// Same as the prebious problem i.e Alloacate minimum nuber of pages  

// Time Complexity : O(N*logN)
// Space Complexity : O(1)

// Code:

import java.util.*;
public class Solution {

    public static boolean canPlaceC(int[] arr , int n , int c , int dist){
        int co_ordi = arr[0];
        int count = 1;
        for(int i=0;i<n;i++){
            if(arr[i]-co_ordi >= dist){
                count++;
                co_ordi = arr[i];
            }
            if(count == c)    return true;
        }
        return false;
    }
    public static int chessTournament(int[] positions, int n,  int c) 
	{
        // Write your code here.  
        Arrays.sort(positions);
        
        int low = 1;
        int high = positions[n-1]-positions[0];
        int res = 0;
        
        while(low <= high){
            int mid = (low+high) >> 1;
            
            if(canPlaceC(positions,n,c,mid)){
                res = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return res;
    }

}
