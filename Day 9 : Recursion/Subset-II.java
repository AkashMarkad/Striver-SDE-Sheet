// Subset-II
// We need to return all possible subsets without duplicates

// Problem Link : 1) https://leetcode.com/problems/subsets-ii/
//                2) https://www.codingninjas.com/codestudio/problems/unique-subsets_3625236?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
  
// Approach 1:
// Use Pick and not to pick techinique i.e recursion and generate all possible subsets 
// add it to solution 
// Use set or any other data structure to check the duplicates

// Approach 2:
// Use Data structure to store the generated subsets 
// Do not call same elements again because it will add same subsets

// Time Complexity-  O(2^N*N)
// Space Complexity - O(2^N)


// Code:

import java.util.*;
public class Solution {
    public static void func(int ind,ArrayList<Integer> ds,int[] nums,ArrayList<ArrayList<Integer>> ans){
        ans.add(new ArrayList<>(ds));
        for(int i = ind;i<nums.length;i++){
            if(i != ind && nums[i] == nums[i-1])
                continue;
            ds.add(nums[i]);
            func(i+1,ds,nums,ans);
            ds.remove(ds.size()-1);
        }
    }
    
    public static ArrayList<ArrayList<Integer>> uniqueSubsets(int n, int arr[]) {
        // Write your code here..
        Arrays.sort(arr);
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        func(0,list,arr,ans);
        return ans;
    }

}
