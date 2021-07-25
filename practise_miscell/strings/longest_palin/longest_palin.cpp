"""
Longest Palindromic Substring
Medium

Given a string s, return the longest palindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 3:

Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters (lower-case and/or upper-case)

link --> https://leetcode.com/problems/longest-palindromic-substring/
"""

class Solution {
public:
    bool isPalin(string &s){
        int i = 0, j = s.size() - 1;
        while (i < j){
            if (s[i] != s[j]) return false;
            i++;j--;
        }
        return true;
    }
    string longestPalindrome(string &s) {
        string t = "", maxp = "";
        int n = s.size();
        string P;
        for (int i = 0; i < n; i++){
            t += s[i];
            for (int j = 0; j <= t.size(); j++){
                if (t[j] == s[i]){
                    P = t.substr(j, i+1);
                    // cout<<isPalin(P)<<endl;
                    // cout<<P<<endl;
                    if (isPalin(P) && P.size() > maxp.size()){
                        maxp = P;
                        break;
                    }
            }}
        }
        return maxp;
    }
};

