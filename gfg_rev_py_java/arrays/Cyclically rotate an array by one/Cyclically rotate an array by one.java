"""
Cyclically rotate an array by one 
Basic Accuracy: 64.05% Submissions: 40278 Points: 1
Given an array, rotate the array by one position in clock-wise direction.
 

Example 1:

Input:
N = 5
A[] = {1, 2, 3, 4, 5}
Output:
5 1 2 3 4
 

Example 2:

Input:
N = 8
A[] = {9, 8, 7, 6, 4, 2, 1, 3}
Output:
3 9 8 7 6 4 2 1
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function rotate() which takes the array A[] and its size N as inputs and modify the array.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

 

Constraints:
1<=N<=105
0<=a[i]<=105

link --> https://practice.geeksforgeeks.org/problems/cyclically-rotate-an-array-by-one2614/1
"""

class Compute {
    
    public void rotate(int arr[], int n)
    {
        int l = n - 1;
        for (int i = 0; i <= l; i++){
            int temp = arr[i];
            arr[i] = arr[l];
            arr[l] = temp;
        }
    }
}