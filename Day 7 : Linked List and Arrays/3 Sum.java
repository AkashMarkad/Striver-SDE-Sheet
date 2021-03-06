// 3 Sum
// Find the triplet whose sum is equal to Zero

// Problem Link : 1) https://leetcode.com/problems/3sum/
//                2) https://www.codingninjas.com/codestudio/problems/893028?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

// Approach 1: Brute Force
// Use Seperate loop for each element and check whether sum is zero or not
// if sum is zero then using hashset check whether this triplet already present or not if not present then add it to Solution
// return the result

// Time Complexity - O(N^3 * logM)
// Space Complexity - O(M)

// Appraoch 2: Use HashMap to store the frequency 
// While travrsing travrse using two  loop and check whether remaining element is present in hashmap if present then add it to solution
// return the solution

// Time Complexity - O(N^2* logM)
// Space Complexity - O(N) + O(M)

// Approach 3: Optimal Approach
// steps: 1) Sort the array
//        2) Now using two pointer approach find the remaining two elements
//        3) Also for avoiding the repeating elements skip the same elements

// Time Complexity- O(N^2)
// Space Complexity - O(M)

// Code : 

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> res = new LinkedList<>();
        
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-2 ; i++){
            
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                int lo = i+1, hi = nums.length-1 , sum = 0 - nums[i];
                
                while(lo < hi){
                    
                    if(nums[lo] + nums[hi] == sum){
                        res.add(Arrays.asList(nums[i] , nums[lo] , nums[hi]));
                        
                        while(lo < hi && nums[lo] == nums[lo+1])    lo++;
                        
                        while(lo < hi && nums[hi] == nums[hi-1])    hi--;
                        
                        lo++;
                        hi--;
                    }
                    else if(nums[lo] + nums[hi] < sum)  lo++;
                    else    hi--;
                }
            }
        }
        return res;
        
    }
}
