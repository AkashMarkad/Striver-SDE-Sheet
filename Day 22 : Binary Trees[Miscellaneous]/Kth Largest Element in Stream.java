// Kth Largest element in stream

// Input : Given a continuous elements of data stream 
// output: return kth largest element at any time

// Approach : Heap
// We Use PriorityQueue Data Structure

// if pq.size()>size then pq.poll()

// return pq.peek()

// Code:

class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int size;

    public KthLargest(int k, int[] nums) {
        size = k;
        for(int num : nums){
            pq.offer(num);
            if(pq.size() > size){
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > size){
            pq.poll();
        }
        if(pq.isEmpty())    return -1;
        return (int) (pq.peek());
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

// Coding Studio code :

import java.util.* ;
import java.io.*; 
public class Kthlargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int size ;
    Kthlargest(int k, int[] arr) {
        // Write your code here.
        size = k;
        for(int num : arr){
            pq.offer(num);
            if(pq.size() > size){
                pq.poll();
            }
        }
    }

    void add(int num) {
        // Write your code here.
        pq.offer(num);
        if(pq.size() > size)
            pq.poll();
    }

    int getKthLargest() {
        // Write your code here.
        if(pq.isEmpty())    return -1;
        return pq.peek();
    }
}
