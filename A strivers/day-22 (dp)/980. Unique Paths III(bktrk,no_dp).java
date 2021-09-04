/*
980. Unique Paths III
Hard

1772

102

Add to List

Share
You are given an m x n integer array grid where grid[i][j] could be:

1 representing the starting square. There is exactly one starting square.
2 representing the ending square. There is exactly one ending square.
0 representing empty squares we can walk over.
-1 representing obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

 

Example 1:


Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
Example 2:


Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
Explanation: We have the following four paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
Example 3:


Input: grid = [[0,1],[2,0]]
Output: 0
Explanation: There is no path that walks over every empty square exactly once.
Note that the starting and ending square can be anywhere in the grid.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 20
1 <= m * n <= 20
-1 <= grid[i][j] <= 2
There is exactly one starting cell and one ending cell.

link -->> https://leetcode.com/problems/unique-paths-iii/
*/

class Solution {
    int cnt = 0;
    public int uniquePathsIII(int[][] grid) {
        int row = 0, col = 0, z = 0;
        for (int r = 0; r < grid.length; r++)
            for (int c = 0; c < grid[0].length; c++)
                if (grid[r][c] == 1){ row = r; col = c;}
                else if (grid[r][c] == 0) z++;
        dfs(grid, row, col, z);
        return cnt;
    }
    private void dfs(int[][] grid, int r, int c, int z){
        if (r < 0 || r >= grid.length || c < 0  || c >= grid[0].length || grid[r][c] == -1 ) return;
        if (grid[r][c] == 2) {
            if (z < 0) cnt++;
            return;}
        
        // int t = grid[r][c]; could also be crt if it is used bud L-85 to be conv. to `grid[r][c] = t;`
        grid[r][c] = -1;
        z--;
        dfs(grid, r + 1, c, z);
        dfs(grid, r , c + 1, z);
        dfs(grid, r - 1, c, z);
        dfs(grid, r, c - 1, z);
        grid[r][c] = 0;
    }
}
class Solution {
    int cnt = 0;
    public int uniquePathsIII(int[][] grid) {
        int row = 0, col = 0, z = 0;
        for (int r = 0; r < grid.length; r++)
            for (int c = 0; c < grid[0].length; c++)
                if (grid[r][c] == 1){ row = r; col = c;}
                else if (grid[r][c] == 0) z++;
        dfs(grid, row, col, z);
        return cnt;
    }
    private void dfs(int[][] grid, int r, int c, int z){
        if (r < 0 || r >= grid.length || c < 0  || c >= grid[0].length || grid[r][c] == -1 ) return;
        if (grid[r][c] == 2) {
            if (z == -1) cnt++;
            return;}
        
        int t = grid[r][c];
        grid[r][c] = -1;
        // z--;
        dfs(grid, r + 1, c, z - 1);
        dfs(grid, r , c + 1, z - 1);
        dfs(grid, r - 1, c, z - 1);
        dfs(grid, r, c - 1, z - 1);
        grid[r][c] = t;
    }
}