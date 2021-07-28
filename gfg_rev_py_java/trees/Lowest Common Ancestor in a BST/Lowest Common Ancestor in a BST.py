"""
Lowest Common Ancestor in a BST 
Easy Accuracy: 50.22% Submissions: 71247 Points: 2
Given a Binary Search Tree (with all values unique) and two node values. Find the Lowest Common Ancestors of the two nodes in the BST.

Example 1:

Input:
              5
           /    \
         4       6
        /         \
       3           7
                    \
                     8
n1 = 7, n2 = 8
Output: 7
Example 2:

Input:
     2
   /   \
  1     3
n1 = 1, n2 = 3
Output: 2
Your Task:
You don't need to read input or print anything. Your task is to complete the function LCA() which takes the root Node of the BST and two integer values n1 and n2 as inputs and returns the Lowest Common Ancestor of the Nodes with values n1 and n2 in the given BST. 

Expected Time Complexity: O(Height of the BST).
Expected Auxiliary Space: O(Height of the BST).

Constraints:
1 <= N <= 104

link --> https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1#
"""


"""using the concept of recursion"""
def LCA(root, n1, n2):
    if root:
        if(root.data > n1 and root.data > n2):
            return LCA(root.left, n1, n2)
    
        if(root.data < n1 and root.data < n2):
            return LCA(root.right, n1, n2)

    return root


"""using concept of stack"""
def LCA(root, n1, n2):
    st = [root]
    store = None
    while len(st) > 0:
        cur = st[0]
        del st[0]
        store = cur
        if cur.left:
            if cur.data > n1 and cur.data > n2:
                st.append(cur.left)
        if cur.right:
            if cur.data < n1 and cur.data < n2:
                st.append(cur.right)
    return store 

"""iterative method """

def LCA(cur, n1, n2):
    while cur:
        if cur.data > n1 and cur.data > n2:
            cur = cur.left
        elif cur.data < n1 and cur.data < n2:
            cur = cur.right
        else:
            break
    return cur 