// Stack Implementation Using Array

// Code : 

public class Stack {
    
    int top;
    int size;
    int[] arr;
    
    Stack(int capacity){
        size = capacity;
        arr = new int[size];
        top = -1;
    }
    
    void push(int num) {
        // Write your code here.
        if(top!=size){
            top++;
            arr[top] = num;
        }
    }
    int pop() {
        // Write your code here.
        if(top!=-1){
            int value = arr[top];  
            top--;
            return value;
        }
        return -1;
        
    }
    int top() {
        // Write your code here.
        return (top!=-1) ? arr[top] : -1;
    }
    int isEmpty() {
        // Write your code here.       
        return (top==-1) ? 1 : 0; 
    }
    int isFull() {
        // Write your code here.  
        return (top==size) ? 1 : 0;
    }
}
