/*
22. Generate Parentheses
Medium

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8
*/

class Solution {
    List<String> lis = new ArrayList();
    public List<String> generateParenthesis(int n) {
        build("", 0, 0, n);
        return lis;}
    private void build(String str, int open , int close , int max){
        if (str.length() == 2*max){
            lis.add(str);return;
        }
        if (open < max) build(str + "(", open + 1, close, max);
        if (close < open) build(str + ")", open , close + 1, max);
    }
}
