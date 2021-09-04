/*
63. Unique Paths II
Medium

3448

318

Add to List

Share
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and space is marked as 1 and 0 respectively in the grid.

 

Example 1:


Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
Example 2:


Input: obstacleGrid = [[0,1],[0,0]]
Output: 1
 

Constraints:

m == obstacleGrid.length
n == obstacleGrid[i].length
1 <= m, n <= 100
obstacleGrid[i][j] is 0 or 1.
Accepted
419,408
Submissions
1,153,919

link--> https://leetcode.com/problems/unique-paths-ii/

*/




// tle
class Solution {
    int cnt = 0;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        dfs(obstacleGrid, 0, 0);
        return cnt;
    }
    private void dfs(int[][] grid, int r, int c) {
        if (r == grid.length - 1 && c == grid[0].length - 1 && grid[r][c] == 0 ) {
            cnt++;
            return;
        }
        
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 1)
            return;
        
        grid[r][c] = 1;
        
        dfs(grid, r + 1, c);
        dfs(grid, r, c + 1);     
        
        grid[r][c] = 0;
    }
}