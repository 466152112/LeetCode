/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// O(h) memory, average O(1) access for next(). "Average"
public class BSTIterator {
    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        if (root == null)
            return;
        // push the small number into the stack, FILO
        stack.push(root);
        while(root.left != null) {
            root = root.left;
            stack.push(root);
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        int result = node.val;
        // do the same initialization to the right branch
        if (node.right != null) {
            node = node.right;
            stack.push(node);
            while (node.left != null) {
                node = node.left;
                stack.push(node);
            }
        }
        return result;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
