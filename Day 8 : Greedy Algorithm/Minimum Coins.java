// Minimum Coins

// Problem Link : https://www.codingninjas.com/codestudio/problems/975277?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

// Approach:
// Find the greater value which is less than amount and remove it from amount do the same until amount=0

// Time Complexity - O(V)
// Space Complexity -  O(1)

// Code

public class Solution
{
    public static int findMinimumCoins(int amount)
        {
            // Write your code here.
            int coins = 0;
            int arr[] = {1 , 2, 5 , 10 , 20 , 50 , 100 , 500 , 1000};
            
            for(int i = arr.length-1;i>=0 ;i--){
                while(amount >= arr[i]){
                    coins++;
                    amount -= arr[i];
                }
            }
        
        return coins;

        }
}
