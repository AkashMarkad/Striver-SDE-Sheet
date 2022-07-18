// Detect the Cycle of Linkked List-II
// Problem Link : 1) https://leetcode.com/problems/linked-list-cycle-ii/
//                2) https://www.codingninjas.com/codestudio/problems/1112628?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

// Approach 1: Using HashSet 
// Start traversing the LinkedList if the node is present in hashset then return Node else add the node to the HashSet
// if Node cross the end then return null

// Time Complexity - O(N)
// Space Complexity- O(N)

// Approach 2: Optimal Approach 
// Algorithm Divide in two Steps 1) Find the Collision point by using slow and fast pointer 
//                               2) Now assign the entry pointer to the head and move entry and slow by one step and check whether entry and slow are equal then return the Entry
//                               3) If fast.next == null or fast.next.next == null then return null;

// Time Complexity - O(N)
// Space Complexity - O(1)

// Code:-

/****************************************************************

    Following is the class structure of the Node class:

        class Node
		{
		    public int data;
		    public Node next;

		    Node(int data)
		    {
		        this.data = data;
		        this.next = null;
		    }
		}

*****************************************************************/

public class Solution 
{
    public static Node firstNode(Node head) 
    {
        //    Write your code here.
        
        if(head == null || head.next == null)    return null;
        
        Node entry = head;
        Node slow = head;
        Node fast = head;
        
        while(fast.next != null && fast.next.next != null){
            
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                while(entry != slow){
                    slow = slow.next;
                    entry = entry.next;
                }
                return entry;
            }
        }
        return null;
    }
}
