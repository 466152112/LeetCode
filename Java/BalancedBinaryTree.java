public class Solution {
  public boolean isBalanced(TreeNode root) {
      if (root == null)
          return true;
      // check current root balance, then subtree balance
      if (helper(root))
          return isBalanced(root.left) && isBalanced(root.right);
      else
          return false;
  }
  private boolean helper(TreeNode root) {
      if (root == null)
          return true;
      return Math.abs(getDepth(root.left) - getDepth(root.right)) < 2;
  }
  private int getDepth(TreeNode root) {
      if (root == null)
          return 0;
      return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
  }
}
