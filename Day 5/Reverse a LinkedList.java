// Reverse a linkedList 
// Problem Link : https://leetcode.com/problems/reverse-linked-list/

// 1->2->3->4->5  =>  5->4->3->2->1
// Approach 1:
// Time Complexity - O(N)
// Space Complexity - O(1)

// Code

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        
        if(head==null || head.next==null)
        {
            return head;
        }
        
        ListNode dummyNode= null;
        
        while(head!=null)
        {
            ListNode nextNode = head.next;
            head.next = dummyNode;
            dummyNode = head;
            head = nextNode;
        }
        
        return dummyNode;
    }
}
