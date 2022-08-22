// Roman Number to integer

// Input: s = "MCMXCIV"
// Output: 1994
// Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

// Time Complexity - O(n)
// Space Complexity - O(7)

// Problem LeetCode : https://leetcode.com/problems/roman-to-integer/

// Code: 
// Using HashMap

class Solution {
    public int romanToInt(String s) {
        
        HashMap<Character,Integer> hashmap=new HashMap<>();
        
        hashmap.put('I',1);
        hashmap.put('V',5);
        hashmap.put('X',10);
        hashmap.put('L',50);
        hashmap.put('C',100);
        hashmap.put('D',500);
        hashmap.put('M',1000);
        
        int r=0;
        char temp='I';
        
        for(int i=s.length()-1;i>=0;i--)
        {
            if(hashmap.get(s.charAt(i))<hashmap.get(temp))
            {
                r = r- hashmap.get(s.charAt(i));
            }
            else
            {
                r = r + hashmap.get(s.charAt(i));
                temp = s.charAt(i);
            }
            
        }
        
        return r;
    }
}

// Code -- Using Switch Case 

class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        for(int i = s.length()-1; i >= 0; i--){
        switch(s.charAt(i)){
        case 'I':
        if(sum >= 5){
        sum -= 1;
        }
        else{
        sum += 1;
        }
        break;
        case 'V':
        if(sum >= 10){
        sum -= 5;
        }
        else{
        sum += 5;
        }
        break;
        case 'X':
        if(sum >= 50){
        sum -= 10;
        }
        else{
        sum += 10;
        }
        break;
        case 'L':
        if(sum >= 100){
        sum -= 50;
        }
        else{
        sum += 50;
        }
        break;
        case 'C':
        if(sum >= 500){
        sum -= 100;
        }
        else{
        sum += 100;
        }
        break;
        case 'D':
        if(sum >= 1000){
        sum -= 500;
        }
        else{
        sum += 500;
        }
        break;
        case 'M':
        sum += 1000;
        break;
        }
        }
        return sum;
    }
}
