/*
64. Minimum Path Sum
Medium

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example 1:


Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 100
Accepted
586,179
Submissions
1,018,372

link --> https://leetcode.com/problems/minimum-path-sum/
*/

class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) return 0;
        int[][] dp = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++){
                dp[i][j] = grid[i][j];
                if (i > 0 && j > 0) dp[i][j] += Math.min(dp[i - 1][j], dp[i][j - 1]);
                else if (i > 0) dp[i][j] += dp[i - 1][j];
                else if (j > 0) dp[i][j] += dp[i][j - 1];}

        return dp[dp.length - 1][dp[0].length - 1];
    }
}

// or inplace no extra space

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // fill 1st r
        for (int i = 1; i < n; i++) grid[0][i] += grid[0][i - 1];
        // fill 1st c
        for (int j = 1; j < m; j++) grid[j][0] += grid[j - 1][0];

        for (int i = 1; i < m; i++) 
            for (int j = 1; j < n; j++) grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);

        return grid[m - 1][n - 1];
    }
}

// rec
class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        return minPathSumHelper(grid, 0, 0, dp);
    }

    public int minPathSumHelper(int[][] grid, int r, int c, int[][] dp) {
        if(r == grid.length-1 && c == grid[0].length-1) return grid[r][c];
        if(dp[r][c] != 0) return dp[r][c];

        int rowInc = Integer.MAX_VALUE, colInc = Integer.MAX_VALUE;
        if(r < grid.length-1) rowInc = minPathSumHelper(grid, r+1, c, dp);
        if(c < grid[0].length-1) colInc = minPathSumHelper(grid, r, c+1, dp);
        dp[r][c] = Math.min(rowInc, colInc) + grid[r][c];
        return dp[r][c];
    }
}
