// Longest Palindromic Substring 
// Input: s = "babad"
// Output: "bab"
// Explanation: "aba" is also a valid answer.

// Approach 1: Check for even and odd index
// Time Complexity - O(n*n)
// Space Complexity - O(1)

// Problem LeetCode : https://leetcode.com/problems/longest-palindromic-substring/

// Code:

class Solution {
    public String longestPalindrome(String s) {
        
        String ans = "";
        for(int i=0;i<s.length();i++){
            String temp = getPalindrome(s,i,i);
            if(ans.length()<temp.length()){
                ans = temp;
            }
            
            temp = getPalindrome(s, i, i+1);
            if(ans.length()<temp.length()){
                ans = temp;
            }
        }
        return ans;
    }
    
    public String getPalindrome(String s, int begin, int end){
        while(begin>=0 && end<=s.length()-1 && s.charAt(begin)==s.charAt(end)){
            begin--;
            end++;
        }
        return s.substring(begin+1,end);
    }
    
//     abccba
//     abcba
}
