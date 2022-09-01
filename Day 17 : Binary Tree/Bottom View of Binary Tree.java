// Bottom View of Binary Tree 
// Input : Given Binary tree
// Output : return nodes which are visible from bottom

// Approach 1: Using LevelOrder traversal and add all the node in map by line i.e which line the node is present i.e suppose new node on bottom side on straight line is found then we can add it to the map and it would will be overwritten
// at the end traverse the map and add all the values of map to the ans 
// Use TreeMap because keys are sorted in the treeMap

// Time Complexity - O(2n)
// Space Complexity  - O(2n)

// Code:

// Coding Studio

/*********************************************

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

*********************************************/

import java.util.*;

class Pair{
    int key;
    BinaryTreeNode node ;
    Pair(int key , BinaryTreeNode node){
        this.key = key;
        this.node = node;
    }
}

public class Solution {
    
    
    public static ArrayList<Integer> bottomView(BinaryTreeNode root) {
         // Write your code here.   
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> hm = new TreeMap<>();
        
        Queue<Pair> q = new LinkedList<>();
        
        q.offer(new Pair(0,root));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int l = p.key;
            BinaryTreeNode temp = p.node;
            
            hm.put(l,temp.val);
            if(temp.left != null){
                q.offer(new Pair(l-1,temp.left));
            }
            
            if(temp.right != null){
                q.offer(new Pair(l+1,temp.right));
            }
        }
        
        for(Map.Entry<Integer,Integer> entry : hm.entrySet()){
            ans.add(entry.getValue());
        }
        
        return ans;
    }
}

// GFG Code Solution 

//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references
 
    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}

//User function Template for Java


class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> hm = new TreeMap<>();
        Queue<Node> q = new LinkedList<>();
        
        root.hd = 0;
        
        q.offer(root);
        while(!q.isEmpty()){
            Node temp = q.poll();
            int hd = temp.hd;
            
            hm.put(hd,temp.data);
            
            if(temp.left!=null){
                temp.left.hd = hd - 1;
                q.offer(temp.left);
            }
            
            if(temp.right != null){
                temp.right.hd = hd + 1;
                q.offer(temp.right);
            }
        }
        
        for(Map.Entry<Integer,Integer> entry : hm.entrySet()){
            ans.add(entry.getValue());
        }
        
        // for(int Key : hm.keySet()){
        //     ans.add(hm.get(Key));
        // }
        
        return ans;
    }
}

