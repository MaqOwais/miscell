/*
50. Pow(x, n)
Medium

2772

4088

Add to List

Share
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

 

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 

Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
-104 <= xn <= 104

LINK --> https://leetcode.com/problems/powx-n/
*/


// best soln.
class Solution {
    public double myPow(double x, int n) {
        long m = n > 0 ? n : -(long) n;
        double ans = 1.0;
        while (m != 0) {
            if ((m & 1) == 1) // check if m is odd number OR (m % 2 != 0) CAN BE USED
                ans *= x;
            x *= x;
            m >>= 1; // OR m /= 2; can also be used
        }
        return n >= 0 ? ans : 1 / ans;
    }
}


// NOT CORRECT WAY OF DOING
class Solution {
    public double myPow(double x, int n) {        
        return Math.pow(x, n);
    }
}