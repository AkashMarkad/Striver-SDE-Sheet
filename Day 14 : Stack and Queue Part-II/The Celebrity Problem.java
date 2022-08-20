// Celebrity Problem
// Input : n
// Output : celebrity column

// Given the Grid n*n if any index their is 1 it can be a celibrity 1 shows that they know and 0 show they don't know
// At any row all element must be zero and in column their is n-1 1's then only it would be a celebrity

// Time Complexity- O(n)
// Space Complexity- O(n)

// Code:


/*
	This is signature of helper function 'knows'.
	You should not implement it, or speculate about its implementation.

	boolean knows(int A, int B); 
	Function 'knows(A, B)' will returns "true" if the person having
	id 'A' know the person having id 'B' in the party, "false" otherwise.
	Use it as Runner.knows(A, B);
*/
import java.util.*;
public class Solution {
	public static int findCelebrity(int n) {
        // Write your code here.
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            st.push(i);
        }
        
        while(st.size() >=2){
            int i=st.pop();
            int j=st.pop();
            
            if(Runner.knows(i,j)){
                st.push(j);
            }else{
                st.push(i);
            }
        }
        
        int pot = st.pop();
        
        for(int i=0;i<n;i++){
            if(i!=pot){
                if(!Runner.knows(i,pot) || Runner.knows(pot,i))
                    return -1;
            }
        }
        
        return pot;
    }
}
