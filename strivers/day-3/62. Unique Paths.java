/*
"""
62. Unique Paths
Medium

5875

252

Add to List

Share
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

 

Example 1:


Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
Example 3:

Input: m = 7, n = 3
Output: 28
Example 4:

Input: m = 3, n = 3
Output: 6
 

Constraints:

1 <= m, n <= 100
It's guaranteed that the answer will be less than or equal to 2 * 109.
"""

*/


// LINK FOR DP DETAILED --> https://leetcode.com/discuss/general-discussion/458695/Dynamic-Programming-Patterns

// This is a combinatorial problem and can be solved without DP. For mxn grid, robot has to move exactly m-1 steps down and n-1 steps right and these can be done in any order.

// For the eg., given in question, 3x7 matrix, robot needs to take 2+6 = 8 steps with 2 down and 6 right in any order. That is nothing but a permutation problem. Denote down as 'D' and right as 'R', following is one of the path :-

// D R R R D R R R

// We have to tell the total number of permutations of the above given word. So, decrease both m & n by 1 and apply following formula:-

// Total permutations = (m+n)! / (m! * n!)

// Following is my code doing the same :-
// https://leetcode.com/problems/unique-paths/discuss/22958/Math-solution-O(1)-space
// soln. here using concept of P&C


class Solution {

    public int uniquePaths(int m, int n) {
        if (m==1||n==1) return 1;
        m--;n--;
        if (m<n){
           int temp = m;
            m = n;
            n = temp;
        }
        long res = 1;
        int div = 1;
        for (int i = m + 1; i < m + n + 1; i++, div++){
            res *= i;
            res /= div;
        }
        
        return (int)res;
        
        
    }
}


// dp soln.
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(i==0||j==0)
                    grid[i][j] = 1;
                else
                    grid[i][j] = grid[i][j-1] + grid[i-1][j];
            }
        }
        return grid[m-1][n-1];
    }
}

// recursive soln.
class Solution {
    int solve(int[][] grid, int x, int y){
        if(x>=grid.length || y >=grid[0].length) return 0;
        if(x == grid.length-1 && y == grid[0].length-1) return 1;
        return solve(grid,x+1,y) + solve(grid,x,y+1); 
    }
    public int uniquePaths(int m, int n) {
        int grid[][] = new int[m][n];
        return solve(grid,0,0);
    }
}
// Method 1 : Top Down DP ( Recursion + memoization)

class Solution {
    int[][] memo;
    
    int solve(int[][] grid, int x, int y){
        if(x>=grid.length || y >=grid[0].length) return 0;
        if(memo[x][y] != -1) return memo[x][y];
        if(x == grid.length-1 && y == grid[0].length-1) return 1;
        return memo[x][y] = solve(grid,x+1,y) + solve(grid,x,y+1); 
    }
    public int uniquePaths(int m, int n) {
        int grid[][] = new int[m][n];
        memo = new int[m][n];
        for(int[]rows:memo) Arrays.fill(rows,-1);
        return solve(grid,0,0);
    }
}
// Method 2 : Bottom up DP ( Building solution from (Destination) RIGHT-MOST BOTTOM corner)

class Solution {
    public int uniquePaths(int m, int n) {
        int grid[][] = new int[m][n];
        int[][]dp = new int[m+1][n+1];
        for(int x=m;x>=0;x--){
            for(int y=n;y>=0;y--){
                if(x == m || y == n) dp[x][y] = 0;
                else if(x == m-1 && y == n-1) dp[x][y] = 1;
                else dp[x][y] =  dp[x+1][y] + dp[x][y+1]; 
            }
        }
        return dp[0][0];
    }
}
// Method 3 : Bottom-up ( Building solution from (source) LEFT-MOST TOP corner)

class Solution {
    public int uniquePaths(int m, int n) {
        int grid[][] = new int[m][n];
        int[][]dp = new int[m][n];
  
        for(int x=0;x<m;x++){
            for(int y=0;y<n;y++){
                if(x == 0 || y == 0) dp[x][y] = 1;
                else dp[x][y] =  dp[x-1][y] + dp[x][y-1]; 
            }
        }
        return dp[m-1][n-1];
    }
}