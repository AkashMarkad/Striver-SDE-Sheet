// Permutation Sequence 
// Input: n=3, k=3 
// Output: "213"

// Problem Link : 1) https://leetcode.com/problems/permutation-sequence/
//                2) https://www.codingninjas.com/codestudio/problems/1112626?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
// Appraoch 1: brute Force 
// Use Recursion to genearate the all the permuation
// Then sort the permuataion 
// then return k-1 position element among the permutations

// Time Complexity - O(N!*N)

// Approach 2: Optimal Approach
// Use Mathematical Calculations
// i.e suppose K=4 then it will genearte 24 permurtatons and we want the the 17 then it is from the third digit from the sorted array
//  Do the same for the remaining digits 

// Time Compelexity - O(N^2)
// Space Complexity - O(N)

// Code:

class Solution {
    public String getPermutation(int n, int k) {
        
        int fact=1;
        List<Integer> numbers = new ArrayList<>();
        for(int i=1;i<n;i++){
            fact = fact *i;
            numbers.add(i);
        }
        numbers.add(n);
        String ans = "";
        k =  k-1;
        while(true){
            ans = ans + numbers.get(k/fact);
            numbers.remove(k/fact);
            if(numbers.size() ==0)
                break;
            k = k % fact;
            fact = fact/numbers.size();
        }
        return ans;
        
    }
}
