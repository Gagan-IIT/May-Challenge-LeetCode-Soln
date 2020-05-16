/* PROBLEM:
Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.

Here, a circular array means the end of the array connects to the beginning of the array.  
(Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)

Also, a subarray may only include each element of the fixed buffer A at most once.  
(Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)

Example 1:
Input: [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3

Example 2:
Input: [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10

Example 3:
Input: [3,-1,2,-1]
Output: 4
Explanation: Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4

Example 4:
Input: [3,-2,2,-3]
Output: 3
Explanation: Subarray [3] and [3,-2,2] both have maximum sum 3

Example 5:
Input: [-2,-3,-1]
Output: -1
Explanation: Subarray [-1] has maximum sum -1
 
Note:
-30000 <= A[i] <= 30000
1 <= A.length <= 30000
*/

class Solution {
    static int kadane(int[] A){
        int gMax = A[0];
        int cMax = A[0];
        for(int i=1; i<A.length; i++){
            cMax = Math.max(cMax+A[i], A[i]);
            if(cMax>gMax) gMax=cMax;
        }
        return gMax;
    }
    
    static int ifAllNegative(int[] A){
        // if all numbers of array are -ve, this returns the max no (a -ve no), else returns 0
        int max = Integer.MIN_VALUE;
        boolean positive = false;
        for(int i=0; i<A.length; i++){
            if(A[i]<0){
                if(A[i]>max) max = A[i];
            }else{
                positive=true;
                break;
            }
        }
        if(positive) return 0;
        return max;
    }
    
    public int maxSubarraySumCircular(int[] A) {
        int n = A.length;
        if(n==1) return A[0];
        
        int neg = ifAllNegative(A);     // if all the elements are negative
        if(neg!=0) return neg;          // then return maximum element
        
        int totalSum = 0;
        int[] B = new int[n];
        for(int i=0; i<n; i++){
            B[i] = 0-A[i];
            totalSum+=A[i];   
        }
        int max1 = kadane(A);
        int max2 = totalSum + kadane(B);
        return Math.max(max1, max2);        
    }
}
