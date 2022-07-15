// Two Sum Problem 
//Problem Link : https://leetcode.com/problems/two-sum/

// As per Leetcode only sigle pair of element is exist in an array
// For eg. [2,7,9,8,4] and target = 9 so in the array only elemnts at index 0 and 1 can be considered to form a sum

// Approach 1: Brute Force
// Using Nested loop we can traverse array and accordingly we can found the index of the elements 
// Time Complexity:- O(n*n)
// Space Complexity:- O(n)


// Approach 2: Using HashMap
// Use HashMap store the array element and try to find or check element target-nums[i] is exist or not

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer , Integer> map = new HashMap<>();
        
        for(int i=0 ; i<nums.length;i++)
        {
            if(map.containsKey(target-nums[i]))
            {
                
                return new int[]{map.get(target - nums[i]) , i};
            }
            map.put(nums[i],i);
        }
        
        return new int[]{-1,-1};
        
    }
}

// Time Complexity:- O(n)
// Space Complexity:- O(n)
