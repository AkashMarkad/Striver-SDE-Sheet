// Check Identical Trees 

// Approach 1: Trevrse the both trees and check the nodes and values are same or not if same return true else return false

// Time Complexity - O(n)
// Space Complexity - O(n)

// Code 

// Leetcode

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
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        if(p==null || q == null)    return (p==q);
        
        return (p.val == q.val) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}

//CodeStudio

public class Solution {
    
    public static boolean identicalTrees(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
        // Write you code here.  
        if(root1 == null || root2 == null)    return (root1==root2);
        
        return (root1.data.equals(root2.data)) && identicalTrees(root1.left , root2.left) && identicalTrees(root1.right , root2.right);
    }

}
