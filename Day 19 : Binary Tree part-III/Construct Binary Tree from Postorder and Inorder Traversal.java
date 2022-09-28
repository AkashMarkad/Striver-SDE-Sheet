// Construct Binary Tree from Postorder and Inorder Traversal

// Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
// Output: [3,9,20,null,null,15,7]

// Approach 1: Same as the inorder and preorder but here is given the postorder so the root will be at the end
// so maintain the elements according to it and it to ans

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
    
    private TreeNode arrayToTree(int[] postorder , int postStart , int postEnd , int[] inorder , int inStart , int inEnd , Map<Integer , Integer> hm){
        
        if(postStart > postEnd || inStart > inEnd )   return null;
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        
        int inRoot = hm.get(postorder[postEnd]);
        int numsLeft = inRoot - inStart;
        
        root.left = arrayToTree(postorder , postStart, postStart+numsLeft-1,inorder, inStart,inRoot-1,hm);
        root.right = arrayToTree(postorder , postStart+numsLeft, postEnd-1,inorder,inRoot+1,inEnd,hm);
        
        return root;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(inorder == null || postorder == null || inorder.length != postorder.length)  return null;
    
        Map<Integer,Integer> hm = new HashMap<>();
        int i=0;
        for(int num : inorder){
            hm.put(num , i);
            i++;
        }
        
        TreeNode root = arrayToTree(postorder , 0 , postorder.length-1,inorder,0,inorder.length-1,hm);
        
        return root;
    }
    
    
}
