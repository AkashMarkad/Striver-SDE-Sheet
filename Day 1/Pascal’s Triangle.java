// Pascle Traingle problem
//         1
//       1  1
//     1  2  1
//   1  3  3  1
// 1  4  6  4  1

class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        List<Integer> row,pre = null;
    
        for(int i = 0; i<numRows; i++)
        {
            row = new ArrayList<>();
            
            for(int j = 0; j<= i; j++)
            {
                if(j == 0 || j == i)
                {
                    row.add(1);
                }
                else
                {
                    row.add(pre.get(j-1)+pre.get(j));
                }
            }
            
            pre = row;
            ans.add(row);
            
        }
        
        return ans;
        
    }
}
