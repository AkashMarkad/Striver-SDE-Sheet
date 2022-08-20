// Inorder Traversal
// Input: root = [1,null,2,3]
// Output: [1,3,2]

// Approach 1: Recusrsive
// Inorder-> Left Root Right

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
    
    public void inorder(TreeNode root , List<Integer> ans){
        
        if(root==null) return ;
        
        inorder(root.left , ans);
        ans.add(root.val);
        inorder(root.right , ans);
        
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();
        
        inorder(root , ans);
        
        return ans;
        
    }
}
