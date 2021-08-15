/*
785. Is Graph Bipartite?
Medium

3060

241

Add to List

Share
There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:

There are no self-edges (graph[u] does not contain u).
There are no parallel edges (graph[u] does not contain duplicate values).
If v is in graph[u], then u is in graph[v] (the graph is undirected).
The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.

Return true if and only if it is bipartite.

 

Example 1:


Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
Output: false
Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.
Example 2:


Input: graph = [[1,3],[0,2],[1,3],[0,2]]
Output: true
Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.
 

Constraints:

graph.length == n
1 <= n <= 100
0 <= graph[u].length < n
0 <= graph[u][i] <= n - 1
graph[u] does not contain u.
All the values of graph[u] are unique.
If graph[u] contains v, then graph[v] contains u.
Accepted
220,722
Submissions
447,932

link --> https://leetcode.com/problems/is-graph-bipartite/
*/


class Solution {
    // (0--> uncolored), (1--> blue), (-1 --> red)
    // dfs
    public boolean isBipartite(int[][] graph) {
        int[] colorCheck = new int[graph.length];
        for (int nd = 0; nd < graph.length; nd++){
            if (colorCheck[nd] == 0 && !validbfs(graph, colorCheck, 1, nd)) return false;
        }
        return true;
    }
    
    private boolean validbfs(int[][] g, int[] colorCheck, int color, int nd){
        boolean cond_for_clash = (colorCheck[nd] == color);
        if (colorCheck[nd] != 0) return cond_for_clash;
        colorCheck[nd] = color;
        for (int adj: g[nd]){
            if (!validbfs(g, colorCheck, -color, adj)) return false; // make alternative sections with diff colors(hence -color)
        }
        return true;
    }
}



class Solution {
    // bfs
    public boolean isBipartite(int[][] graph) {
        int[] colorCheck = new int[graph.length];
        for (int nd = 0; nd < graph.length; nd++){
            if (colorCheck[nd] == 0){
                Queue<Integer> q = new LinkedList();
                q.add(nd);
                colorCheck[nd] = 1;
                while (!q.isEmpty()){
                    int get_node = q.poll();
                    for(int node: graph[get_node]){
                        if (colorCheck[get_node] == colorCheck[node]) return false;
                        else if(colorCheck[node] == 0 )
                            q.add(node);
                            colorCheck[node] = -colorCheck[get_node];
                            
                    }
                }
            }
            
        }
        return true;
    }
}

