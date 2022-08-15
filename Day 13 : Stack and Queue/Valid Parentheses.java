// Valid Parentheses

// Time Complexity - O(n)
// Space Complexity - O(n)

// Code : 

// LeetCode : https://leetcode.com/problems/valid-parentheses/

class Solution {
    public boolean isValid(String s) {
        
        int n = s.length();
        
        if(n%2!=0)
            return false;
        
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<n;i++){
            
            char ch = s.charAt(i);
            
            if(ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
                continue;
            }
                
            if(st.isEmpty())    return false;
            
            char bracket = st.peek();
            
            if (bracket == '(' && ch== ')' || bracket == '{' && ch== '}' || bracket == '[' && ch== ']')
                st.pop();
            else 
                return false;
            
        }
        
        return st.isEmpty();
    }
}

// Coding Studio : https://www.codingninjas.com/codestudio/problems/795104?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

import java.util.*;

public class Solution {
    public static boolean isValidParenthesis(String expression) {
        // Write your code here.
        int n = expression.length();
        
        if(n %2 != 0)
            return false;
        
        Stack<Integer> st= new Stack<>();
        
        for(int i=0;i<n;i++){
            char ch = expression.charAt(i);
            int value = 0;
            
            if(ch=='(')    value = 1;
            else if(ch==')')    value = -1;
            else if(ch=='[')    value = 2;
            else if(ch==']')    value = -2;
            else if(ch=='{')    value = 3;
            else if(ch=='}')    value = -3;
            
            if((i==n-1) && (st.peek() < 0))
                return false;
            
            if(!st.isEmpty())
            {
                if(st.peek()+value==0)
                {
                    st.pop();
                    continue;
                }
            }
            
            st.push(value);
        }  
     
        return st.isEmpty();
    }
}
