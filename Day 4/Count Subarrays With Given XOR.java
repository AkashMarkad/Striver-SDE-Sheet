// Count Subarrays with Given XOR
// Problem Link : 1) codingninjas.com/codestudio/problems/1115652?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1 
//                2) https://www.interviewbit.com/problems/subarray-with-given-xor/

// Approach 1 : generate all permutaions of array using kedane's Algorithms
// Time Complexity - O(N^3)
// Space Complexity - O(1)

// Approach 2:- Using HashMap 
// Time Complexity - O(NlogN)
// Space Complexity - O(N)

// Code

public class Solution {
	public static int subarraysXor(ArrayList<Integer> arr, int x) {
		// Write your code here.
        
        HashMap<Integer , Integer> hm = new HashMap<>();
        int count = 0;
        int xorr = 0;
        int n = arr.size();
        for(int i=0;i<n;i++){
            xorr = xorr^arr.get(i);
            if(hm.containsKey(xorr^x)){
                count += hm.get(xorr^x);
            }
            
            if(xorr==x){
                count++;
            }
            
            if(hm.containsKey(xorr)){
                hm.put(xorr , hm.get(xorr)+1);
            }
            else {
                hm.put(xorr , 1);
            }
        }
        return count;
	}
}
