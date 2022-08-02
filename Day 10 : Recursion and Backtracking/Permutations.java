// Permuatations String or Array
// Generate all permutations of the given string or array

// Approach 1: Use Recursion and Datastructure to store all the permutation and also maintain the map or array to check whether element is picked or not
// Accordingly add all the elememts 

// Time Complexity - O(N!*N)
// Space Complexity - O(N) + O(N)

// Approach 2: Use Swapping technique and reduce the space


// Time Complexity - O(N! * N)
// Space Complexity - O(N)-(i.e. Recursion space)

// Code:

class Solution {
    
    private void recurPermute(int index , int[] nums , List<List<Integer>> ans){
        
        if(index == nums.length){
            //Copy the ds to ans
            List<Integer> ds = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return ;
        }
        for(int i=index;i<nums.length;i++){
            swap(i,index,nums);
            recurPermute(index+1,nums,ans);
            swap(i,index,nums);
        }
    }
    
    private void swap(int i,int j, int[] nums){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recurPermute(0,nums,ans);
        return ans;
    }
}
