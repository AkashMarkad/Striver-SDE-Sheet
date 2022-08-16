// Next Smaller Element 
// Input : array 
// Output : Next smaller element for each element

// Approach 1: Brute force
// Check for the each element which is the smaller element

// Approach 2: Use Stack

// Time Complexity - O(2n)
// Space Complexity - O(n)

// Code:

import java.util.*;
import java.io.*;

public class Solution{
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        // Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        
        for(int i =0;i<n;i++)
            ans.add(0);
        
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr.get(i) <= st.peek()){
                st.pop();
            }    
            
            if(i<n){
                if(!st.isEmpty()){
                    ans.set(i, st.peek());
                }else{
                    ans.set(i, -1);
                }
            }
            
            st.push(arr.get(i));
        }
        
        return ans;
    }
}
