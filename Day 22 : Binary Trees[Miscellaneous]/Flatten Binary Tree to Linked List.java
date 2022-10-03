// Flatten Binary Tree to Linked List

// Convert Binary Tree into Linked List

// Problem Link : 1) LeetCode : https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
//                2) CodingStudio : https://www.codingninjas.com/codestudio/problems/893106?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website


// Approach 1 : RecurSive 

// Time Complexity : O(N)
// Space Complexity : O(N)

// Code :

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
    
    TreeNode pre = null;
    public void flatten(TreeNode root) {
        
        if(root==null)
            return;
        
        flatten(root.right);    //traverse till right most.
        flatten(root.left);     //go to left of right most
        root.left=null;         //Set left as null
        root.right=pre;         //set right to previously traversed node
        pre=root;               //set prev to current node.
    }
}
        

// Approach 2 : Optimal 

// Time Complexity : O(N)
// Space Complexity : O(1)


// LeetCode Code : 

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
  
    public void flatten(TreeNode root) {
        
        TreeNode curr = root;
        while(curr != null){
            if(curr.left != null){
                TreeNode pred = curr.left;
                while(pred.right != null){
                    pred = pred.right;
                }
                pred.right = curr.right;
                curr.right = curr.left;
            }
            curr = curr.right;
        }
       
        curr = root;
        while(curr != null){
            curr.left = null;
            curr = curr.right;
        }
    }
}
