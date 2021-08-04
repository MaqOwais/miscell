/*
234. Palindrome Linked List
Easy

6009

461

Add to List

Share
Given the head of a singly linked list, return true if it is a palindrome.

 

Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false
 

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
 

Follow up: Could you do it in O(n) time and O(1) space?

link --> https://leetcode.com/problems/palindrome-linked-list/
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = slow.next, prev = null;

        while (fast != null){
            if (fast.next == null) break;
            slow = slow.next;
            fast = fast.next.next;
        }
        while (slow !=null){
            ListNode nxt = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nxt;
        }
        while (head != null && prev != null){
            if (head.val != prev.val) return false;
            if (head == prev) break;
            head = head.next;
            prev = prev.next;
        }
        
        return true;
    }
}