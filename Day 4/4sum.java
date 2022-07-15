// Find the quadraple which sum is equal to given target
// Problem Link : https://leetcode.com/problems/4sum/

// Approach 1: Sort Array + Use three Pointer + Do Binary Serach on Remaining array to find the Elements
// Time Complexity :- O(N^3*logN + NlogN)
// Space Complexity :- O(1)

// Approach 2: Sort Array + Use Two Pinter + Find the Two_sum i.e Reamining Target in remaining array
// Time Complexity :- O(N^3)
// Space Complexity :- O(1)

// Code- Approach 2

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        if(nums == null || nums.length == 0)
            return res;
        
        int n = nums.length;
        
        Arrays.sort(nums);
        
        for(int i=0;i<n;i++)
        {
            for(int j= i+1; j<n;j++)
            {
                long target_2 = (long)target - (long)nums[i] - (long)nums[j];
                
                int left = j+1;
                int right = n-1;
                
                while(left < right)
                {
                    long two_sum = (long)nums[left] + (long)nums[right];
                    
                    if(two_sum < target_2)  left++;
                    
                    else if(two_sum > target_2)     right--;
                    
                    else
                    {
                        List<Integer> quad = new ArrayList<>();
                        
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[left]);
                        quad.add(nums[right]);
                        res.add(quad);
                        
                        // Processing the duplicates of number 3
                        
                        while(left < right && nums[left] == quad.get(2))
                            left++;
                        
                        // Processing the duplicates of number 4
                        
                        while(left < right && nums[right] == quad.get(3))
                            right--;
                        
                    }
                }
                
                // Processing the duplicates of number 2
                
                while(j+1 < n && nums[j+1]== nums[j])
                    j++;
                
            }
            
            // Processing the duplicates of number 1
            
            while(i+1 < n && nums[i+1] == nums[i])
                i++;
            
        }
        
        return res;
    }
}
