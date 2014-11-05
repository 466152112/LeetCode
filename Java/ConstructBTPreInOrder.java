// one pass with some optimaztion
// write some expamle, find the patten, recursive build sub tree
public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder == null || inorder == null || preorder.length != inorder.length)
        return null;
    return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
}

private TreeNode helper(int[] preorder, int[] inorder, int p_start, int p_end, int i_start, int i_end) {
    if (p_start > p_end)
        return null;
    TreeNode parent = new TreeNode(preorder[p_start]);
    // partition tells you which part is left tree, the other part is right tree
    int partition = getIndex(inorder, preorder[p_start], i_start, i_end);
    int left_size = partition - i_start;
    // skip position p_start
    parent.left = helper(preorder, inorder, p_start + 1, p_start + left_size, i_start, partition - 1);
    // skip position partition
    parent.right = helper(preorder, inorder, p_start + left_size + 1, p_end, partition + 1, i_end);
    return parent;
}
// add two arguments, i_start, i_end, skip the unrelavent items
private int getIndex(int[] array, int num, int i_start, int i_end) {
    for (int i = i_start; i <= i_end; i++) {
        if (array[i] == num)
            return i;
    }
    return -1;
}
