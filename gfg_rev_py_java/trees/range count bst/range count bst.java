"""
Count BST nodes that lie in a given range 
Medium Accuracy: 50.5% Submissions: 46696 Points: 4
Given a Binary Search Tree (BST) and a range l-h(inclusive), count the number of nodes in the BST that lie in the given range.

The values smaller than root go to the left side
The values greater and equal to the root go to the right side
Example 1:

Input:
      10
     /  \
    5    50
   /    /  \
  1    40  100
l = 5, h = 45
Output: 3
Explanation: 5 10 40 are the node in the
range
Example 2:

Input:
     5
    /  \
   4    6
  /      \
 3        7
l = 2, h = 8
Output: 5
Explanation: All the nodes are in the
given range.
Your Task:
This is a function problem. You don't have to take input. You are required to complete the function getCountOfNode() that takes root, l ,h as parameters and returns the count.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(Height of the BST).

Constraints:
1 <= Number of nodes <= 100
1 <= l < h < 103

link - https://practice.geeksforgeeks.org/problems/count-bst-nodes-that-lie-in-a-given-range/1#
"""


"""using the concept of inorder traversal"""

class Tree
{   
    public void util(Node root,int l,int h,ArrayList<Node> lis){
        if (root != null){
            util(root.left, l,h, lis);
            if (l <= root.data && root.data<= h) lis.add(root);
            util(root.right, l, h, lis);
        }
        
    }
    //Function to count number of nodes in BST that lie in the given range.
    int getCount(Node root,int l, int h)
    {
        ArrayList<Node> lis = new ArrayList();
        util(root, l, h, lis);
        return lis.size();
    }
    
}



"""no extra ds used"""


class Tree
{
    //Function to count number of nodes in BST that lie in the given range.
    int getCount(Node root,int l, int h)
    {
        if (root == null){
            return 0;
        }
        if (root.data >= l && root.data <= h){
            return 1 + getCount(root.right, l, h) + getCount(root.left, l, h);
        }else if(root.data < l){
            return getCount(root.right, l, h);
        }else{
            return getCount(root.left, l, h);
        }
    }
    
}