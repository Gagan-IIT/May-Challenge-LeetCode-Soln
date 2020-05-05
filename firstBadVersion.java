/*
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

Example:

Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version.
*/

/* The below code contains the function definition required by the problem
   The function we had to write is firstBadVersion
   The isBadVersion API is defined in the parent class VersionControl.
   boolean isBadVersion(int version); 
*/



import java.lang.Math;

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return firstBadVersionUtil(n, 0);
    }
    
    public int firstBadVersionUtil(int n, int k) {
        if(n==0) return 0;
        if(n==1) return 1;
        int v = 1;
        if(isBadVersion(k+v))
            return v;
        int i = 1;
        int t=0;
        while(v<n){
            t=v;
            v+=Math.pow(2, i);
            if(v<=n){
                if(isBadVersion(k+v)) break;
                else i+=1;
            }
            else break; 
        }
        return t + firstBadVersionUtil(n-t, k+t);
    }
}
