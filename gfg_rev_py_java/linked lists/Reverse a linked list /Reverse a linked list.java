/*"""
Reverse a linked list 
Easy Accuracy: 48.93% Submissions: 100k+ Points: 2
Given a linked list of N nodes. The task is to reverse this list.

Example 1:

Input:
LinkedList: 1->2->3->4->5->6
Output: 6 5 4 3 2 1
Explanation: After reversing the list, 
elements are 6->5->4->3->2->1.
Example 2:

Input:
LinkedList: 2->7->8->9->10
Output: 10 9 8 7 2
Explanation: After reversing the list,
elements are 10->9->8->7->2.
Your Task:
The task is to complete the function reverseList() with head reference as the only argument and should return new head after reversing the list.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 104

link --> https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1#
"""*/

class Solution
{
    //Function to reverse a linked list.
    Node reverseList(Node head)
    {
        Node cur = head;
        Node prev = null;
        
        while (cur != null){
            Node nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        head = prev;
        
        return head;
         
    }
}

class recursion {
    static Node head; // head of list
     
    static class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
 
    static Node reverse(Node head)
    {
        if (head == null || head.next == null)
            return head;
 
        /* reverse the rest list and put
        the first element at the end */
        Node cur = reverse(head.next);
        head.next.next = head;
  
        /* tricky step -- see the diagram */
        head.next = null;
 
        /* fix the head pointer */
        return cur;
    }}