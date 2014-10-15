/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Queue and List are interfaces
        // Use LinkedList and ArrayList instead
        ArrayList result = new ArrayList();
        if(root == null)
            return result;
        Queue<TreeNode> level = new LinkedList();
        level.offer(root);
        while(!level.isEmpty()) {
        	ArrayList<Integer> thisLevel = new ArrayList();
        	// iterator through every level by it's size
        	int size = level.size();
        	for (int i = 0; i < size; i++) {
				TreeNode head = level.poll();
				thisLevel.add(head.val);
				if (head.left != null) {
					level.offer(head.left);
				}
				if (head.right != null) {
					level.offer(head.right);
				}
			}
        	result.add(thisLevel);
        }
        return result;
        
    }
}
