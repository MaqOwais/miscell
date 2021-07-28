/*
Remove loop in Linked List 
Medium Accuracy: 47.96% Submissions: 100k+ Points: 4
Given a linked list of N nodes such that it may contain a loop.

A loop here means that the last node of the link list is connected to the node at position X. If the link list does not have any loop, X=0.

Remove the loop from the linked list, if it is present.  


Example 1:

Input:
N = 3
value[] = {1,3,4}
X = 2
Output: 1
Explanation: The link list looks like
1 -> 3 -> 4
     ^    |
     |____|    
A loop is present. If you remove it 
successfully, the answer will be 1. 

Example 2:

Input:
N = 4
value[] = {1,8,3,4}
X = 0
Output: 1
Explanation: The Linked list does not 
contains any loop. 

Your Task:
You don't need to read input or print anything. Your task is to complete the function removeLoop() which takes the head of the linked list as input parameter. Simply remove the loop in the list (if present) without disconnecting any nodes from the list.
Note: The generated output will be 1 if your submitted code is correct.


Expected time complexity : O(N)
Expected auxiliary space : O(1)


Constraints:
1 ≤ N ≤ 104

link --> https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1#
*/



class Solution
{
    //Function to remove a loop in the linked list.
    public static void removeLoop(Node head){
        HashMap<Node, Integer> hsh = new HashMap<>();
        while (head != null){
            if (hsh.containsKey(head.next)){
                head.next = null;
                break;
            }
            hsh.put(head, 1);
            head = head.next;
        }
    }}

// """more simplified"""
class Solution
{
    public static void removeLoop(Node head){
        HashMap<Node, Integer> hsh = new HashMap<>();
        while (head != null){
            if (hsh.containsKey(head.next)) head.next = null;
            hsh.put(head, 1); head = head.next;
        }
    }}