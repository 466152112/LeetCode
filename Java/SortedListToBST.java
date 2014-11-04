// Naive way, similar with sorted array
public TreeNode sortedListToBST(ListNode head) {
    if (head == null)
        return null;
    int len = getLen(head);
    return buildTree(head, 0, len - 1);
}
private int getLen(ListNode head) {
    int len = 0;
    while (head != null) {
        len++;
        head = head.next;
    }
    return len;
}
private ListNode getMid(ListNode head, int mid) {
    while (mid-- > 0)
        head = head.next;
    return head;
}
private TreeNode buildTree(ListNode head, int start, int end) {
    if (start > end)
        return null;
    int mid = (start + end)/2;
    ListNode midNode = getMid(head, mid);
    TreeNode result = new TreeNode(midNode.val);
    result.left = buildTree(head, start, mid - 1);
    result.right = buildTree(head, mid + 1, end);
    return result;
}


// build tree accoding to the list order
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        myHead = head;
        int len = getLen(myHead);
        return buildTree(0, len - 1);
    }
    // JAVA pass by value, if you want to change the value in the recursions, make it class variable
    private ListNode myHead;
    private int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
    private TreeNode buildTree(int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end)/2;
        TreeNode left = buildTree(start, mid - 1);
        TreeNode result = new TreeNode(myHead.val);
        result.left = left;
        myHead = myHead.next;
        result.right = buildTree(mid + 1, end);
        return result;
    }
