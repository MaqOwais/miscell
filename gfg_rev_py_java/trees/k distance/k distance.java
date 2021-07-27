"""
K distance from root 
Easy Accuracy: 55.52% Submissions: 47830 Points: 2
Given a Binary Tree of size N and an integer K. Print all nodes that are at distance k from root (root is considered at distance 0 from itself). Nodes should be printed from left to right. If k is more that height of tree, nothing should be printed.

For example, if below is given tree and k is 2. Output should be 4 5 6.

          1
       /     \
     2        3
   /         /   \
  4        5    6 
     \
      8

Example 1:

Input:
K = 0
      1
    /   \
   3     2
Output: 1

Example 2:

Input:
K = 3
        3
       /
      2
       \
        1
      /  \
     5    3
Output: 5 3
Your Task:
You don't have to take input. Complete the function Kdistance() that accepts root node and k as parameter and return the value of the nodes that are at a distance k from the root. (The values are returned as vector in cpp, as ArrayList in java and list in python)
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= N <= 104
0 <= K <= 30

Note: The Input/Ouput format and Example is given are used for the system's internal purpose, and should be used by a user for Expected Output only. As it is a function problem, hence a user should not read any input from the stdin/console. The task is to complete the function specified, and not to write the full code.

link --> https://practice.geeksforgeeks.org/problems/k-distance-from-root/1#
"""
class Tree
{   
    void helper(Node root, int k, ArrayList<Integer> lis){
        if (root != null){
            if (k == 0){
                lis.add(root.data);
            }
            helper(root.left, k - 1, lis);
            helper(root.right, k -1 , lis );
        }
            
    }
    
     // Recursive function to print right view of a binary tree.
     ArrayList<Integer> Kdistance(Node root, int k)
     {
         ArrayList<Integer> lis = new ArrayList<>();
         helper(root, k, lis);
         return lis;
     }
}