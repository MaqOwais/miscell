/*
73. Set Matrix Zeroes
Medium

4006

393

Add to List

Share
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.

You must do it in place.

 

Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 

Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1
 

Follow up:

A straightforward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

link--> https://leetcode.com/problems/set-matrix-zeroes/

*/


// best soln. speed 93% and space 85% beat !
class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] rm = new int[row];
        int[] cm = new int[col];
        
        for (int r = 0; r < row; r++){
            for (int c = 0; c < col; c++){
                if (matrix[r][c] == 0) {
                    rm[r] = 1; 
                    cm[c] = 1;}
            }
        }
        
        for (int r = 0; r < row; r++){
            for (int c = 0; c < col; c++){
                if (rm[r] == 1 || cm[c] == 1) matrix[r][c] = 0;
            }
        }
        
    }
}

// Runtime: 1 ms, faster than 93.76% of Java online submissions for Set Matrix Zeroes.
// Memory Usage: 40.6 MB, less than 64.00% of Java online submissions for Set Matrix Zeroes.
// try to understand this afterward..
class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length, k = 0;
    
        while (k < col && matrix[0][k] != 0) ++k;
    
        for (int i = 1; i < row; i++)
            for (int j = 0; j < col; j++)
                if (matrix[i][j] == 0)
                    matrix[0][j] = matrix[i][0] = 0;
    
        for (int i = 1; i < row; i++)
            for (int j = col - 1; j >= 0; j--)
                if (matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
    
        if (k < col) Arrays.fill(matrix[0], 0);
    
    }
    }
    
    
    
    
    
    


