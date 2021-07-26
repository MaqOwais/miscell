"""
Closest Neighbor in BST 
Easy Accuracy: 46.5% Submissions: 10255 Points: 2
Given a binary search tree and a number N, find the greatest number in the binary search tree that is less than or equal to N. 



Example 1 :

Input : N = 24
Output : 21
Explanation : The greatest element in the tree which 
              is less than or equal to 24, is 21. 
              (Searching will be like 5->12->21)
 

Example 2 :

Input : N = 4
Output : 3
Explanation : The greatest element in the tree which 
              is less than or equal to 4, is 3. 
              (Searching will be like 5->2->3)

Your task :

You don't need to read input or print anything. Your task is to complete the function findMaxForN() which takes the root of the BST, and the integer N as input paramters and returns the greatest element less than or equal to N in the given BST.


Expected Time Complexity: O(Height of the BST)
Expected Auxiliary Space: O(Height of the BST).

Constraints:
1<=N<=103

link --> https://practice.geeksforgeeks.org/problems/closest-neighbor-in-bst/1#
"""

"""using INORDER TRAVERSAL"""

def findMaxForN(root,N):
    if root == None:
        return 0
    li = []
    cur = root
    p = 0
    while cur or li:
        if cur:
            li.append(cur)
            cur = cur.left
        else:
            cur = li.pop()
            if cur.key <= N and p < cur.key: 
                p = cur.key
            cur = cur.right
    return p

"""better approach completely not correct"""
def findMaxforN(root, N):
     
    # Start from root and keep looking for larger 
    while (root != None and root.right != None):
         
        # If root is smaller go to right side
        if (N > root.key and N >= root.right.key):
            root = root.right
 
        # If root is greater go to left side
        elif (N < root.key):
            root = root.left
        else:
            break
         
    if (root == None or root.key > N):
        return -1
    else:
        return root.key