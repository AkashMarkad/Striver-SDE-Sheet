// Palindrome Linked List
// Problem Link : 1) https://leetcode.com/problems/palindrome-linked-list/
//                2) https://www.codingninjas.com/codestudio/problems/799352?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

// Approach 1: 
// steps : 1) Take any one Array Or ArrayList
//         2) Insert All Nodes of Linked List into above DS
//         3) Then Check for Palindrome 
//         4) Return answer

// Time Complexity :- O(N) + O(N)
// Space Complexity :- O(N)
   
// Approach 2:
// steps : 1) Uisng slow and fast pointer find the middle of the linkedlist
//         2) Now reverse the LinkedList from slow.next 
//         3) Move the head and the and slow and check whether both are equals or not if not equal then return false
//         4) if slow cross the end then return true

// Time Complexity :- O(n/2) + O(n/2) + O(n/2)
// Space Complexity :- O(1)

// Code :


/****************************************************************

    Following is the class structure of the LinkedListNode class:
	
	class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;

    	public LinkedListNode(T data) {
        	this.data = data;
    	}
	}

*****************************************************************/

public class Solution {

	public static boolean isPalindrome(LinkedListNode<Integer> head) {
		// Write your code here!
        if(head == null || head.next == null)   return true;
        
        LinkedListNode<Integer> dummy = head ;
        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;
        
        // Find the Middle of Liked List 
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // Reverse the right half
        slow.next = reverseList(slow.next);
        
        // Move slow to the right half
        slow = slow.next;
        
        // Check for right half and left half equal or not 
        while(slow != null){
            if(!slow.data.equals(dummy.data))
                return false;
            dummy = dummy.next;
            slow = slow.next;
        }
        return true;
        
    }
    
    public static LinkedListNode<Integer> reverseList(LinkedListNode<Integer> head){
        LinkedListNode<Integer> pre = null;
        LinkedListNode<Integer> next = null;
        
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
