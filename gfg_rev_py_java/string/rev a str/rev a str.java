"""Reverse a String 
Basic Accuracy: 56.22% Submissions: 42791 Points: 1
You are given a string s. You need to reverse the string.

Example 1:

Input:
s = Geeks
Output: skeeG
Example 2:

Input:
s = for
Output: rof
Your Task:

You only need to complete the function reverseWord() that takes s as parameter and returns the reversed string.

Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(1).

Constraints:
1 <= |s| <= 10000

link --> https://practice.geeksforgeeks.org/problems/reverse-a-string/1
"""

class Reverse
{
    // Complete the function
    // str: input string
    public static String reverseWord(String str)
    {
        String s = "";
        for (int i = str.length() - 1; i >=0; i--){
            s += str.charAt(i);
        }
        return s;
    }
}