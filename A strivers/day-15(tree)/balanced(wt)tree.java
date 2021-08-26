/*
110. Balanced Binary Tree
Easy

4145

248

Add to List

Share
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:


Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:

Input: root = []
Output: true
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104

link --> https://leetcode.com/problems/balanced-binary-tree/
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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return isBalanced(root.right) && isBalanced(root.left) &&
                    (Math.abs(ht(root.right) - ht(root.left)) < 2 );
    }
    private int ht(TreeNode root){  
        if (root == null) return 0;
        return Math.max(ht(root.left), ht(root.right)) + 1;
    }
}

// public class TreeNode{
//     int va;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(){}
//     TreeNode(int val) {this.va = val;}
//     TreeNode(int val, TreeeNode left, TreeNode right){
//         this.va = val;
//         this.right = right;
//         this.left  = left;
//     }
// }s

// // this is similar to 

// /*
// class TreeNode:
//     def __init__(self, right, left, val):
//         self.right = right;
//         self.left = left;
//         self.val = val;
// */