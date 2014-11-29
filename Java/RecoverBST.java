// O(1) space (O(n) space is trivial)
public void recoverTree(TreeNode root) {
    // find the two mis-placed nodes
    dfs(root);
    // if found, swap them
    if (firstNode != null && secondNode != null)
        swap(firstNode, secondNode);
}

private TreeNode firstNode = null;
private TreeNode secondNode = null;
private TreeNode previousNode = new TreeNode(Integer.MIN_VALUE);
// inorder dfs, every visit, check larger or not with previous
private void dfs(TreeNode root) {
    if (root == null)
        return;
    dfs(root.left);
    if (firstNode == null && root.val < previousNode.val)
        firstNode = previousNode;
    // not else if, take care when first and second node are neighbours, keep updating the second node
    if (firstNode != null && root.val < previousNode.val)
        secondNode = root;
    previousNode = root;
    dfs(root.right);
}
// shallow copy
private void swap(TreeNode a, TreeNode b) {
    int temp = a.val;
    a.val = b.val;
    b.val = temp;
}
