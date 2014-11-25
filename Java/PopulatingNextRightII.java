// Brillent logic
//based on level order traversal
// take care of this man's coding style and format, awesome! 
public void connect(TreeLinkNode root) {

    TreeLinkNode head = null; //head of the next level
    TreeLinkNode prev = null; //the leading node on the next level
    TreeLinkNode cur = root;  //current node of current level
    
    while (cur != null) {	// iterate each level until the bottom
        while (cur != null) { //iterate on the current level
            //left child
            if (cur.left != null) {
                if (prev != null) {
                    prev.next = cur.left;
                } else {
                    head = cur.left;
                }
                prev = cur.left;
            }
            //right child
            if (cur.right != null) {
                if (prev != null) {
                    prev.next = cur.right;
                } else {
                    head = cur.right;
                }
                prev = cur.right;
            }
            //move to next node
            cur = cur.next;
        }

        //move to next level
        cur = head;
        head = null;
        prev = null;
    }

}

// naive idea, handle last node and head node manually
public void connect(TreeLinkNode root) {
    if (root == null)
        return;
    while (root != null && (root.left != null || root.right != null)) {
        TreeLinkNode cursor = root;
        while (cursor.next != null) {
            if (cursor.left != null && cursor.right != null) {
                cursor.left.next = cursor.right;
                cursor.right.next = getNextNode(cursor.next);
            }
            else if (cursor.left != null)
                cursor.left.next = getNextNode(cursor.next);
            else if (cursor.right != null)
                cursor.right.next = getNextNode(cursor.next);
            cursor = cursor.next;
        }
        // deal with the last node of that level
        // default value of right.next is null, no need to set it
        if (cursor.left != null)
            cursor.left.next = cursor.right;
        // find the next level's head
        while (root != null) {
            if (root.left != null && (root.left.left != null || root.left.right != null)) {
                root = root.left;
                break;
            }
            else if (root.right != null && (root.right.left != null || root.right.right != null)) {
                root = root.right;
                break;
            }
            else {
                root = root.next;
            }
        }
    }
}
// return the next right node
private TreeLinkNode getNextNode(TreeLinkNode node) {
    while (node != null) {
        if (node.left != null)
            return node.left;
        if (node.right != null)
            return node.right;
        node = node.next;
    }
    return null;
}
