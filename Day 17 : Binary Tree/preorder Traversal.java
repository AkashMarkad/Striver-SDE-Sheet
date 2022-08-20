// Preorder Traversal 
// Input: root = [1,null,2,3]
// Output: [1,2,3]

// Problem LeetCode : https://leetcode.com/problems/binary-tree-preorder-traversal/

// Approach 1: Recusrsive
// Inorder-> Root Left Right

// Time Complexity - O(n)
// Space Complexity - O(n)

// Code:

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
    
    public void preOrder(TreeNode root , List<Integer> ans){
    
        if(root==null)  return;
        
        ans.add(root.val);
        preOrder(root.left , ans);
        preOrder(root.right , ans);
        
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();
        
        preOrder(root , ans);
        
        return ans;
        
    }
}
