/*
543. Diameter of Binary Tree
Easy

5524

335

Add to List

Share
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

 

Example 1:


Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:

Input: root = [1,2]
Output: 1
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100
Accepted
533,191
Submissions
1,044,010

link --> https://leetcode.com/problems/diameter-of-binary-tree/
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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
            int[] ans = new int[1];
            height(root, ans);
            return ans[0] - 1; // since we need edges b/w them hence '-1'
    }
    public int height(TreeNode root, int[] ans){
        if(root == null) return 0;

        int L = height(root.left, ans);
        int R = height(root.right, ans);
        //ans signfies(no. of nodes farthest apart) or the DIAMETER
        ans[0] = Math.max(ans[0], L + R + 1);
        //height of the tree is max of LST & RST +1
        return 1 + Math.max(L, R);
    }
}