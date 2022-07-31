// Combination Sum-II 

// Problem Link : 1) https://leetcode.com/problems/combination-sum-ii/
//                2) https://www.codingninjas.com/codestudio/problems/1112622?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

// Input : [1,1,1,2,2] ans sum=4 => [[1,1,2],[2,2]]
// Dupliactes are Not allowed

// Approach 1: Brute Force 
// Find the all the subsets and using hashset store only unique subsets 
// return unique subsets

// Approach 2: Optimal Approach
// Do not call the same function for the same value i.e starting or any position of value must be unique if there is same calls must ignore this cases

// Time Complexity   - O(2^N + K)
// Space Complexity - O(k * x)

// Code:

class Solution {
    
    public void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans , List<Integer> ds){
        
            if(target==0){
                ans.add(new ArrayList<>(ds));
                return;
            }
            
       
        for(int i=ind;i<arr.length;i++){
            if(i > ind && arr[i] == arr[i-1])  continue;
            if(arr[i]>target)   break;
            ds.add(arr[i]);
            findCombinations(i+1,arr,target-arr[i],ans,ds);
            ds.remove(ds.size()-1);
         
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }
}
