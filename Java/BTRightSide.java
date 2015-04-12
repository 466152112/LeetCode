// level order modification
public ArrayList<Integer> rightSideView(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (root == null)
        return result;
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    while (!queue.isEmpty()) {
        int temp = 0;
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
            temp = node.val;
        }
        result.add(temp);
    }
    return result;
}
