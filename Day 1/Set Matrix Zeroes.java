//Best way to solve this problem --- create two dummy array for row and column
// O(m*n + m*n)

class Solution {
    public void setZeroes(int[][] matrix) {
                
        int colLen = matrix[0].length;
        int[] row = new int[matrix.length];
        int[] col = new int[colLen];
        
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==0)
                {
                    row[i] = -1;
                    col[j] = -1;
                }
            }
        }
        
        
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(row[i]==-1 || col[j]==-1)
                {
                    matrix[i][j]=0;
                }
            }
        }
        
        return;
        
    }
}
