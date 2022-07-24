// Fractional Knapsack
// Fill the full bag and earn the maximum profit fractional weight can be allowed

// Problem Link : 1) https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
//                2) https://www.codingninjas.com/codestudio/problems/975286?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

// Approach :
// steps 1: sort the array according to the value per weight 
//       2: Now fill the bag if any weight exceeding the remaining weight the just find the profit for remainnig weight and add it
//       3: Return the maxProfit

// Time Complexity - O(NlogN + N)
// Space Complexity  - O(1)

// Code:

class itemComparator implements Comparator<Item>
{
    @Override
    public int compare(Item a , Item b){
        double r1 = (double)a.value/(double)a.weight;
        double r2 = (double)b.value/(double)b.weight;
        
        if(r1 < r2) return 1;
        else if(r1 > r2)    return -1;
        else return 0;
    }
}

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        
        Arrays.sort(arr , new itemComparator());
        
        int curWeight = 0;
        double finalValue = 0.0;
        
        for(int i=0;i<n;i++){
            
            if(curWeight + arr[i].weight <= W){
                
                curWeight += arr[i].weight;
                finalValue += arr[i].value;
            }
            else{
                int remain = W - curWeight;
                finalValue += ((double)arr[i].value/(double)arr[i].weight)* (double) remain;
                break;
            }
        }
        return finalValue;
    }
}
