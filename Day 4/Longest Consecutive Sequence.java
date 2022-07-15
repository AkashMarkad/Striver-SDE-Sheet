// Find the longest size having consecutive sequence
// Problem Link : https://leetcode.com/problems/longest-consecutive-sequence/
// Approach 1: Sort the array and using counter find the max count;
// Time Complexity - o(NlogN + N)
// Space Complexity - O(1)

// Approach 2: Using HashSet 
// Algorithm :- 1) Add all elements to the HashSet
//              2) Check whether ele-1 exist or not if exist then skip and move to next elements
//              3) if not exists then use while loop and check ele++ is exist and count the elements 
//              4) Return the max Count

// Time Complexity :- O(3N)
// Space Complexity :- O(N)

// Code :

class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> hm = new HashSet<>();
        
        for(int num : nums)
        {
            hm.add(num);
        }
        
        int longestStreak = 0;
        
        for(int num : hm)
        {
            if(!hm.contains(num-1))
            {
                int currentNum = num;
                int currentStreak = 1;
                
                while(hm.contains(currentNum+1))
                {
                    currentNum += 1;
                    currentStreak += 1;
                }
                
                longestStreak = Math.max(longestStreak , currentStreak);
            }
        }
        
        return longestStreak;
    }
}
