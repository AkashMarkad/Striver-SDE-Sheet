//Best Time to Buy and Sell Stock Problem
//Time Complexity : O(n)
//Problem link - LeetCode : https://leetcode.com/problems/best-time-to-buy-and-sell-stock

//Solution given Array

class Solution {
    public int maxProfit(int[] prices) {
        
        int min = Integer.MAX_VALUE;
        int max_profit =  0 , profit =0;
        
        for(int i=0;i<prices.length;i++)
        {
            if(prices[i]<min)
            {
                min = prices[i];
            }
            
            profit = prices[i]-min;
            
            if(max_profit < profit)
            {
                max_profit = profit;
            }
        }
        
        return max_profit;
        
    }
}

//Solution given ArrayList

public class Solution{
    public static int maximumProfit(ArrayList<Integer> prices){
        // Write your code here.
        
        int min = Integer.MAX_VALUE;
        int max_profit =  0 , profit =0;
        
        for(int i=0;i<prices.size();i++)
        {
            if(prices.get(i)<min)
            {
                min = prices.get(i);
            }
            
            profit = prices.get(i)-min;
            
            if(max_profit < profit)
            {
                max_profit = profit;
            }
        }
        
        return max_profit;
    }
}
