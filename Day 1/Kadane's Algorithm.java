
// Kedane's algorithm used to find the maximum subarray sum 
// It's most popular solution to find maximum subarray sum in linear time complexity

public class Solution {
	
	public static long maxSubarraySum(int[] nums, int n) {
		// write your code here
        
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;
        
//         if(n == 1)
//         {
//             return nums[0];
//         }
        for(int i=0;i<nums.length;i++)
        {
            curSum += nums[i];
            
            
            
            if(curSum < 0)
            {
                curSum =0;
            }
            
            if(curSum > maxSum)
            {
                maxSum = curSum;
            }
        }
        
        return (long) maxSum;
	}
