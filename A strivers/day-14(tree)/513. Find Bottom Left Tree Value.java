/*
513. Find Bottom Left Tree Value
513. Find Bottom Left Tree Value
Medium

Given the root of a binary tree, return the leftmost value in the last row of the tree.

Example 1:

Input: root = [2,1,3]
Output: 1
Example 2:

Input: root = [1,2,3,4,null,5,6,null,null,7]
Output: 7
 
Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1

link --> https://leetcode.com/problems/find-bottom-left-tree-value/

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
    public int findBottomLeftValue(TreeNode root) {
        if (root.left == null && root.right == null) return root.val ;  
        int[] ans = new int[2];
        findbot(root, ans, 0);
        return ans[0];
    }
    private void findbot(TreeNode root, int[] ans, int dep){
        if (root != null){
            if (dep > ans[1]) { 
                // keeping track of left most tree part
                ans[1] = dep;
                ans[0] = root.val; 
            }
            // here left should come 1st
            findbot(root.left, ans, dep + 1);
            findbot(root.right, ans, dep + 1);
        }
    }
}