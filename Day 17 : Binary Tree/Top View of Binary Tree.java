// Top view of Binary Tree 
// Input : Given tree
// Output : return the nodes which are visible from top

// Approach : Same as the bottom view i.e travrse using the level order traversal and add the node on each line only once i.e when node is not present in the map then only add to the map
// Travrse the map and return the ans

// Time Complexity - O(n)
// Space Complexity - O(2n)

// Code:

// Coding Studio

/************************************************************

    Following is the TreeNode class structure:

    class BinaryTreeNode {
		int val;
		BinaryTreeNode left;
		BinaryTreeNode right;

		BinaryTreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

************************************************************/
import java.util.*;

class Pair{
    int key ;
    BinaryTreeNode node;
    Pair(int key , BinaryTreeNode node){
        this.key = key;
        this.node = node;
    }
}
public class Solution {
	public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
		// Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer,Integer> hm = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        
        if(root == null)    return ans;
        
        q.offer(new Pair(0,root));
        
        while(!q.isEmpty()){
            
            Pair p = q.poll();
            int l = p.key;
            BinaryTreeNode temp = p.node;
            
            if(!hm.containsKey(l)){
                hm.put(l,temp.val);
            }
            
            if(temp.left != null){
                q.offer(new Pair(l-1,temp.left));
            }
            if(temp.right != null){
                q.offer(new Pair(l+1,temp.right));
            }
        }
        
        for(int key : hm.keySet()){
            ans.add(hm.get(key));
        }
        return ans;
	}
}

// GFG Solution 


//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Pair{
    int key;
    Node node;
    Pair(int key , Node node){
        this.key = key;
        this.node = node;
    }
}

class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> hm = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        
        q.offer(new Pair(0,root));
        
        while(!q.isEmpty()){
            
            Pair p = q.poll();
            int l = p.key;
            Node temp = p.node;
            if(!hm.containsKey(l)){
                hm.put(l,temp.data);
            }
            
            if(temp.left != null){
                q.offer(new Pair(l-1,temp.left));
            }
            if(temp.right != null){
                q.offer(new Pair(l+1,temp.right));
            }
        }
        
        for(int key : hm.keySet()){
            ans.add(hm.get(key));
        }
        return ans;
    }
}
