"""
Valid Palindrome II
Easy

Given a string s, return true if the s can be palindrome after deleting at most one character from it.

Example 1:

Input: s = "aba"
Output: true
Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
Example 3:

Input: s = "abc"
Output: false

link: https://leetcode.com/problems/valid-palindrome-ii/
"""
class Solution {
    public boolean isPalin(String s){
        int i = 0, j = s.length() - 1;
        while (i < j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j){
            if (s.charAt(i) != s.charAt(j)){
                return isPalin(s.substring(i,j))||isPalin(s.substring(i+1,j+1));
            }
            i++;
            j--;
        }
        return true;
        
        
    }
}