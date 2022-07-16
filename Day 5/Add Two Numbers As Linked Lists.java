// Add Two Numbers As Linked Lists
// Problem Link : https://leetcode.com/problems/add-two-numbers/

// E.g 2->4->3
//   + 5->6->4
//   ----------
//     7->0->8
// Tip:- Alraedy Numbers are stored in reverse order so no need to reverse the linkedlist

// Approach : Optimal Approach (Only one Approach)
// steps 1) create a new Node dummy and create newNode temp  assign temp to the dummy
//       2) intialize carry to the 0
//       3) until l1 !=null || l2 !=null || carry==1 
//             initialize sum=0
//             if l1!=null then add l1.data to the sum and l1=l1.next
//             if l2!=null then add l2.data to the sum and l2=l2.next
//             add carry to the sum
//             carry = sum/10
//             create newNode of sum%10
//             assign temp.next = newNode
//             temp = temp.next
//      4) Return dummy.next

Time Complexity :- O(Math.max(Length(l1),Length(l2)))
Space Complexity :- O(Math.max(Length(l1),Length(l2))+1)

// Code:
  
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        int carry = 0;
        while(l1!=null || l2!=null || carry == 1){
            int sum = 0;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            
            sum += carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            temp.next = node;
            temp = temp.next;
        }
        return dummy.next;
        
    }
}
