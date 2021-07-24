"""
Add Strings
Easy

Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.

Example 1:

Input: num1 = "11", num2 = "123"
Output: "134"
Example 2:

Input: num1 = "456", num2 = "77"
Output: "533"
Example 3:

Input: num1 = "0", num2 = "0"
Output: "0"
 

Constraints:

1 <= num1.length, num2.length <= 104
num1 and num2 consist of only digits.
num1 and num2 don't have any leading zeros except for the zero itself.

link --> https://leetcode.com/problems/add-strings/
"""
import java.math.BigInteger;
class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0, p1 = num1.length() - 1 , p2 = num2.length() -1;
        String ans = "";
        while( p1>= 0|| p2>= 0){
            
            int o1 = (p1>=0)? (Integer.valueOf(num1.charAt(p1)))-'0':(0);
            int o2 = (p2>=0) ? (Integer.valueOf(num2.charAt(p2)))-'0':(0);
            int tot = o1 + o2 + carry;
            if (tot > 9){
                tot -= 10;
                carry = 1;
            }else{
                carry = 0;
            }
            
            ans = Integer.toString(tot) + ans;
            
            p1--;p2--;
        }
        if (carry>0){
            ans = Integer.toString(carry) + ans;
        }
        return ans;
    }
}

