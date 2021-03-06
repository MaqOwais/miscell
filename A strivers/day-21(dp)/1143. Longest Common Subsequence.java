/*
1143. Longest Common Subsequence
Medium

Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 

Constraints:

1 <= text1.length, text2.length <= 1000
text1 and text2 consist of only lowercase English characters.
Accepted
245,654
Submissions
417,694

link --> https://leetcode.com/problems/longest-common-subsequence/
*/

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < text1.length(); i++) 
            for (int j = 0; j < text2.length(); j++)
                dp[i+1][j+1] = (text1.charAt(i) == text2.charAt(j)) ? dp[i][j] + 1:
                                    Math.max(dp[i+1][j], dp[i][j+1]); 

        return dp[text1.length()][text2.length()];
    }
}

class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length() ][text2.length() ];
        return helper(text1, text2, 0, 0);
    }
    private int helper(String s1, String s2, int i1, int i2){
        if (i1 == s1.length() || i2 == s2.length()) return 0;
        if (dp[i1][i2] > 0) return dp[i1][i2];

        dp[i1][i2] = (s1.charAt(i1) == s2.charAt(i2)) ? (1 + helper(s1, s2, i1 + 1, i2 + 1)):
                            Math.max(helper(s1, s2, i1 + 1, i2), helper(s1, s2, i1, i2 + 1));
        return dp[i1][i2];        
    }
}