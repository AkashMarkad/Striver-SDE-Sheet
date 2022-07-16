// Merge Two Sorted Lists
// Problem Link : https://leetcode.com/problems/merge-two-sorted-lists/

// 1->2->4 and 1->3->4  =>  1->1->2->3->4->4

// Approach 1: Using Extra Space 
// Create one dummy Node i. newNode 
// newNode.next = list1.val<list2.val? list1 : list2;
// Add reamining Node

// Time Complexity- O(m+n)
// Space Complexity- O(m+n)

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
               
        ListNode node = new ListNode(0);
        ListNode head = node;
        
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                node.next = l1;
                l1 = l1.next;
            }
            else{
                node.next = l2;
                l2 = l2.next;
            }
            
            node = node.next;
        }
        
        while(l1 != null){
            node.next = l1;
            l1 = l1.next;
            node = node.next;
        }
        while(l2 != null){
            node.next = l2;
            l2 = l2.next;
            node = node.next;
        }
        return head.next;
    }
}

//Approach 2 : Without using extra space 
//Time Complexity : O(m+n)
//Space Complexity : O(1)

//Code :

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
     
        if(l1 == null)  return l2;
        if(l2 == null)  return l1;
        if(l1.val > l2.val){
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        ListNode res = l1;
        while(l1 != null && l2 != null){
            ListNode tmp = null;
            while(l1 != null && l1.val <= l2.val){
                tmp = l1;
                l1 = l1.next;
            }
            tmp.next = l2;
            
            //Swap
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
                
        }
        return res;
        
    }
}
