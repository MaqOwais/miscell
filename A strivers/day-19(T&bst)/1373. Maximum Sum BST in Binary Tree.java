/*
1373. Maximum Sum BST in Binary Tree
Hard

Given a binary tree root, return the maximum sum of all keys of any sub-tree which is also a Binary Search Tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:



Input: root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
Output: 20
Explanation: Maximum sum in a valid Binary search tree is obtained in root node with key equal to 3.
Example 2:



Input: root = [4,3,null,1,2]
Output: 2
Explanation: Maximum sum in a valid Binary search tree is obtained in a single root node with key equal to 2.
Example 3:

Input: root = [-4,-2,-5]
Output: 0
Explanation: All values are negatives. Return an empty BST.
Example 4:

Input: root = [2,1,3]
Output: 6
Example 5:

Input: root = [5,4,8,3,null,6,3]
Output: 7
 

Constraints:

The number of nodes in the tree is in the range [1, 4 * 104].
-4 * 104 <= Node.val <= 4 * 104
Accepted
20,530
Submissions
54,736


link --> https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
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
    int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        helper(root);
        return maxSum;
    }
    // int[0]: 0: is not bst, 1: is bst;
    // int[1]: next leftMax, meaningly now max
    // int[2]: next rightMin, meaningly now min
    // int[4]: int[0] == 1 ? sum : 0;

    private int[] helper(TreeNode node) {
        if (node == null) {
            return new int[]{1, Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        }
        int[] left = helper(node.left);
        int[] right = helper(node.right);
        if (left[0] == 1 && right[0] == 1 && left[1] < node.val && node.val < right[2]) {
            maxSum = Math.max(maxSum, left[3]+right[3]+node.val);
            return new int[]{1, Math.max(right[1], node.val), Math.min(left[2], node.val), sum}; 
        }
        return new int[]{0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
    }
}



// LTE
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
    int mx = 0;
    public int maxSumBST(TreeNode root) {
        if (root == null) return 0;
        if (isBst(root, Long.MAX_VALUE, Long.MIN_VALUE)) mx = Math.max(mx, sum(root));
        maxSumBST(root.right);
        maxSumBST(root.left);
        return mx;
    }
    private boolean isBst(TreeNode root, long max, long min){
        if (root == null) return true;
        if (root.val >= max || root.val <= min) return false;
        return isBst(root.right, max, root.val) && isBst(root.left, root.val, min);
    }
    private int sum(TreeNode root){
        if (root == null) return 0;
        return sum(root.right) + sum(root.left) + root.val;
    }
}