// Longest Substring Without Repeating Characters
// Problem Link : https://leetcode.com/problems/longest-substring-without-repeating-characters/

// Approach 1: Brute Force 
// using two loops check for each longest unique string
// Time Complexity : O(N*N)
// Space Complexity : o(N)

// Appraoch 2: Use ArrayList (optimal Approach)
// use HashSet to store and use left and right 
// Intiltially left and right at 0
// right will move whenever repeat character is not present 
// if repeat character is arrive then remove element where left is present
// return maxLength 
// Time Complexity - O(N) + O(N) = O(2N)
// Space Complexity - O(N)

// Code

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        ArrayList<Character> hs = new ArrayList<>();
        
        int left=0;
        int right=0;
        int max=0;
        while(right<s.length()){
            if(hs.contains(s.charAt(right))){
                hs.remove(left);
            }
            else{
                hs.add(s.charAt(right));
                max = Math.max(max, hs.size());
                right++;
            }
            // System.out.println(hs);
            
        }
        return max;
        
    }
}

// Appraoch 3: Use hashset (Better Approach)
// use HashSet to store and use left and right 
// Intiltially left and right at 0
// right will move whenever repeat character is not present 
// if repeat character is arrive then point left to right +1
// return maxLength 
// Time Complexity - O(N)
// Space Complexity - O(N)

// Code :

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character , Integer> hm = new HashMap<>();
        
        int left = 0 , right = 0;
        int len = 0;
        while(right < s.length()){
            
            if(hm.containsKey(s.charAt(right))){
                left = Math.max(left , hm.get(s.charAt(right))+1);
            }
            
            hm.put(s.charAt(right) , right);
            len = Math.max(len , right-left+1);
            right++;
        }
        return len;
        
    }
}


