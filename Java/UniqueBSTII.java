// DP recursive create current node, set left list to left, right list to right
public ArrayList<TreeNode> generateTrees(int n) {
    return generate(1,n);
}
private ArrayList<TreeNode> generate(int start, int end) {
    ArrayList<TreeNode> result = new ArrayList<TreeNode>();
    if (start > end) {
    // add null, so the for loop below can add null the leaf node
        result.add(null);
    }
    for (int i = start; i <= end; i++) {
        ArrayList<TreeNode> left = generate(start, i - 1);
        ArrayList<TreeNode> right = generate(i + 1, end);
        for (TreeNode l:left) {
            for (TreeNode r:right) {
            // create new root node
                TreeNode p = new TreeNode(i);
                p.left = l;
                p.right = r;
                result.add(p);
            }
        }
    }
    return result;
}
