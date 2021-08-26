/*
105. Construct Binary Tree from Preorder and Inorder Traversal
Medium

Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 

Constraints:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.

link --> https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/


*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<Integer, Integer> hm = new HashMap();
    int ind = 0;

    public TreeNode buildTree(int[] P, int[] I) {
        for (int i = 0; i < I.length; i++) hm.put(I[i], i);
        return build(P, 0, P.length - 1);
    }
    private TreeNode build(int[] P,int st, int end){
        if (st > end) return null;
        TreeNode node = new TreeNode(P[ind++]);
        int split = hm.get(node.val);
        node.left = build(P, st, split - 1);
        node.right = build(P, split + 1, end);
        return node;
    }
}