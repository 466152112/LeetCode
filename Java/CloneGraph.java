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
