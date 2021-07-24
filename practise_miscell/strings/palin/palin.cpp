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
public:
    bool isPalin(string &s,int i,int j) {
        while (i < j){
            if (s[i] != s[j]){
                return false;
            }
            i++;j--;
        }
        return true;
    }
    bool validPalindrome(string &s) {
        int i = 0, j = s.size() - 1;
        while (i < j){
            if (s[i] != s[j]){
                return isPalin(s,i,j-1) || isPalin(s,i+1,j);
            }
            i++;j--;}
        return true;
    }
};
