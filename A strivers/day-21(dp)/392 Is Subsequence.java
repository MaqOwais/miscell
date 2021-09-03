/*
392. Is Subsequence
Easy

Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

 

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
 

Constraints:

0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.
 

Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?

link --> https://leetcode.com/problems/is-subsequence/

*/

class Solution {
    public boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length(); i++)
            for (int j = 0; j < t.length(); j++)
                dp[i + 1][j + 1] = (s.charAt(i) == t.charAt(j)) ? dp[i][j] + 1 : 
                                        Math.max(dp[i + 1][j] , dp[i][j + 1]);

        return (dp[s.length()][t.length()] == s.length());
    }
}


class Solution {
    public boolean isSubsequence(String s, String t) {
        int p1 = 0, p2 = 0;
        while (p1 < s.length() && p2 < t.length())
            if (s.charAt(p1) == t.charAt(p2++)) p1++;
        return p1 == s.length();
    }
}

