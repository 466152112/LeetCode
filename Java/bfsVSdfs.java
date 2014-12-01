// iterative DFS using stack
ArrayList result = new ArrayList();
Stack<TreeNode> stack = new Stack<TreeNode>();
stack.push(root);
while(!stack.empty()) {
    TreeNode node = stack.pop();
    // check the node is null or not before push it into the stack is more efficent
    if (node == null)
        continue;
    result.add(node.val);
    stack.push(node.right);
    stack.push(node.left);
}
return result;

// iterative BFS using queue
ArrayList result = new ArrayList();
Queue<TreeNode> queue = new LinkedList<TreeNode>();
queue.offer(root);
while(!queue.isEmpty()) {
	int size = queue.size(); // use the size varible to mark size
	for (int i = 0; i < size; i++) {
		TreeNode node = queue.poll();
		if (node == null)
			continue;
		result.add(node.val);
		queue.offer(node.left);
		queue.offer(node.right);
	}
}
return result;
