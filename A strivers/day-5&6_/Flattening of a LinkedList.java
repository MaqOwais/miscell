/*

430. Flatten a Multilevel Doubly Linked List
Medium

2552

200

Add to List

Share
You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.

Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.

 

Example 1:

Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
Output: [1,2,3,7,8,11,12,9,10,4,5,6]
Explanation:

The multilevel linked list in the input is as follows:



After flattening the multilevel linked list it becomes:


Example 2:

Input: head = [1,2,null,3]
Output: [1,3,2]
Explanation:

The input multilevel linked list is as follows:

  1---2---NULL
  |
  3---NULL
Example 3:

Input: head = []
Output: []
 

How multilevel linked list is represented in test case:

We use the multilevel linked list from Example 1 above:

 1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL
The serialization of each level is as follows:

[1,2,3,4,5,6,null]
[7,8,9,10,null]
[11,12,null]
To serialize all levels together we will add nulls in each level to signify no node connects to the upper node of the previous level. The serialization becomes:

[1,2,3,4,5,6,null]
[null,null,7,8,9,10,null]
[null,11,12,null]
Merging the serialization of each level and removing trailing nulls we obtain:

[1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 

Constraints:

The number of Nodes will not exceed 1000.
1 <= Node.val <= 105
Accepted
172,450
Submissions
300,621

link --> https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/

*/


class Solution {
    Node end = null;
    public Node flatten(Node head) {
        if(head == null) return end;
		// 0. head -> flatten(head.child) -> flatten(head.next) -> end 
		// 1. flatten(head.next) -> end 
        end = flatten(head.next);
		// 2. head -> flatten(head.child) 
        head.next = flatten(head.child);
		// 3. flatten(head.child) -> flatten(head.next)
        if(head.next != null) head.next.prev = head;
        head.child = null;
        return head;
    }
}

// stack 

class Solution {
    public Node flatten(Node head) {
        if(head == null){
            return head;
        }
        
        Node dummyHead = head;
        
        Stack<Node> stack = new Stack<>();
        
        while(!stack.isEmpty() || head!=null){
            if(head!=null && head.child!=null){
                if(head.next != null){
                    stack.push(head.next);
                }
                head.child.prev = head;
                head.next = head.child;
                head.child = null;
            }
            else if(head!=null && head.next == null && !stack.isEmpty()){
                Node temp = stack.pop();
                if(temp != null){
                    head.next = temp;
                    temp.prev = head;
                }
            }
            if(head!=null){
                head = head.next;
            }
            else if(!stack.isEmpty()){
                stack.pop();
            }
        }
        
        return dummyHead;
    }
    
}

// 2ptr

// O(n) time, O(1) space (where n is the total number of nodes in the linked list).

// We traverse until we find a node with a child - let's call it parent. From here, we set up a few variables: the parent's original next node, and the parent's child. Additionally, we traverse the child list to find its last node. First, we clear the parent's child pointer. Now it's just a matter of joining three lists, with the second spliced in-between the first and the third. We take care to check that our third list is not null. And finally, we repeat this process until we're at the end of the list.

public Node flatten(Node head) {
        Node curr = head;
        
        while (curr != null) {
            if (curr.child == null) {
                curr = curr.next;
            } else {
                Node parent = curr;
                Node parentNext = parent.next;
                Node child = curr.child;
                Node childLast = child;
                parent.child = null;
                while (childLast != null && childLast.next != null) {
                    childLast = childLast.next;
                }
                parent.next = child;
                child.prev = parent;
                childLast.next = parentNext;
                if (parentNext != null) {
                    parentNext.prev = childLast;
                }
            }
        }
        
        return head;
}

// I think we could optimize this solution in the case where the child list has its own child list and splice that list in before continuing with the original.

