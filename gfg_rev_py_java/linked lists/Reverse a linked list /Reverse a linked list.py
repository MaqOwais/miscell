"""
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
"""

# Node Class

class node:
    def __init__(self, val):
        self.data = val
        self.next = None


class Solution:
    #Function to reverse a linked list.
    def reverseList(self, head):
        if not head:
            return None
        pre = None
        cur = head
        while cur:
            nxt= cur.next
            cur.next = pre
            pre = cur
            cur = nxt
        head = pre
        return head


# recursive approach (https://www.youtube.com/watch?v=MRe3UsRadKw&ab_channel=IDeserve)
 
def reverse(self, head):
 
    # If head is empty or has reached the list end
    if head is None or head.next is None:
        return head

    # Reverse the rest list
    cur = self.reverse(head.next)

    # Put first element at the end
    head.next.next = head
    head.next = None

    # Fix the header pointer
    return cur