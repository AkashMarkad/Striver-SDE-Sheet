// Rotate a Linked List
// Right Rotate 
// Problem Link : 1) https://leetcode.com/problems/rotate-list/
//                2) https://www.codingninjas.com/codestudio/problems/920454?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

// 1->2->3->4->5 and k=2 => 4->5->1->2->3

// Approach 1: Rotate k time list i.e every time add last to the first
// Time Complexity - O(K*N)
// Space Complexity - O(1)

// Approach 2: Optimal Apparoach

// Steps : 1) Calculate length of the list
//         2) Last node connect to the head i.e make a circular list
//         3) Now find k i. k=len-(k%len)
//         4) Move curr points to head to the k steps
//         5) Now update head as curr.next and make curr.next = null
//         6) Return head

// Time Complexity - O(N) + O(N-(N%K)) i.e O(N)
// Space Complexity - O(1)

// Code :-

import java.util.* ;
import java.io.*; 
/***********************************************
    Following is the class structure of the Node class:

    class Node {
        int data;
        Node next;

        Node(int x) {
            this.data = x;
            this.next = null;
        }
    }

************************************************/

public class Solution {
    public static Node rotate(Node head, int k) {
        // Write your code here.
        
        if(head == null || head.next == null || k == 0)
            return head;
        
//         compute the length of LinkedList
        Node ptr = head;
        int len = 1;
        while(ptr.next != null){
            ptr = ptr.next;
            len++;
        }
        
//         go till that node 
        ptr.next = head;
        
        k = k % len;
        k = len -k;
        
        while(k-- > 0)    ptr = ptr.next;
        
//         make the node head and break the connection
        head = ptr.next;
        ptr.next = null;
        
        return head;
    }
}
