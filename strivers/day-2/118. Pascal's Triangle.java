/*
118. Pascal's Triangle
Easy

3144

149

Add to List

Share
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 

Constraints:

1 <= numRows <= 30
Accepted
546,499
Submissions
940,777

link --> https://leetcode.com/problems/pascals-triangle/

*/

// normal soln. 100% speed

class Solution {
    
    public List<Integer> pascal(int n){
        List<Integer> lis = new ArrayList();
        lis.add(1);
        int prev = 1;
        for (int i = 1; i <= n; i++){
            int cur = prev*(n - i + 1)/(i);
            prev = cur;
            lis.add(cur);
        }
        
        return lis;

    }
    
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ap = new ArrayList();
        
        for (int i = 0; i < numRows; i++){
            ap.add(pascal(i));
        }
        return ap;
    }
}


// other solns' also 100%

public class Solution {
    public List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for(int i=0;i<numRows;i++)
        {
            row.add(0, 1);
            for(int j=1;j<row.size()-1;j++)
                row.set(j, row.get(j)+row.get(j+1));
            allrows.add(new ArrayList<Integer>(row));
        }
        return allrows;
    }
}       