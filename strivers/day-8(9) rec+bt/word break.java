/*
139. Word Break

139. Word Break
Medium

7530

354

Add to List

Share
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 

Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
Accepted
823,346
Submissions
1,928,950

link --> https://leetcode.com/problems/word-break/

*/


// backtacking
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
      // assume s and wordDict are non-empty
      return bt(0, s, new HashSet(wordDict));
    }

    private boolean bt(int start, String s, Set<String> wordSet) {

        if (start == s.length()) return true;

        for (int i = start; i < s.length(); ++i) {
            String str = s.substring(start, i + 1); // substring[depth, i]
            if (wordSet.contains(str)) 
                if (bt(i + 1, s, wordSet)) return true;
        } 

        return false;
    }
}
// better app. BUT TLE memorization
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
      boolean[] memo = new boolean[s.length()];
      return bt(0, s, new HashSet(wordDict), memo);
    }

    private boolean bt(int start, String s, Set<String> wordSet,boolean[] memo ) {

        if (start == s.length()) return true;
        if ((memo[start])) return memo[start];
        for (int i = start; i < s.length(); i++) {
            String str = s.substring(start, i + 1); // substring[depth, i]
            if (wordSet.contains(str)) 
                if (bt(i + 1, s, wordSet, memo)) return true;
        } 
        memo[start] = false;
        return false;
    }
}

// using pure dp
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
      // assume s and wordDict are non-empty
      Set<String> set = new HashSet<>(wordDict);

      boolean[] dp = new boolean[s.length() + 1];
      dp[0] = true; // consider the begining! ("" + "a")
  
      for (int i = 1; i <= s.length(); ++i) { // for each length
        for (int j = 0; j < i; ++j) {
          if (dp[j] && set.contains(s.substring(j, i))) {
            dp[i] = true;
            break;}
        }
      }

        return dp[s.length()];
    }
}
