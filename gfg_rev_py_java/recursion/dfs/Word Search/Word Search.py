"""
Word Search 
Medium Accuracy: 50.15% Submissions: 4873 Points: 4
Given a 2D board of letters and a word. Check if the word exists in the board. The word can be constructed from letters of nodeacent cells only. ie - horizontal or vertical neighbors. The same letter cell can not be used more than once.
 

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
"""


class Solution:
	def isWordExist(self, board, word):
	    rows, col = len(board), len(board[0])

        def dfs(r, c, cnt):
            if cnt == len(word): return 1
            if (r < 0 or c < 0 or
                r >= rows or c >= col or
                board[r][c] != word[cnt] ): return 0

            temp = board[r][c]
		    board[r][c] = ""
            # here the reason to remove the element is to make sure it doesnt' again consider this as a part.
            found = (dfs(r + 1, c, cnt + 1) or
                    dfs(r, c + 1, cnt + 1) or
                    dfs(r - 1, c, cnt + 1) or
                    dfs(r, c - 1, cnt + 1))
            board[r][c] = temp
            return found

        for r in range(rows):
            for c in range(col):
                if board[r][c] == word[0]:
                    if dfs(r, c, 0): return 1
        
        return 0 

# similar soln. using set for storing intermediate and removing it
class Solution:

    def isWordExist(self, board, word):

        rows, col = len(board), len(board[0])
        path = set()
        def dfs(r,c, cnt):
            if cnt == len(word): return 1
            if (r < 0 or c < 0 or
                r >= rows or c >= col or
                board[r][c] != word[cnt] or 
                (r,c) in path): return 0

          #  temp = board[r][c]
            path.add((r,c))
            found = (dfs(r + 1, c, cnt + 1) or
                    dfs(r, c + 1, cnt + 1) or
                    dfs(r - 1, c, cnt + 1) or
                    dfs(r, c - 1, cnt + 1))
            path.remove((r,c))
            return found

        for r in range(rows):
            for c in range(col):
                if board[r][c] == word[0]:
                    if dfs(r, c, 0): return 1
        
        return 0 


class Solution:

    def isWordExist(self, board, word):
        #Code here
        rows, col = len(board), len(board[0])
        path = set()
        
        def dfs(r, c, i):
            if i == len(word):
                return True

            if (r < 0 or c < 0 or
                r >= rows or c >= col or 
                board[r][c] != word[i] or
                (r, c) in path):
                return False
            path.add((r,c))
            res = (dfs(r + 1, c, i + 1) or
                    dfs(r, c + 1, i + 1) or
                    dfs(r - 1, c, i + 1) or
                    dfs(r, c - 1, i + 1))
            path.remove((r,c))
            return res
        
        for r in range(rows):
            for c in range(col):
                if dfs(r, c, 0): return 1
            
        return 0