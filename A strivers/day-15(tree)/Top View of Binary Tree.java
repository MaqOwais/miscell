/*
Top View of Binary Tree 
Medium Accuracy: 32.3% Submissions: 90410 Points: 4
Given below is a binary tree. The task is to print the top view of binary tree. Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. For the given below tree

       1
    /     \
   2       3
  /  \    /   \
4    5  6   7

Top view will be: 4 2 1 3 7
Note: Return nodes from leftmost node to rightmost node.

Example 1:

Input:
      1
   /    \
  2      3
Output: 2 1 3
Example 2:

Input:
       10
    /      \
  20        30
 /   \    /    \
40   60  90    100
Output: 40 20 10 30 100
Your Task:
Since this is a function problem. You don't have to take input. Just complete the function topView() that takes root node as parameter and returns a list of nodes visible from the top view from left to right. Print endline after end of printing the top view.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N).


*/

class Solution

{   
    static class pair {
        int first, second;
 
        pair() {}
        pair(int i, int j)
        {
            first = i;
            second = j;
        }
    }

    private void fillMap(Node root, int d, int l, TreeMap<Integer, pair> m )
    {   
        
        if (root != null){

            if (m.get(d) == null) 
                m.put(d, new pair(root.data, l));
            else if (m.get(d).second > l) 
                m.put(d, new pair(root.data, l));
            fillMap(root.left, d - 1, l + 1, m);
            fillMap(root.right, d + 1, l + 1, m);}
    }
    public ArrayList<Integer> topView(Node root)
    {   TreeMap<Integer, pair> m = new TreeMap<>();
        fillMap(root, 0, 0, m);
        ArrayList<Integer> ans = new ArrayList();
        for (Map.Entry<Integer, pair> entry : m.entrySet()) 
            ans.add(entry.getValue().first);
        return ans;
    }
}