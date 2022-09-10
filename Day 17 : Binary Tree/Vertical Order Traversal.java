// Vertical Order Traversal
// Input : Given Tree
// Output : Return ans arrayList

// Approach 1: Traverse the tree using level order traversal also maintain the vertical line number 
// At the end trevrse the map add list to the ans
// return ans

// Time Complexity - O(2n)
// Space Complexity - O(2n)

// Code:

/************************************************************
    Following is the TreeNode class structure
    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;
        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };
************************************************************/

class Pair{
    int line;
    TreeNode<Integer> node;
    Pair(TreeNode<Integer> node, int line){
        this.node = node;
        this.line = line;
    }
}
public class Solution 
{
    public static ArrayList<Integer> verticalOrderTraversal(TreeNode<Integer> root) 
    {
        //    Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Map<Integer, ArrayList<Integer>> hm = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int line = p.line;
            TreeNode<Integer> temp = p.node;
            if(!hm.containsKey(line)){
                hm.put(line, new ArrayList<>());
            }
            hm.get(line).add(temp.data);
            if(temp.left!=null){
                q.offer(new Pair(temp.left,line-1));
            }
            if(temp.right!=null){
                q.offer(new Pair(temp.right, line+1));
            }
        }
        for(int key: hm.keySet()){
            for(int i : hm.get(key)){
                ans.add(i);
            }
        }
        return ans;
    }
}

// Code: Leetcode

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

class Tuple{
    TreeNode node;
    int row;
    int col;
    Tuple(TreeNode node , int row  ,int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        TreeMap<Integer , TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root , 0 , 0));
        
        while(!q.isEmpty()){
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;
            
            if(!map.containsKey(x))
                map.put(x , new TreeMap<>());
            
            if(!map.get(x).containsKey(y))
                map.get(x).put(y , new PriorityQueue<>());
            
            map.get(x).get(y).offer(node.val);
            
            if(node.left != null)
                q.offer(new Tuple(node.left , x-1 , y+1));
            
            if(node.right != null)
                q.offer(new Tuple(node.right , x+1 , y+1));
        }
        
        List<List<Integer>> list = new ArrayList<>();
        
        for(TreeMap<Integer , PriorityQueue<Integer>> ys : map.values()){
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes : ys.values()) {
                while(!nodes.isEmpty()){
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
        
    }
}
