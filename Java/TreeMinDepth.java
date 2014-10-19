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

    public int minDepth2(TreeNode root) {
    	// handle the root null and child null differently
        if (root == null) {
            return 0;
        }
        return getMin(root);
    }

    public int getMin(TreeNode root){
    	// null is MAX, different with the leaf
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return Math.min(getMin(root.left), getMin(root.right)) + 1;
    }
