// Max Consecutive Ones

// Apparoach 1:
// steps : 1) Intialize count-0,max=0
//         2) if arr[i]==1 count++;
//         3) else max  = Math.max(max, count0) and count=0

// Code :-
// Leetcode
// Problem Link : https://leetcode.com/problems/max-consecutive-ones/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
//         int cnt = 0 , max = 0;
        
//         for(int i=0;i<nums.length;i++){
            
//             if(nums[i] == 1)
//                 cnt++;
//             else
//                 cnt = 0;
            
//             max = Math.max(max , cnt);
//         }
        
//         return max;
        
        // -------------------------------------------------------------------------
        
        int current = 0;
        int maxCount = Integer.MIN_VALUE;
        for (int i : nums) {
            if (i != 0) {
                current++;
            } else {
                maxCount = Math.max(current, maxCount);
                current = 0;
            }
        }
        return Math.max(current, maxCount);
    }
}


// CodeStudio
// Problem Link : https://www.codingninjas.com/codestudio/problems/maximum-consecutive-ones_892994?topList=striver-sde-sheet-problems

import java.util.ArrayList;

public class Solution {
	public static int longestSubSeg(ArrayList<Integer> arr , int n, int k) {
		// Write your code here.
         int max=0;
        int i=0;
        int j=0;
        while(j<n){
            if(arr.get(j)==0) k--;
            if(k<0){
                while(arr.get(i)!=0) i++;
                i++;
                k++;
            }
            else{
                max = Math.max(max,j-i+1);
            }
            j++;
        }
        return max;
	}
}

