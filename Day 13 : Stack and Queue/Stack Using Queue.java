// Stack Using Queue

// Code : 

// LeetCode : https://leetcode.com/problems/implement-stack-using-queues/

class MyStack {
    private Queue<Integer> queue = new LinkedList<>();
    
    public MyStack() {
        
        
    }
    
    public void push(int x) {
        queue.add(x);
        for(int i=1;i<queue.size();i++)
        {
            queue.add(queue.remove());
        }
    }
    
    public int pop() {
        
        return queue.remove();
    }
    
    public int top() {
        
        return queue.peek();
    }
    
    public boolean empty() {
        
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

// Coding Studio : https://www.codingninjas.com/codestudio/problems/795152?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

import java.util.*;

public class Stack {

    // Define the data members.
    Queue<Integer> q1;
    Queue<Integer> q2;

    public Stack() {
        // Implement the Constructor.
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }



    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() { 
        // Implement the getSize() function.
        return q1.size();
    }

    public boolean isEmpty() {
        // Implement the isEmpty() function.
        return q1.isEmpty();
        
    }

    public void push(int element) {
        // Implement the push(element) function.
        while(!q1.isEmpty()){
            q2.offer(q1.poll());
        }
        q1.offer(element);
        
        while(!q2.isEmpty()){
            q1.offer(q2.poll());
        }
    }

    public int pop() {
        // Implement the pop() function.
        return  !q1.isEmpty() ? q1.poll() : -1;
    }

    public int top() {
        // Implement the top() function.
        return q1.isEmpty() ? -1 : q1.peek();
    }
}

