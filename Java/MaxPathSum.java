// global value to store the global max
private int max = Integer.MIN_VALUE;

public int maxPathSum(TreeNode root) {
    // DFS traverse the tree, get the single max sum, also update the global max
    maxSingleSum(root);
    return max;
}
// return the max single path sum from leaf to root
public int maxSingleSum(TreeNode root) {
    if (root == null)
        return 0;
    int left = Math.max(0, maxSingleSum(root.left)); // if negative, assign 0 to it, cut this branch
    int right = Math.max(0, maxSingleSum(root.right));
    max = Math.max(max, left + root.val + right); // compare with left + root + right
    return Math.max(left, right) + root.val;
}
