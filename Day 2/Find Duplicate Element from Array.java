LeetCode Problem Link : https://leetcode.com/problems/find-the-duplicate-number/

// There is only one element in array
// First Approach -1) Sort the Array 
//                 2) And find arr[i] == arr[i+1]
//                 3) return array element
// Time Complexity is O(nlogn + n)
// Space Complexity is O(1)

// Second Appraoch - Use Hashing to reduce time coplexity
// Time Complexity is O(n)
// Space Coplexity is O(n)

// Third Aprroach is Optimal Approach Use Slow and Fast Pointer
// Intially slow and fast assign to the first element 
// slow will move one step and fast will move the two steps 
// It's found a cycle then we need to one more time traverse by assign fast to the initaial element again
// Time complexity is O(n)

class Solution {
    public int findDuplicate(int[] nums) {
        
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i=0;i<nums.length;i++)
        {
            if(hs.contains(nums[i]))
            {
                return nums[i];
            }
            else
            {
                hs.add(nums[i]);
            }
        }
        
        return -1;
        
    }
}
