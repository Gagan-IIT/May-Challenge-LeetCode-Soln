/* PROBLEM:
Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  
The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented 
as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

Example 1:
Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]

Note:
0 <= A.length < 1000
0 <= B.length < 1000
0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
*/

import java.util.*;
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i=0, j=0;
        ArrayList< ArrayList<Integer> > res = new ArrayList< ArrayList<Integer> >();
        while(i<A.length && j<B.length){
            int a1 = A[i][0];
            int a2 = A[i][1];
            int b1 = B[j][0];
            int b2 = B[j][1];
            
            if(a2<b1) i++;
            else if(b2<a1) j++;
            else{
                //int[] a = {Math.max(a1, b1), Math.min(a2, b2)};
                //res.add(IntStream.of(a).boxed().collect(Collectors.toCollection(ArrayList::new)));
                ArrayList<Integer> a = new ArrayList<Integer>();
                a.add(Math.max(a1, b1));
                a.add(Math.min(a2, b2));
                res.add(a);
                if(a2<b2) i++;
                else j++;
            }
        }
        int[][] resArr = new int[res.size()][2];
        for( i=0; i<res.size(); i++){
            resArr[i][0] = res.get(i).get(0);
            resArr[i][1] = res.get(i).get(1);
        }
        return resArr;
    }
}
