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
			return node.key;
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
