// easy problem full of bugs
public TreeNode sortedArrayToBST(int[] num) {
    if (num == null)
        return null;
    // bug 1: pass num.length to the function
    return helper(num, 0, num.length - 1);
}
private TreeNode helper(int[] num, int start, int end) {
    if (start == end)
        return new TreeNode(num[start]);
    // bug 2: start < end
    else if (start > end)
        return null;
    else {
        int mid = (start + end)/2;
        TreeNode result = new TreeNode(num[mid]);
        result.left = helper(num, start, mid - 1);
        result.right = helper(num, mid + 1, end);
        // return result outside the {}
        return result;
    }
}
