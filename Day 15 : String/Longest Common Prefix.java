// Longest Common Prefix

// Approach 1: 

// Time Complexity - O(minLength*n)
// Space Complexity - O(1)

// Code:
// 1
public class Solution {
	public static String longestCommonPrefix(String[] arr, int n) {
		// Write your code here
        String min=arr[0];
        for(String s: arr){
            if(s.length()<min.length()){
                min = s;
            }
        }
        int j=0;
        int i=0;
        int k=0;
        for(i=0;i<min.length();i++){
            for(j=0;j<arr.length-1;j++){
                if(arr[j].charAt(i)!=arr[j+1].charAt(i)){
                    k=1;
                    break;
                }
            }
            if(k==1) break;
        }
        return min.substring(0,i);
	}

}

// 2
class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        int n = strs.length;
        int min = Integer.MAX_VALUE;
        
        
        if(n==1){
            return strs[0];
        }
        
        for(int i=0;i<n-1;i++){
            
            int count = 0;
            String first = strs[i];
            String second = strs[i+1];
            int j = 0;
            int k = 0;
            
            while(j < first.length() && k < second.length()){
                
                if(first.charAt(j) == second.charAt(k))
                    count++;
                else
                    break;
                
                j++;
                k++;
            }
            
            min = Math.min(min , count);
            
        }
        
        String ans = "";
        if(min > 0 && min != Integer.MAX_VALUE){
            for(int i=0;i<n;i++){
                if(strs[i].length() >= min){
                    for(int j=0;j<min;j++){
                        ans += strs[i].charAt(j);
                    }
                    return ans;
                }
            }
        }
        
        return ans;
    }
}

// Approach 2: Binary Search

// Time Complexity - O(minLength*logn)
// Space Complexity - O(1)

// Code:

class Solution {
    
    public boolean isCommonPrefix(String[] strs , int mid){
        
        String str = strs[0].substring(0,mid);
        for(int i=0;i<strs.length;i++){
            if(!strs[i].startsWith(str))
                return false;
        }
        return true;
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)    return "";
        
        int minL = Integer.MAX_VALUE;
        
        for(String s : strs){
            if(minL > s.length())
                minL = s.length();
        }
        
        int low = 0;
        int high = minL;
        while(low <= high){
         
            int mid = (low+high) >> 1;
            
            if(isCommonPrefix(strs , mid))
                low = mid+1;
            else
                high = mid-1;
        }
        
        return strs[0].substring(0,(low+high)/2);
    }
}
