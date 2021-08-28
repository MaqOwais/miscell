/*
671. Second Minimum Node In a Binary Tree
Easy

Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

 

 

Example 1:


Input: root = [2,2,5,null,null,5,7]
Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.
Example 2:


Input: root = [2,2,2]
Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.
 

Constraints:

The number of nodes in the tree is in the range [1, 25].
1 <= Node.val <= 231 - 1
root.val == min(root.left.val, root.right.val) for each internal node of the tree.
Accepted
113,255
Submissions
263,082

link --> https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
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
    public int findSecondMinimumValue(TreeNode root) {
        Stack<TreeNode> st = new Stack();
        HashSet<Integer> hs = new HashSet();
        st.push(root);

        while ( root != null || !st.isEmpty()){
            if (root != null){
                st.push(root);
                hs.add(root.val);
                root = root.left;
            }else{
            root = st.pop();
            hs.add( root.val);
            root = root.right;}
        }
        ArrayList<Integer> al = new ArrayList(hs);
		Collections.sort(al);
		return (al.size() == 1) ? -1 : al.get(1);
    }
}

// recursive
class Solution 
  {
	HashSet<Integer> hs = new  HashSet<Integer>();
	public int findSecondMinimumValue(TreeNode root) 
	{
		pre(root);
		ArrayList<Integer> al = new ArrayList<Integer>(hs);
		Collections.sort(al);
		if(al.size()==1)
        return -1;
		return al.get(1);
	}
	public void pre(TreeNode root)
	{
		if(root==null)
        return ;
		pre(root.left);
		hs.add(root.val);
		pre(root.right);
	}
}
