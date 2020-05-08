/* PROBLEM:
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

 

Example 1:
Input: root = [1,2,3,4], x = 4, y = 3
Output: false

Example 2:
Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true

Example 3:
Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 
Note:
The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static int findDepth(TreeNode root, int n, int depth){
        if(root==null) return -1;
        if(root.val==n) return depth;
        int l = findDepth(root.left, n, depth+1);
        if(l>0) return l;
        return findDepth(root.right, n, depth+1);
    }
    
    public static int findParent(TreeNode root, int n){
        if(root==null) return -1;
        if(root.left!=null && root.left.val==n) return root.val;
        if(root.right!=null && root.right.val==n) return root.val;
        int l = findParent(root.left, n);
        if(l>0) return l;
        return findParent(root.right, n);
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {
        int depthX = findDepth(root, x, 0);
        int depthY = findDepth(root, y, 0);
        int parentX = findParent(root, x);
        int parentY = findParent(root, y);
        return (depthX==depthY) && (parentX!=parentY);
    }
}
