// recursive DFS, using hashmap to keep track of the visited
public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if (node == null)
        return null;
    // keep track of the visited, using label as key to get the visited node
    HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode> ();
    // recursive clone from the head node
    helper(node, map);
    return map.get(node.label);
}
private void helper(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map) {
	// declare a new node outside the if else scope, make it seeable in this function
    UndirectedGraphNode newNode;
    // create the node, or get the node from the hashmap
    if (!map.containsKey(node.label)) {
        newNode= new UndirectedGraphNode(node.label);
        map.put(node.label, newNode);
    }
    else {
        newNode = map.get(node.label);
    }
    // adding all the neighbors
    for (UndirectedGraphNode n:node.neighbors) {
        UndirectedGraphNode newNeighbor;
        if (!map.containsKey(n.label)) {
            newNeighbor = new UndirectedGraphNode(n.label);
            map.put(n.label, newNeighbor);
            newNode.neighbors.add(newNeighbor);
	        // if the neighbor is new created, recursive clone the neighbor
	        helper(n, map);                
        }
        else {
        	// the node has been visited, just add it
            newNeighbor = map.get(n.label);
            newNode.neighbors.add(newNeighbor);
        }
    }  
}


// BFS, visit one node, add all neighbors, then visit the fist neighbor in the queue
public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if (node == null)
        return null;
    // store the cloned nodes
    HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode> ();
	// store the node in the original graph
    Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
    // save the head of the graph the result
    UndirectedGraphNode result = new UndirectedGraphNode(node.label);
    map.put(node.label, result);
    queue.offer(node);
    
    // BFS
    while (!queue.isEmpty()) {
        UndirectedGraphNode current = queue.poll();
        for (UndirectedGraphNode n:current.neighbors) {
            UndirectedGraphNode newNeighbor;
            if (!map.containsKey(n.label)) {
                queue.offer(n);
                newNeighbor = new UndirectedGraphNode(n.label);
                map.put(n.label, newNeighbor);                    
                map.get(current.label).neighbors.add(newNeighbor);
            }
            else {
                map.get(current.label).neighbors.add(map.get(n.label));
            }
        }
    }
    return result;
}

// nine chapter, clone nodes first, put them in a list and a map
// then, clone the neighbors
public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if (node == null) {
        return null;
    }

    ArrayList<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
    HashMap<UndirectedGraphNode, UndirectedGraphNode> map
        = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

    // clone nodes    
    nodes.add(node);
    map.put(node, new UndirectedGraphNode(node.label));

    int start = 0;
    while (start < nodes.size()) {
        UndirectedGraphNode head = nodes.get(start++);
        for (int i = 0; i < head.neighbors.size(); i++) {
            UndirectedGraphNode neighbor = head.neighbors.get(i);
            if (!map.containsKey(neighbor)) {
                map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                nodes.add(neighbor);
            }
        }
    }

    // clone neighbors
    for (int i = 0; i < nodes.size(); i++) {
        UndirectedGraphNode newNode = map.get(nodes.get(i));
        for (int j = 0; j < nodes.get(i).neighbors.size(); j++) {
            newNode.neighbors.add(map.get(nodes.get(i).neighbors.get(j)));
        }
    }

    return map.get(node);
}
