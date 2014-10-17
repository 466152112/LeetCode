public class Solution {
    // recursive check left is symmetric with right
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null || left.val != right.val)
            return false;
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
    
    // use two stack to check every node until empty
    public boolean isSymmetric2(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> leftS = new Stack<TreeNode>();
        Stack<TreeNode> rightS = new Stack<TreeNode>();
        leftS.push(root.left);
        rightS.push(root.right);
        
        while (!(leftS.empty() && rightS.empty())) {
            TreeNode left = leftS.pop();
            TreeNode right = rightS.pop();
            if (left == null && right == null)
                continue;
            if (left == null || right == null || left.val != right.val)
                return false;
            leftS.push(left.left);
            leftS.push(left.right);
            rightS.push(right.right);
            rightS.push(right.left);
        }
        return true;
    }
}
