public class Solution {
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
}
