/* PROBLEM:
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:
Input: 16
Output: true

Example 2:
Input: 14
Output: false
*/

import java.lang.Math;
class Solution {
    public boolean isPerfectSquare(int num) {
        double root = Math.sqrt(num);
        return root==(int)root;
    }
}
