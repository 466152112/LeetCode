// 1, add(new ...) don't add the reference itself
// 2, recursive, return void, keep adding and removing
public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> one = new ArrayList<Integer>();
    helper(root, sum, result, one);
    return result;
}

private void helper(TreeNode root, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> one) {
    if (root == null || root.left == null && root.right == null && root.val != sum)
        return;
    else if (root.left == null && root.right == null) {
        one.add(root.val);
        result.add(new ArrayList<Integer>(one));
        one.remove(one.size() - 1);
    }
    else {
        one.add(root.val);
        helper(root.left, sum - root.val, result, one);
        helper(root.right, sum - root.val, result, one);
        one.remove(one.size() -1);
    }
}
