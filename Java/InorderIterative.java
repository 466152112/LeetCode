// Inorder traversal iterative
// Inorder iterative, go to the very left node, check right one's left, then pop
public ArrayList<Integer> inorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer> ();
    if (root == null)
        return result;
    Stack<TreeNode> stack = new Stack<TreeNode>();
    while (root != null) {
        stack.push(root);
        root = root.left;
    }
    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        result.add(node.val);
        if (node.right != null){
            root = node.right;
            // find the left most of this right "root" node
            while (root != null) {
                stack.push(root);
                root = root.left;
            }            
        }
    }
    return result;
}
