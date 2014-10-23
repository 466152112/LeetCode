// compare flag to determine which stack to push and pop
public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (root == null)
        return result;
    Stack<TreeNode> stack_left = new Stack<TreeNode>();
    Stack<TreeNode> stack_right = new Stack<TreeNode>();
    stack_left.push(root);
    int right_first = -1; // -1, push the right fist: +1, push the left node first
    while (!stack_left.isEmpty() || !stack_right.isEmpty()) {
        ArrayList<Integer> currentLevel = new ArrayList<Integer>();
        int size = right_first>0?stack_right.size():stack_left.size();

        for (int i = 0; i < size; i++) {
            TreeNode node = right_first>0?stack_right.pop():stack_left.pop();
            currentLevel.add(node.val);
            if (right_first > 0) {
                if (node.right != null)
                    stack_left.push(node.right);
                if (node.left != null)
                    stack_left.push(node.left);
            }
            else {
                if (node.left != null)
                    stack_right.push(node.left);
                if (node.right != null)
                    stack_right.push(node.right);
            }
        }
        right_first *= -1;
        result.add(currentLevel);
    }
    return result;
}

// use two stack, one temp stack to exchange the reference of current stack
// while stack is not empty, pop, not use size
public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    if (root == null) {
        return result;
    }

    Stack<TreeNode> currLevel = new Stack<TreeNode>();
    Stack<TreeNode> nextLevel = new Stack<TreeNode>();
    Stack<TreeNode> tmp;
    
    currLevel.push(root);
    boolean normalOrder = true;

    while (!currLevel.isEmpty()) {
        ArrayList<Integer> currLevelResult = new ArrayList<Integer>();

        while (!currLevel.isEmpty()) {
            TreeNode node = currLevel.pop();
            currLevelResult.add(node.val);

            if (normalOrder) {
                if (node.left != null) {
                    nextLevel.push(node.left);
                }
                if (node.right != null) {
                    nextLevel.push(node.right);
                }
            } else {
                if (node.right != null) {
                    nextLevel.push(node.right);
                }
                if (node.left != null) {
                    nextLevel.push(node.left);
                }
            }
        }

        result.add(currLevelResult);
        tmp = currLevel;
        currLevel = nextLevel;
        nextLevel = tmp;
        normalOrder = !normalOrder;
    }

    return result;

}
