/*

74. Search a 2D Matrix
Medium

3924

212

Add to List

Share
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
 

Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false

link --> https://leetcode.com/problems/search-a-2d-matrix/
*/



// Runtime: 0 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix.
// Memory Usage: 39.6 MB, less than 7.15% of Java online submissions for Search a 2D Matrix.

// Also called the step search algorithm. Very useful when the matrix is sorted.


class Solution {
    public boolean searchMatrix(int[][] matrix, int k) {
        int r = 0, c = matrix[0].length - 1;
        while ( r < matrix.length && c >= 0 ){
            if (matrix[r][c] == k) return true;
            if (matrix[r][c] > k) c--;
            else if (matrix[r][c] < k) r++;
        }
        return false;
    }
}


// sort of diff.
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int r1 = 0;
        int r2 = matrix.length - 1;
        int c1 = 0;
        int c2 = matrix[0].length - 1;
        
        while (r1 < r2) {
            int mid = (r1 + r2) / 2;
            if (matrix[mid][c2] == target) {
                return true;
            }
            else if (target < matrix[mid][c2]) {
                r2 = mid;
            }
            else {
                r1 = mid + 1;
            }
        }
        
        while (c1 <= c2) {
            int mid = (c1 + c2) / 2;
            if (matrix[r2][mid] == target) {
                return true;
            }
            else if (target < matrix[r2][mid]) {
                c2 = mid - 1;
            }
            else {
                c1 = mid + 1;
            }
        }
        
        return false;
    }
}



// stupid soln.

public class Search_a_2D_Matrix {    
        public int[] getNxtInd(int[][] matrix, int i, int c){
            int R = matrix.length, C = matrix[0].length - 1;
            int[] ind = new int[2];
            while (true){
                int r = i - C*c;
                if (r >= 0 && r < R){
                    ind[0] = r;
                    ind[1] = c;
                    break;
                }
                if (r < 0){
                    c -= c/2;
                }
                else if (r > R){
                    c += c/2;
                }
            }
            return ind;
        }
        public boolean searchMatrix(int[][] matrix, int k) {
         
            int R = matrix.length - 1, C = matrix[0].length - 1;
            int r = R/2, c = C/2;
            int[] ind = new int[2];
            
            while ( (r > 0 && c > 0) || (r < R && c < C ) ){
                int cur = matrix[r][c];
                int i = r + C*c;
                if (cur == k) return true;
                if (cur > k){
                    ind = getNxtInd(matrix, i, c);
                    r = ind[0];
                    c = ind[1];
                }
                else if (cur < k){
                    ind = getNxtInd(matrix, i, c);
                    r = ind[0];
                    c = ind[1];
                }
            }
            
            return false;
        }
}
