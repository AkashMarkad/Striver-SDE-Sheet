// Sort the Stack 

// Approach 1 : Sorting 
// Time Complexity -->O(N) + O(NlogN) + O(N)
// Space Complexity --> O(N)

import java.util.*;

public class Solution {

	public static void sortStack(Stack<Integer> stack) {
		// Write your code here.
        
        ArrayList<Integer> al = new ArrayList<>();
        while(!stack.isEmpty()){
            al.add(stack.pop());
        }
        
        Collections.sort(al);
        
        for(int i =0 ;i<al.size();i++){
            stack.push(al.get(i));
        }
        
    }

}

// Approach 2 : Using Stack
// Time Complexity --> O(N) + O(N)

import java.util.*;

public class Solution {

	public static void sortStack(Stack<Integer> stack) {
		// Write your code here
            
        Stack<Integer> st = new Stack<>();
        while(!stack.isEmpty()){
            int temp = stack.pop();
            while(!st.isEmpty() && st.peek() < temp){
                stack.push(st.pop());                
            }
            st.push(temp);
        }
        
        while(!st.isEmpty())
            stack.push(st.pop());
        
    }

}

// Approach 3 : Using PriorityQueue
// Time Complexity --> O(N) + O(N)

import java.util.*;

public class Solution {

	public static void sortStack(Stack<Integer> stack) {
		// Write your code here.
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(!stack.isEmpty())
            pq.add(stack.pop());
        
        while(!pq.isEmpty())
            stack.push(pq.poll());
    }

}
