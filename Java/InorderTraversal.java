// recursive
public ArrayList<Integer> inorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer> ();
    if (root == null)
        return result;
    if (root.left == null && root.right == null) {
        result.add(root.val);
        return result;
    }
    result.addAll(inorderTraversal(root.left));
    result.add(root.val);
    result.addAll(inorderTraversal(root.right));
    return result;
}
