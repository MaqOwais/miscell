/*Minimum number of jumps 
Medium Accuracy: 32.96% Submissions: 100k+ Points: 4
Given an array of N integers arr[] where each element represents the max number of steps that can be made forward from that element. Find the minimum number of jumps to reach the end of the array (starting from the first element). If an element is 0, then you cannot move through that element.
Note: Return -1 if you cant reach the end of the array.


Example 1:

Input:
N = 11 
arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9} 
Output: 3 
Explanation: 
First jump from 1st element to 2nd 
element with value 3. Now, from here 
we jump to 5th element with value 9, 
and from here we will jump to last. 
Example 2:

Input :
N = 6
arr = {1, 4, 3, 2, 6, 7}
Output: 2 
Explanation: 
First we jump from the 1st to 2nd element 
and then jump to the last element.

Your task:
You dont need to read input or print anything. Your task is to complete function minJumps() which takes the array arr and its size N as input parameters and returns the minimum number of jumps. If not possible returns -1.


Expected Time Complexity: O(N)
Expected Space Complexity: O(1)


Constraints:
1 ≤ N ≤ 107
0 ≤ arri ≤ 107

link --> https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1#
*/


class Solution{
    static int minJumps(int[] arr){
        // base cases
        if (arr.length == 1) return 0;
        if (arr[0] == 0) return -1;
        // init
        int stairs = arr[0];
        int lad = arr[0];
        int jump = 1;
        // range upto just arr.length - 1 since if reaches at last element then no needs
        for (int i = 1; i < arr.length - 1; i++){
            // making up the ladder
            if (lad < arr[i] + i) lad = arr[i] + i;
            stairs--;
            // making up the stairs if finished
            if (stairs == 0){
                jump++;
                stairs = lad - i;
                // if no ladders left  
                if (stairs <= 0) return -1;
            }
        }
        return jump;
    }
}


// simplified version
class Solution1{
    static int minJumps(int[] arr){
        if (arr.length == 1) return 0;
        if (arr[0] == 0) return -1;
        int stairs = arr[0];
        int lad = arr[0];
        int jump = 1;
        for (int i = 1; i < arr.length - 1; i++){
            lad = Math.max(lad, i + arr[i]);
            stairs--;
            if (stairs == 0){
                jump++;
                stairs = lad - i;
                if (stairs <= 0) return -1;
            }
        }
        return jump;
    }