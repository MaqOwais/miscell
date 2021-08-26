/*
106. Construct Binary Tree from Inorder and Postorder Traversal
Medium

Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: inorder = [-1], postorder = [-1]
Output: [-1]
 
link --> https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
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
    int ind;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        ind = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) hm.put(inorder[i],i);
        return build(postorder, 0, postorder.length - 1);
    }
    private TreeNode build(int[] P, int st, int end){
        if (st > end || ind < 0) return null;
        TreeNode node = new TreeNode(P[ind--]);
        
        int split = hm.get(node.val);
        node.right = build(P, split + 1, end);
        node.left = build(P, st, split - 1);
        return node;
    }
}

