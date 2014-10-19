public int minDepth(TreeNode root) {
	// only one node
    if (root == null)
        return 0;
    // leaf node
    if (root.left == null && root.right == null)
        return 1;
    // only have right subtree
    if (root.left == null)
        return minDepth(root.right) + 1;
    // only have left subtree
    if (root.right == null)
        return minDepth(root.left) + 1;
    // have both subtrees
    return Math.min(minDepth(root.left) + 1, minDepth(root.right) + 1);
}
