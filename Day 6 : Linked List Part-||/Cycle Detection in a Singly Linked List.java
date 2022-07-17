// Cycle Detection in a Singly Linked List

// Problem Link :1) https://leetcode.com/problems/linked-list-cycle/
//               4) https://practice.geeksforgeeks.org/problems/detect-loop-in-linked-list/1
//               3) https://www.codingninjas.com/codestudio/problems/628974?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0


// Approach 1: Using HashSet 
// Steps : 1) check Node present in hashSet if present then return true
//                                          else add Node in the HashSet
// If Cross the End of the List then return False

// Time Complexity- O(N)
// Space Complexity- O(N)

// Code:
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> s = new HashSet<>();
        while(head!=null){
            if(!s.contains(head)){
                s.add(head);
            }
            else{
                return true;
            }
            head=head.next;
        }
        return false;
    }
}

// Approach 2: Optimal Approach
// Use Slow and Fast Pointer 
// Algorithm says that if cycle is present in List then slow and fast pointer meet at same point while traversing the slow by one step and fast by two step

// Steps:-
// 1) Intialize slow and fast to the head
// 2) Move fast pointer by two step and slow by one step 
//       if Both are on same Node return True
//       else fast cross the end of list then return False

// Time Complexity - O(N)
// Space Complexity - O(1)

// Code : 


/*  

    Following is the representation of the Singly Linked List node

    class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

*/

public class Solution {
    
    public static boolean detectCycle(Node<Integer> head) {
        //Your code goes here
        
        if(head == null || head.next == null)
            return false;
        
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast)
                return true;
        }
        return false;
    }
}
