"""
Search a node in BST 
Basic Accuracy: 55.04% Submissions: 27191 Points: 1
Given a Binary Search Tree and a node value X, find if node with value X is present in the BST or not. 


Example 1:

Input:
         2
          \
          81
        /    \
      42      87
    /   \       \
   45   66      90
x = 87
Output: 1
Explanation: As 87 is present in the
given nodes , so the output will be
1.
Example 2:

Input:
      6
       \
        7
       / \
      8   9
x = 11
Output: 0
Explanation: As 11 is not present in 
he given nodes , so the output will
be 0.

Your Task:
You don't need to read input or print anything. Complete the function search() which returns true if the node with value x is present in the BST else returns false. 


Expected Time Complexity: O(Height of the BST)
Expected Auxiliary Space: O(1).


Constraints:
1 <= Number of nodes <= 105

link--> https://practice.geeksforgeeks.org/problems/search-a-node-in-bst/1

"""

class Node
{
	int data;
	Node left;
	Node right;
	Node(int d)
	{
		data = d;
		left = right = null;
	}
}

class BST
{
    //Function to search a node in BST.
    boolean search(Node root, int x)
    {
	    if (root == null) return false;  
	   
	    Node cur = root;
    
        while (cur != null){
            if (x == cur.data) return true;
            if (x > cur.data) cur = cur.right;
            else cur = cur.left;
        }
        
        return false;
    }
    
}
