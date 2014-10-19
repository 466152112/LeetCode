/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        // no need
        if(root.left == null && root.right == null){
            return 1;
        }
        // integrate into the return statement
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return (left>right?left+1:right+1);
    }
    
    public int maxDepth2(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
