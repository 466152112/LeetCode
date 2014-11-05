// one pass, similar with preInorder
public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (inorder == null || postorder == null || inorder.length != postorder.length)
        return null;
    return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
}

private TreeNode helper(int[] inorder, int[] postorder, int i_start, int i_end, int p_start, int p_end) {
    if (p_start > p_end)
        return null;
    TreeNode parent = new TreeNode(postorder[p_end]);
    int partition = getIndex(inorder, postorder[p_end], i_start, i_end);
    int left_size = partition - i_start;
    // skip the partition
    parent.left = helper(inorder, postorder, i_start, partition - 1, p_start, p_start + left_size - 1);
    // skip last one
    parent.right = helper(inorder, postorder, partition + 1, i_end, p_start + left_size, p_end - 1);
    return parent;
}

private int getIndex(int[] inorder, int num, int i_start, int i_end) {
    for (int i = i_start; i <= i_end; i++) {
        if (inorder[i] == num)
            return i;
    }
    return -1;
}
