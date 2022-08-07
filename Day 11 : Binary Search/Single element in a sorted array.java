/ Single Element in a Sorted Array
// Input: arr = [1,1,2,3,3,4,4,8,8]
// Output: 2

// Approach 1:
// Use xor operation on each elements
// Return the last remaining xor after performing the xor 

// Time Complexity- O(N)
// Space Complexity- O(1)

// Code:

public class Solution 
{
    public static int uniqueElement(ArrayList<Integer> nums) 
    {
        //    Write your code here.

        int n = nums.size();
        int x=0;
        for(int i=0;i<n;i++){
            x = x^nums.get(i);
        }
        return x;
    }
}

// Approach 2 : Binary Search 
// Use Binary Search on array and according find we are present on left half or right half
// Do the binary search

// Time Complexity - O(logN)
// Space Complexity - O(1)

// Code:

class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        // Approach 1: Naive 
        
        // Time Complexity --> O(N)
        // Space Complexity --> O(1)   
        
//         if(nums.length==1)
//             return nums[0];
        
//         for(int i=0;i<nums.length;i++){
            
//             if(i==0){
//                 if(nums[i] != nums[i+1])
//                     return nums[i];
//             }
//             if(i <nums.length-1 && i > 0 && nums[i] !=nums[i+1] && nums[i] != nums[i-1])
//                 return nums[i];
            
//             if(i==nums.length-1)
//             {
//                 if(nums[i] != nums[i]-1)
//                     return nums[i];
//             }
//         }
        
//         return -1;
        // ---------------------------------------------------------------------------------------------------------
        
        // Approach 2 : XOR
        
        // int n = nums.length;
        // int x = 0;
        // for(int i=0;i<n;i++){
        //     x = x^nums[i];
        // }
        // return x;
        
        // ---------------------------------------------------------------------------------------------------------
        
        // Approach 2: Binary Search 
        
        int low = 0;
        int high = nums.length-2;
        
        while(low <= high){
            int mid = (low+high) >> 1;
            if(nums[mid]==nums[mid^1]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return nums[low];
        
        
    }
}
