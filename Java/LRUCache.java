// Round 2, Double Linked Node
public class LRUCache {
    
    private class DLinkedNode {
        DLinkedNode previous;
        DLinkedNode next;
        int key; // Why need key in the Node? Help us remove the Key in the map
        int value;
        public DLinkedNode (int key, int value) {
            this.key = key;
            this.value = value;
            previous = null;
            next = null;
        }
        // Good design: getPrevious() setPrevious etc...
    }
    
    private HashMap<Integer, DLinkedNode> map;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;
    
    public LRUCache(int capacity) {
        map = new HashMap<Integer, DLinkedNode>();
        this.capacity = capacity;
        head = new DLinkedNode(-1, -1);
        tail = new DLinkedNode(-1, -1);
        head.next = tail;
        tail.previous = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            DLinkedNode node = map.get(key);
            moveToHead(node);
            return node.value;
        } else
            return -1;
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            DLinkedNode node = map.get(key);
            moveToHead(node);
            node.value = value;
        } else {
            if (map.size() == capacity) {
                map.remove(tail.previous.key);
                tail.previous = tail.previous.previous;
                tail.previous.next = tail;
            }
            DLinkedNode node = new DLinkedNode(key, value);
            // insert to the head
            node.next = head.next;
            node.previous = head;
            head.next.previous = node;
            head.next = node;
            map.put(key, node);
        }
    }
    
    private void moveToHead(DLinkedNode node) {
        // move out of original position
        node.previous.next = node.next;
        node.next.previous = node.previous;
        // move to head
        node.next = head.next;
        node.previous = head;
        head.next.previous = node;
        head.next = node;
    }
}
import java.util.HashMap;
// double linked Node class as inner data structure
public class LRUCache {

	class Node {
		private int key;
		private int value;
		private Node next;
		private Node previous;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
			next = null;
			previous = null;
		}
	}

	private int capacity;
	private HashMap<Integer, Node> map;
	private Node head; // head node, point to the head of nodes in the HashMap
	private Node tail; // tail node, point to the tail of nodes in the HashMap

	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<Integer, Node>();
		head = new Node(-1, -1);
		tail = new Node(-1, -1);
		head.next = tail;
		tail.previous = head;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			deleteNode(node); // delete that node in the LinkedList, not the map
			insertHeadNode(node); // move that node to the head
			return node.value;
		}
		return -1;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			map.remove(key); // remove it from the map and the list
			deleteNode(node); // since, we'll create a new value for it
		} else if (map.size() == capacity) {
			map.remove(tail.previous.key);
			deleteTailNode();
		}
		Node node = new Node(key, value);
		map.put(key, node);
		insertHeadNode(node);
	}

	private void deleteNode(Node node) {
		node.previous.next = node.next;
		node.next.previous = node.previous;
	}

	private void deleteTailNode() {
		tail.previous = tail.previous.previous;
		tail.previous.next = tail;
	}

	private void insertHeadNode(Node node) {
		Node temp = head.next;
		head.next = node;
		node.next = temp;
		node.previous = head;
		temp.previous = node;
	}

	public static void main(String[] args) {
		LRUCache test = new LRUCache(1);
		test.set(2, 1);
		System.out.println(test.get(2));
		test.set(2, 22);
		System.out.println(test.get(2));
		test.set(3, 33);
		System.out.println(test.get(1));
		test.set(4, 44);
		System.out.println(test.get(1));
	}
}
