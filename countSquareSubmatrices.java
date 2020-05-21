/* PROBLEM:
Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

Example 1:
Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.

Example 2:
Input: matrix = 
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation: 
There are 6 squares of side 1.  
There is 1 square of side 2. 
Total number of squares = 6 + 1 = 7.
 
Constraints:
1 <= arr.length <= 300
1 <= arr[0].length <= 300
0 <= arr[i][j] <= 1
*/

class Solution {
    static boolean allOnes(int[][] matrix, int rowStart, int rowEnd, int colStart, int colEnd){
        for(int i = rowStart; i<=rowEnd; i++){
            for(int j = colStart; j<=colEnd; j++)
                if(matrix[i][j]==0) return false;
        }
        return true;
    }
    
    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int side = Math.min(rows, cols);
        
        int r = side-1, c= side-1;
        int res = 0;
        for(; side>0; side--)
            for(r=side-1; r<rows; r++)
                for(c=side-1; c<cols; c++)
                {
                    if(allOnes(matrix, r-side+1, r, c-side+1, c)){
                        res += 1;                        
                    }
                }
        return res;
    }
}
