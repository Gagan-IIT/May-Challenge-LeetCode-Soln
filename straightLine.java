/* PROBLEM:
You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

Example 1:
Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true

Example 2:
Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false
 

Constraints:
2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates contains no duplicate point.
*/

class Solution {
    public boolean checkStraightLine(int[][] c) {
        int n = c.length;
        if(n<=2) return true;
        double m1 = (c[1][1]-c[0][1])/(double)(c[1][0]-c[0][0]);
        for(int i=2;i<n;i++){
            double m2 = (c[i][1]-c[0][1])/(double)(c[i][0]-c[0][0]);
            if(m2!=m1) return false;
        }
        return true;
    }
}
