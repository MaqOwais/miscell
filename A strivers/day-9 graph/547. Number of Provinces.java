/*
547. Number of Provinces
Medium

3534

200

Add to List

Share
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

 

Example 1:


Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:


Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
 

Constraints:

1 <= n <= 200
n == isConnected.length
n == isConnected[i].length
isConnected[i][j] is 1 or 0.
isConnected[i][i] == 1
isConnected[i][j] == isConnected[j][i]
Accepted
305,086
Submissions
494,361

link --> https://leetcode.com/problems/number-of-provinces/

*/

class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] v = new boolean[isConnected.length];
        int province = 0;
        for (int node = 0; node < isConnected.length; node++){
            if (!v[node]){
                dfs(isConnected, v, node);
                province++;
            }
        }
        return province;
    }
    
    private void dfs(int[][] conn, boolean[] v,int nodelis){
        for (int node = 0 ; node < conn.length; node++){
            if (!v[node] && conn[nodelis][node] == 1){
                v[node] = true;
                dfs(conn, v, node);
            }
        }
    }
}