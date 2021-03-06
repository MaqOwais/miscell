"""
Reverse a Linked List in groups of given size. 
Medium Accuracy: 45.83% Submissions: 93283 Points: 4
Given a linked list of size N. The task is to reverse every k nodes (where k is an input to the function) in the linked list.

Example 1:

Input:
LinkedList: 1->2->2->4->5->6->7->8
K = 4
Output: 4 2 2 1 8 7 6 5 
Explanation: 
The first 4 elements 1,2,2,4 are reversed first 
and then the next 4 elements 5,6,7,8. Hence, the 
resultant linked list is 4->2->2->1->8->7->6->5.
Example 2:

Input:
LinkedList: 1->2->3->4->5
K = 3
Output: 3 2 1 5 4 
Explanation: 
The first 3 elements are 1,2,3 are reversed 
first and then elements 4,5 are reversed.Hence, 
the resultant linked list is 3->2->1->5->4.
Your Task:
You don't need to read input or print anything. Your task is to complete the function reverse() which should reverse the linked list in group of size k and return the head of the modified linked list.

Expected Time Complexity : O(N)
Expected Auxilliary Space : O(1)

Constraints:
1 <= N <= 104
1 <= k <= N

link --> https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1#
"""

class Solution:
    def reverse(self,head, k):
        cur = head
        prev = None
        p = k
        while p > 0 and cur:
            nxt = cur.next
            cur.next = prev
            prev = cur
            cur = nxt
            p -= 1
        if nxt:
            head.next = self.reverse(nxt, k)
        return prev