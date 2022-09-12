// Level Order Traversal

// Problem Link -      (LeetCode)  https://leetcode.com/problems/binary-tree-level-order-traversal/ 
//                (Coding Studio)  https://www.codingninjas.com/codestudio/problems/796002?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0


// Code - (LeetCode)

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root==null)  return ans;
        
        Queue<TreeNode> q = new LinkedList<>(); 
        
        q.offer(root);
        
        while(!q.isEmpty()){
            
            int levelSize = q.size();
            List<Integer> subList = new ArrayList<>();
            
            for(int i=0;i<levelSize;i++){
                if(q.peek().left != null)   q.offer(q.peek().left);
                if(q.peek().right != null)  q.offer(q.peek().right);
                subList.add(q.poll().val);
            }
            
            ans.add(subList);
        }
        
        return ans;
    }
}

// Code - (Coding Studio)

/*

	Following is the structure used to represent the Binary Tree Node

	class BinaryTreeNode<T> {
		T val;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

*/

import java.util.*;

public class Solution {

  public static ArrayList<Integer> getLevelOrder(BinaryTreeNode root) {
    //Your code goes here
      
      ArrayList<Integer> ans = new ArrayList<>();
      
      if(root==null)    return ans;
      
      Queue<BinaryTreeNode> q = new LinkedList<>();
      
      q.add(root);
      
      while(!q.isEmpty()){
          int size = q.size();
          for(int i=0;i<size;i++){
              BinaryTreeNode node = q.poll();
              if(node.left!=null)    q.offer(node.left);
              if(node.right!=null)    q.offer(node.right);
              ans.add(node.val);
          }
      }
      return ans;
  }

}
  
 
