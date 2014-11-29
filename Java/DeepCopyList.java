// HashMap, store next and random object reference in the map
// go 3 pass, deep copy node in chain, copy random, change chain to copy next
public RandomListNode copyRandomList(RandomListNode head) {
    if (head == null)
        return null;
    HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
    RandomListNode cursor = head;
    while (cursor != null) {
        // copy node
        RandomListNode newNode = null;
        if (!map.containsKey(cursor)){
            newNode = new RandomListNode(cursor.label);
            map.put(cursor, newNode);
        }
        else
            newNode = map.get(cursor);
        // copy next
        RandomListNode newNext = null;
        if (cursor.next != null && !map.containsKey(cursor.next)) {
            newNext = new RandomListNode(cursor.next.label);
            map.put(cursor.next, newNext);
        }
        else if (cursor.next != null)
            newNext = map.get(cursor.next);
        newNode.next = newNext;            
        // copy random
        RandomListNode newRandom = null;
        if (cursor.random != null && !map.containsKey(cursor.random)) {
            newRandom = new RandomListNode(cursor.random.label);
            map.put(cursor.random, newRandom);
        }
        else if (cursor.random != null)
            newRandom = map.get(cursor.random);                
        newNode.random = newRandom;
        // move cursor
        cursor = cursor.next;
    }
    return map.get(head);
}
