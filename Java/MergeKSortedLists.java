// Brute Force, scan for the current smallest, O(K*N), K is size of list, N is total nodes
public ListNode mergeKLists(ArrayList<ListNode> lists) {
    if(lists == null)
        return null;
    ListNode dummy = new ListNode(0);
    ListNode head = dummy;
    int size = lists.size();
    while (size > 0) {
        size = lists.size();
        ListNode temp = new ListNode(Integer.MAX_VALUE);
        // find the current smallest node
        for (ListNode node:lists) {
            if (node == null) {
                size--; // is all null, size will be reduced to 0
                continue;
            }
            if (node.val < temp.val) {
                temp = node;
            }
        }
        head.next = temp;
        lists.remove(temp);            
        temp = temp.next; // move the cursor of node in the lists
        lists.add(temp);
        head = head.next;
    }
    return dummy.next;
}

// binary merge, O(N*lgK), one run merge half of the lists
public ListNode mergeKLists(ArrayList<ListNode> lists) {
    if(lists == null || lists.size() == 0)
        return null;
    int last = lists.size() - 1;
    while (last > 0) {
        int first = 0;
        // one run, merge half of the lists
        while (first < last)
            lists.set(first, mergeTwoLists(lists.get(first++), lists.get(last--)));
    }
    return lists.get(0);
}

private ListNode mergeTwoLists(ListNode a, ListNode b) {
    ListNode dummy = new ListNode(0);
    ListNode head = dummy;
    while (a != null && b != null) {
        if (a.val < b.val) {
            head.next = a;
            a = a.next;
        }
        else {
            head.next = b;
            b = b.next;
        }
        head = head.next;
    }
    if (a != null)
        head.next = a;
    else
        head.next = b;
    return dummy.next;
}

// use PriorityQueue as a heap for heap sort
public ListNode mergeKLists(ArrayList<ListNode> lists) {
    if (lists == null || lists.size() == 0)
        return null;
    // instant a comparator for the PriorityQueue
    Comparator<ListNode> myComparator = new Comparator<ListNode>(){
        @Override
        public int compare(ListNode a, ListNode b) {
            return a.val - b.val;
        }
    };
    // heap, the PQ for storing the nodes, always poll the current smallest node
    PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), myComparator);
    for (ListNode n:lists)
        if (n != null) heap.offer(n);
    ListNode dummy = new ListNode(0);
    ListNode head = dummy;
    while (!heap.isEmpty()) {
        ListNode current = heap.poll();
        head.next = current;
        head = head.next;
        if (current.next != null)
            heap.offer(current.next);
    }
    return dummy.next;
}

// another way to use the Comparator interface
public ListNode mergeKLists(ArrayList<ListNode> lists) {
    if (lists == null || lists.size() == 0)
        return null;
    // heap, the PQ for storing the nodes, always poll the current smallest node
    PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), new ListNodeComparator());
    for (ListNode n:lists)
        if (n != null) heap.offer(n);
    ListNode dummy = new ListNode(0);
    ListNode head = dummy;
    while (!heap.isEmpty()) {
        ListNode current = heap.poll();
        head.next = current;
        head = head.next;
        if (current.next != null)
            heap.offer(current.next);
    }
    return dummy.next;
}

private class ListNodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode a, ListNode b) {
            return a.val - b.val;
        }
}
