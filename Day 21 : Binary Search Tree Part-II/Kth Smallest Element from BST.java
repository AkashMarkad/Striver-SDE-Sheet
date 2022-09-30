// Kth Smallest Element from BST 

// Approach 1: Do inorder travrsal and maintain the counter
//             if(count==k) return element

// Time Complexity - O(n)
// Space Complexity - O(n)


// Apparoch 2: Morris Order Travrsal 
// Inorder and Iterative using stack take the space complexity so we choose the morris order travrsal


// Time Complexity - O(n)
// Space Complexity - O(1)


// code:

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    

    public int kthSmallest(TreeNode root, int k) {
       TreeNode node = root;
       int i=0;
       while(node != null){
           if(node.left == null){
               i++;
               if(i==k){
                   return node.val;
               }
               node = node.right;
           }
           else{
               TreeNode prev = node.left;
               while(prev.right != null && prev.right != node){
                   prev = prev.right;
               }

               if(prev.right == null){
                   prev.right = node;
                   node = node.left;
               }else{
                   i++;
                   if(i==k){
                       return node.val;
                   }
                   prev.right = null;
                   node = node.right;
               }
           }
       }
       return -1;
    }
}
