/*
138. Copy List with Random Pointer
Medium

5775

853

Add to List

Share
A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.

 

Example 1:


Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
Example 2:


Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]
Example 3:



Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]
Example 4:

Input: head = []
Output: []
Explanation: The given linked list is empty (null pointer), so return null.
 

Constraints:

0 <= n <= 1000
-10000 <= Node.val <= 10000
Node.random is null or is pointing to some node in the linked list.
Accepted
605,514
Submissions
1,401,590

link --> https://leetcode.com/problems/copy-list-with-random-pointer/

*/

// pointers 

class Solution {
    public Node copyRandomList(Node head) {
        Node iter = head, next;

      // First round: make copy of each node,
      // and link them together side-by-side in a single list.
      while (iter != null) {
        next = iter.next;

        Node copy = new Node(iter.val);
        iter.next = copy;
        copy.next = next;

        iter = next;
      }

      // Second round: assign random pointers for the copy nodes.
      iter = head;
      while (iter != null) {
        if (iter.random != null) iter.next.random = iter.random.next;
        iter = iter.next.next;
      }

      // Third round: restore the original list, and extract the copy list.
      iter = head;
      Node newH = new Node(0);
      Node copy, copyIter = newH;

      while (iter != null) {
        next = iter.next.next;

        // extract the copy
        copy = iter.next;
        copyIter.next = copy;
        copyIter = copy;

        // restore the original list
        iter.next = next;

        iter = next;
      }

      return newH.next;
    }
}


// hashmap 
class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> mp = new HashMap();
        Node cur = head;
        Node copy = new Node(0);
        Node c_cur = copy;

        while (cur != null){
            c_cur.next = new Node(cur.val);
            c_cur = c_cur.next;
            mp.put(cur, c_cur);
            cur = cur.next;
        }
        cur = head;
        c_cur = copy.next;

        while (cur != null){
            c_cur.random = mp.get(cur.random);
            cur = cur.next;
            c_cur = c_cur.next;   
        }
        return copy.next;
    }
}

// recursion
class Solution {
    HashMap<Node, Node> hashMap = new HashMap<Node, Node>();
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Node newHead = new Node(head.val, head.next, head.random);
        hashMap.put(head, newHead);
        newHead.next = copyRandomList(head.next);
        newHead.random = hashMap.get(head.random);
        return newHead;
    }
}