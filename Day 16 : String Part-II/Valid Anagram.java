// Check for Anagarms
// Input: s="abcd", t="dcab" 
// Output: true

// Approach 1: using XOR
// Time Complexity - O(n)
// Space Complexity - O(1)

// Code:

// Using ArrayList

class Solution {
    public boolean isAnagram(String s, String t) {
        
        ArrayList<Character> al = new ArrayList<>();
        
        if(s.length() != t.length())
            return false;
        
        for(int i = 0;i<s.length();i++){
            al.add(s.charAt(i));
        }
            
        // System.out.println(al);
        
        for(int i = 0;i<t.length();i++){
            if(al.contains(t.charAt(i))){
                al.remove(new Character(t.charAt(i)));
            }
            else{
                return false;
            }
        }
        
        if(al.size() != 0){
            return false;
        }
        
        return true;
    }
}

// Approach 2 : Using Sorting

// Time Complexity : O(2*NlogN)
//   Space Complexity : O(2N)

class Solution {
    public boolean isAnagram(String s, String t) {
         
        char[] sCharArr = s.toCharArray();
        char[] tCharArr = t.toCharArray();

        Arrays.sort(sCharArr);
        Arrays.sort(tCharArr);
        return Arrays.equals(tCharArr, sCharArr);
    }
}

// Approach 3 : Using 2 Arrays without sorting 


// Time Complexity : O(N) + O(N) + O(26) = O(N)
//   Space Complexity : O(2N) 

class Solution {
    public boolean isAnagram(String s, String t) {
         
       // create two empty arrays count number of offset for each char in the string array (from letter 'a')
        int[] fs = new int[26];
        int[] ft = new int[26];
        
        //any char inside of s.toCharArray() count++
        for(char ch : s.toCharArray())
            fs[ch-'a']++;
        
        // same here
        for(char ch : t.toCharArray())
            ft[ch-'a']++;
        
        for(int i=0;i<26;i++){
            
            //compare the two arrays char by char if any not equal -> false
            if(fs[i] != ft[i])
                return false;
        }
        return true;
    }
}

// Approach 4: using XOR
// Time Complexity - O(N)
// Space Complexity - O(1)

// Code:

class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length())    return false;
        
        int res1 = 0 , res2 = 0;
        
        for(int i=0;i<s.length();i++){
            res1 ^= ((1<<(s.charAt(i)-'a'+1))^(1<<(t.charAt(i)-'a'+1)));
            res2 += ((1<<(s.charAt(i)-'a'+1))-(1<<(t.charAt(i)-'a'+1)));
        }
        
        return res1==0 && res2==0;
    }
}
