// Zig zag Travrsal 

// Approach : Maintain flag for checking which condition i.e Left to right or Right to Left
// add accordingly in the ans 
// return solution

// Time Complxity - O(n+)
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null)    return ans;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        boolean leftToRight = true;
        while(!q.isEmpty()){
            
            int size = q.size();
            ArrayList<Integer> subList = new ArrayList<>();
            
            for(int i=0;i<size;i++){
                
                TreeNode node = q.poll();
                
                if(leftToRight) subList.add(node.val);
                else    subList.add(0,node.val);
                
                if(node.left != null)   q.offer(node.left);
                if(node.right != null)  q.offer(node.right);
            }
            
            leftToRight = !leftToRight;
            ans.add(subList);
        }
        
        return ans;
    }
}

// Coding Studio

public class Solution {
	public static List<Integer> zigZagTraversal(BinaryTreeNode<Integer> root) {
		// Write your code here!
        boolean ltr = true;
        ArrayList<Integer> ans = new ArrayList<>();
        
        if(root == null)    return ans;
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> subList = new ArrayList<>();
            for(int i=0;i<size;i++){
                
                BinaryTreeNode<Integer> node = q.poll();
                
                subList.add(node.data);
                
                if(node.left != null)    q.offer(node.left);
                if(node.right != null)    q.offer(node.right);
            }
            
            if(ltr){
                for(int num : subList)    ans.add(num);
            }
            else{
                for(int i=subList.size()-1 ; i >= 0 ;i--)    ans.add(subList.get(i));
            }
            
            ltr = !ltr;
        }
        
        return ans;
	}
}
