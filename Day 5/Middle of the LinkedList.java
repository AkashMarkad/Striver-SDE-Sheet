// Middle of the linkedList
Problem Link : https://leetcode.com/problems/middle-of-the-linked-list/

// Input 1:- 1->2->3->4->5 => 3
// Input 2: 1->2->3->4-> => 4

// Approach 1: Count the Number of Node and travrse half of that and return node
// Time Complexity - O(N + N/2);
// Space Complexity -O(1)

// Appraoch 2: Using Slow and Fast Pointer 
// Step 1: Assign slow and fast pointer to the head 
//      2: Move slow by 1 step and fast by 2 step
//      3: if fast reaches last node or cross the boundry then return the slow node

// Time Complexity - O(N/2)
// Space Complexity - (1)

// Code 

class Solution {
    public ListNode middleNode(ListNode head) {
        
        ListNode slow = head , fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
        
    }
}
