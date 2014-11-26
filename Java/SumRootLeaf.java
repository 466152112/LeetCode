// DFS modification
// no return value
private int result = 0;
public int sumNumbers(TreeNode root) {
    dfs(root, 0);
    return result;
}
private void dfs(TreeNode root, int num) {
    if (root == null)
        return;
    if (root.left == null && root.right == null) {
        result += num + root.val;
        return;
    }
    dfs(root.left, (num + root.val)*10);
    dfs(root.right, (num + root.val)*10);
}

// return sum
public int sumNumbers(TreeNode root) {
    return dfs(root, 0);
}

private int dfs(TreeNode root, int prev){
    if(root == null) {
        return 0;
    }

    int sum = root.val + prev * 10;
    if(root.left == null && root.right == null) {
        return sum;
    }

    return dfs(root.left, sum) + dfs(root.right, sum);
}
