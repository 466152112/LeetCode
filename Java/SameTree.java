// recursive
public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null)
        return true;
    if (p == null || q == null || p.val != q.val)
        return false;
    return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
}

// using Queue
public boolean isSameTree(TreeNode p, TreeNode q) {
    Queue<TreeNode> pq = new LinkedList<TreeNode>();
    Queue<TreeNode> qq = new LinkedList<TreeNode>();
    pq.offer(p);
    qq.offer(q);
    while (!pq.isEmpty() && !qq.isEmpty()) {
        TreeNode newP = pq.poll();
        TreeNode newQ = qq.poll();
        if (newP == null && newQ == null)
            return true;
        if (newP == null || newQ ==null || newP.val != newQ.val)
            return false;
        if (newP.left != null && newQ.left != null) {
            pq.offer(newP.left);
            qq.offer(newQ.left);
        }
        else if (newP.left != null || newQ.left != null)
            return false;
        if (newP.right != null && newQ.right != null) {
            pq.offer(newP.right);
            qq.offer(newQ.right);
        }
        else if (newP.right != null || newQ.right != null)
            return false;
    }
    if (!pq.isEmpty() || !qq.isEmpty())
        return false;
    return true;
}
