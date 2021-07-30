/* """
Word Search 
Medium Accuracy: 50.15% Submissions: 4873 Points: 4
Given a 2D board of letters and a word. Check if the word exists in the board. The word can be constructed from letters of adjacent cells only. ie - horizontal or vertical neighbors. The same letter cell can not be used more than once.
 

Example 1:

Input: board = {{a,g,b,c},{q,e,e,l},{g,b,k,s}},
word = "geeks"
Output: 1
Explanation: The board is-
a g b c
q e e l
g b k s
The letters which are used to make the
"geeks" are colored.
Example 2:

Input: board = {{a,b,c,e},{s,f,c,s},{a,d,e,e}},
word = "sabfs"
Output: 0
Explanation: The board is-
a b c e
s f c s
a d e e
Same letter can not be used twice hence ans is 0
 

Your Task:
You don't need to read or print anything. Your task is to complete the function isWordExist() which takes board and word as input parameter and returns boolean value true if word can be found otherwise returns false.
 

Expected Time Complexity: O(N * M * 4L) where N = No. of rows in board, M = No. of columns in board, L = Length of word
Expected Space Compelxity: O(L), L is length of word.
 

Constraints:
1 ≤ N, M ≤ 100
1 ≤ L ≤ N*M

link --> https://practice.geeksforgeeks.org/problems/word-search/1#
https://leetcode.com/problems/word-search/
"""
 */
class Solution {
    public boolean exist(char[][] board, String word) {
        for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board[0].length; c++){
                if ((board[r][c] == word.charAt(0))){
                    if (dfs(r,c,0, board, word) )return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int r, int c, int cnt, char[][] board, String word){
        if (cnt == word.length()){ return true;}
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || 
              board[r][c] != word.charAt(cnt) ) {return false;}
        
        char temp = board[r][c];
        board[r][c] = ' ';
        // here the reason to remove the element is to make sure it doesnt' again consider this as a part.
        boolean found = (dfs(r + 1, c , cnt + 1, board, word) ||
                     dfs(r - 1, c , cnt + 1, board, word) ||
                    dfs(r, c + 1, cnt + 1, board, word) ||                    
                        dfs(r, c - 1, cnt + 1, board, word));

        board[r][c] = temp;
        return found;
    }
}