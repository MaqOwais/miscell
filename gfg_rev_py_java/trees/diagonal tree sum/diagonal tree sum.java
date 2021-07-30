/*
"""Diagonal Sum In Binary Tree 
Easy Accuracy: 51.18% Submissions: 14831 Points: 2
Consider Red lines of slope -1 passing between nodes (in following diagram). The diagonal sum in a binary tree is the sum of all node’s data lying between these lines. Given a Binary Tree of size N, print all diagonal sums.

For the following input tree, output should be 9, 19, 42.
9 is sum of 1, 3 and 5.
19 is sum of 2, 6, 4 and 7.
42 is sum of 9, 10, 11 and 12.

DiagonalSum

Example 1:

Input:
         4
       /   \
      1     3
           /
          3
Output: 7 4 
Example 2:

Input:
           10
         /    \
        8      2
       / \    /
      3   5  2
Output: 12 15 3 
Your Task:
You don't need to take input. Just complete the function diagonalSum() that takes root node of the tree as parameter and returns an array containing the diagonal sums for every diagonal present in the tree with slope -1.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1<=Number of nodes<=105

Note: The Input/Ouput format and Example given are used for system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from stdin/console. The task is to complete the function specified, and not to write the full code.

link --> https://practice.geeksforgeeks.org/problems/diagonal-sum-in-binary-tree/1#
"""
*/

"""using recursion and list DS"""
class Tree {
    public static void digs(Node root, ArrayList<Integer> arr, int i){
            if (root==null){
                
             return;
        
            }
            if (i == arr.size()) {
                arr.add(root.data);}
            else {
                arr.set(i, arr.get(i) + root.data);
            }
            digs(root.left, arr, i+1);
            digs(root.right, arr, i);
        
    }
    
    
    public static ArrayList <Integer> diagonalSum(Node root) 
    {
        ArrayList<Integer> arr = new ArrayList<>();
        digs(root, arr, 0);
        return arr;
    }
    
    
    
}


/*"""using stack problem (specifically QUEUE) 

keeping track of 
1. size of stack then decrementing it after (3) step.
2. left sub-tree...
3. iterate through right-subtree
4. finally appending if left subtree comes out during (3) step.
"""*/
class Tree {
    public static ArrayList <Integer> diagonalSum(Node root) 
    {
        Stack<Node> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        st.add(root);
        while (true){
            int size = st.size();
            if (size == 0) break;
            int p = 0;
            while (size > 0){
                Node temp = st.remove(0);
                // SORT OF QUEUE OPERATION
                // In stack --> pop used to remove last element(lifo) but here we want fifo here so we use remove
                //  (whereas, peek is used to just see the elements at last...)
                while (temp != null){
                    p += temp.data;
                    if (temp.left != null) st.add(temp.left);
                    temp = temp.right;
                }
                size--;
            }
            ans.add(p);
        }
        return ans;
    }}