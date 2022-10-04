// Kth largest element in the unsorted array

// Approach 1: Sort and return

// Approach 2: Using PriorityQueue

// Code:

class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        // Approach 1 : Sort
        // Time Complexity --> O(NlogN)
        
            
        // Arrays.sort(nums);
        // return nums[nums.length-k];
        
        // ---------------------------------------------------------------------------------
        
        // Approach 2 : Min Heap (Priority Queue)
           
        // Time Complexity --> O(NlogK)
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        return pq.peek();
        
    }
}

// Approach 3: Optimal Approach - Quick Select 
// Quicke Select is based on the Quick Sort 
// Randomized pivot selection techinique to optimize this approach
