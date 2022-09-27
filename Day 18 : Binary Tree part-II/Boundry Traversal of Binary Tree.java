// Boundry Traversal of Binary Tree 

// Approach 1: travrse left , Leaves and then right

// 1) Left: Travrse the left if left exist go in left else go on right
//    Do not add leaf nodes

// 2) Leaves: Use any travrsing technique to travrse the nodes and check if leaf nodes then add 

// 3) Right : Go on right from root add it any dataStructure and at the end add in ans in revrse order
//   Do not add leaf nodes

// Time Complexity - O(h)+O(h)+O(n)
// Space Complexity - O(n)

// Code:

import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the Binary Tree node structure:
    
   class TreeNode {
	    int data;
	    TreeNode left;
	    TreeNode right;

	    TreeNode(int data) {
		    this.data = data;
		    this.left = null;
		    this.right = null;
	    }

    }

************************************************************/

import java.util.ArrayList;

public class Solution {
    
    public static boolean isLeaf(TreeNode node){
        if(node.left == null && node.right == null)    return true;
        return false;
    }
    public static void addLeftBoundary(TreeNode root , ArrayList<Integer> ans){
        TreeNode node = root.left;
        while(node != null){
            if(!isLeaf(node))    ans.add(node.data);
            if(node.left != null)    node = node.left;
            else    node = node.right;
        }
    }
    
    public static void addRightBoundary(TreeNode root , ArrayList<Integer> ans){
        TreeNode node = root.right;
        ArrayList<Integer> res = new ArrayList<>();
        while(node != null){
            if(!isLeaf(node))    res.add(node.data);
            if(node.right != null)    node = node.right;
            else    node = node.left;
        }
        int i;
        for(i = res.size()-1;i>=0;i--){
            ans.add(res.get(i));
        }
    }
    
    public static void addLeaves(TreeNode root , ArrayList<Integer> res){
        
        if(root == null)    return;
        if(isLeaf(root)){
            res.add(root.data);
            return;
        }
        if(root.left != null)    addLeaves(root.left,res);
        if(root.right != null)    addLeaves(root.right,res);
    }
    
	public static ArrayList<Integer> traverseBoundary(TreeNode root){
		// Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null)    return ans;
        if(!isLeaf(root))    ans.add(root.data);
        addLeftBoundary(root,ans);
        addLeaves(root,ans);
        addRightBoundary(root,ans);
        return ans;
	}
}
