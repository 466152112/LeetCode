public class Solution {
    // recursion in recursion
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (Math.abs(getDepth(root.left) - getDepth(root.right)) < 2)
            return isBalanced(root.left) && isBalanced(root.right);
        return false;
    }
    private int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
    
    // to avoid recursion within recursion
    // the only way is to think about adding a variable so that one recursive process 
    // can perform two functionalities at the same time.
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        compareDepth(root);
        return flag;
    }
    private int compareDepth(TreeNode root) {
        if (root == null || flag == false)
            return 0;
        int left = compareDepth(root.left);
        int right = compareDepth(root.right);
        if (Math.abs(left - right) > 1)
            flag = false;
        return Math.max(left,right) + 1;
    }
    
    // furthermore, we can use special return value "-1" to work as the flag
    public boolean isBalanced(TreeNode root) {
        return getDepth(root) != -1;
    }
    private int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1)
            return -1;
        return Math.max(left,right) + 1;
    }
}
