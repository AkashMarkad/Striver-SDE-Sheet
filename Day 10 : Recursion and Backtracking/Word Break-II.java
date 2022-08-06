// Word Break-II 
// Given Dictionary of word and string
// We need to find the possible combination and return it

// Code:

public class Solution {
    
    public static void words(int start , String s , ArrayList<String> ans , ArrayList<String> dictionary , String str){
        
        if(start >= s.length()){
            ans.add(str);
            return ;
        }
        
        for(int i=start;i<s.length();i++){
            String temp = s.substring(start,i+1);
            if(dictionary.contains(temp)){
                String cur = str;
                str += temp+" ";
                words(i+1,s,ans,dictionary,str);
                str = cur;
            }
            
        }
    }

	public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
		// Write your code here.
        ArrayList<String> ans = new ArrayList<>();
        words(0,s,ans,dictionary,"");
        return ans;
	}
}
