// Find Median from Data Stream
// Input:
// ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
// [[], [1], [2], [], [3], []]
// Output
// [null, null, null, 1.5, null, 2.0]

// Approach 1: MinHeap and MaxHeap
// We Use PriorityQueue to find the medians

// carry boolean for checking the index is even ord odd

// LeetCode Hard
// Code:

class MedianFinder {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || maxHeap.peek() >= num){
            maxHeap.add(num);
        }
        else{
            minHeap.add(num);
        }

        if(maxHeap.size() > minHeap.size()+1){
            minHeap.add(maxHeap.poll());
        }
        else if(maxHeap.size() < minHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        
        if(maxHeap.size() == minHeap.size()){
            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        }

        return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

// CodingStudio Code 

import java.util.*;

public class Solution {
    public static int[] findMedian(int[] arr, int n) {
        // Write your code here.
        int[] ans = new int[n];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        boolean even = true;
        int k=0;
        for(int num : arr){
            if(even){
                minHeap.add(num);
                maxHeap.add(minHeap.poll());
                ans[k++] = maxHeap.peek();
            }
            else{
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
                ans[k++] = (maxHeap.peek() + minHeap.peek())/2;
            }
            even = !even;
        }
        return ans;
    }
}
