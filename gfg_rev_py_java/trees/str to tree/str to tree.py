"""
Convert Ternary Expression to Binary Tree 

Easy Accuracy: 53.16% Submissions: 11919 Points: 2
Given a string that contains ternary expressions. The expressions may be nested. You need to convert the given ternary expression to a binary Tree and return the root.

Example 1:

Input: a?b:c
Output: a b c
Explanation:
string expression = a?b:c
So the binary tree for the above expression is:
       a  
     /   \   
    b     c
Example 2:

Input: a?b?c:d:e
Output: a b c d e
Explanation:
string expression =  a?b?c:d:e
So the binary tree for the above expression is:
                  a
                /   \
               b     e
             /   \
            c     d
 

Your Task:
This is a function problem, you don't need to read input/output. Just complete the function convertExpression() that take string and index(initialized from 0) as parameters and returns the root node of the binary tree

Constraints:
1 <= T <= 100
1 <= |String| <= 100

link --> https://practice.geeksforgeeks.org/problems/convert-ternary-expression-to-binary-tree/1#"

"""


def convert_expression(expression, i):
    return cnv(expression, 0)
    
def cnv(expression, i):
    if i >= len(expression):
        return None

    node = Node(expression[i])
    i += 1
    if i < len(expression) and expression[i] is '?':
        node.left = cnv(expression, i + 1)
    elif i < len(expression):
        node.right = cnv(expression, i + 1)

    return node