// Copy List with Random Pointer
// i.e List having two pointer one is next and other is Random
// So Random will point anywhere we need to create a same copy of the linkedList and return it 

// Problem Link : 1) https://leetcode.com/problems/copy-list-with-random-pointer/
//                2) https://www.codingninjas.com/codestudio/problems/873376?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

// Approach 1: use HashMap
// steps 1: 1) Store all the Node and corrssponding new node i.e copy in the hashMap 
//          2) While second time traversing get the Node from map and asign the next and random of the original node to the copy node

// Time Complexity - o(2N)
// Space Complexity - O(N)

// Code :

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        
        HashMap<Node, Node> hm = new HashMap<>();
        Node iter = head;
        while(iter!=null){
            Node copy = new Node(iter.val);
            hm.put(iter, copy);
            iter = iter.next;
        }
        iter = head;
        while(iter!=null){
           Node copy = hm.get(iter);
            copy.next = iter.next;
            copy.random = iter.random;
            iter = iter.next;
        }
        return hm.get(head);
       
    }
}


// Code : 

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        Node iter = head , front = head;
        while(iter != null){
            front = iter.next;
            Node copy = new Node(iter.val);
            iter.next = copy;
            copy.next = front;
            iter = front;
        }
        
        iter = head;
        while(iter != null){
            if(iter.random != null){
                iter.next.random = iter.random.next;
                
            }
            iter = iter.next.next;
            
        }
        
        iter = head;
        Node dummy = new Node(0);
        Node copy = dummy;
        while(iter != null){
            front = iter.next.next;
            copy.next = iter.next;
            iter.next = front;
            copy = copy.next;
            iter = iter.next;
        }
        
        return dummy.next;
    }
}
