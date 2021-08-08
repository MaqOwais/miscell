/*

61. Rotate List
Medium

2853

1182

Add to List

Share
Given the head of a linked list, rotate the list to the right by k places.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:


Input: head = [0,1,2], k = 4
Output: [2,0,1]
 

Constraints:

The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109
Accepted
408,045
Submissions
1,253,476

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
    private int getLen(ListNode head){
        int cntr = 0;
        while(head != null){
            head = head.next;
            cntr += 1;
        }
        return cntr;
    }
    
    public ListNode rotateRight(ListNode head, int k) {
        int n = getLen(head);
        if (n > 0) k = k%n;
        if (head == null) return null;
        if (head.next == null || k == 0) return head;
        ListNode second = head;
        ListNode first = head;
        ListNode scNxt = second.next;

        for (int i = 0; i < k; i++){
            first = first.next;
        }

        while( first.next!= null ){
            first = first.next;
            second = second.next;
            scNxt = second.next;
        }
        first.next = head;
        second.next = null;
        return scNxt;
    }
}