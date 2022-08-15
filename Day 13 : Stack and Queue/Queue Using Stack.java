// Queue Using Stack 

// Code 1:
// Optimised

class MyQueue {

    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();
    
    public MyQueue() {
        
    }
    
    public void push(int x) {
        while(!st1.isEmpty())
        {
            st2.add(st1.pop());
        }
        st1.add(x);
        
        while(!st2.isEmpty()){
            st1.add(st2.pop());
        }
    }
    
    public int pop() {
        
        return st1.isEmpty()? -1: st1.pop();
        
    }
    
    public int peek() {
        
        return st1.isEmpty()? -1: st1.peek();
        
    }
    
    public boolean empty() {
        
        return st1.isEmpty();
        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

// Code 2: 

import java.util.*;
public class Queue {
    // Define the data members(if any) here.
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();
    Queue() {
        // Initialize your data structure here.
    }

    void enQueue(int val) {
        // Implement the enqueue() function.
        st1.push(val);
    }

    int deQueue() {
        // Implement the dequeue() function.
        if(st2.isEmpty()){
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
            return st2.isEmpty()?-1:st2.pop();
        }
        return st2.isEmpty()?-1:st2.pop();
    }

    int peek() {
        // Implement the peek() function here.
        if(st2.isEmpty()){
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }
        return st2.isEmpty()?-1:st2.peek();
    }

    boolean isEmpty() {
        // Implement the isEmpty() function here.
        return st1.isEmpty()&&st2.isEmpty();
    }
}
