public class Solution {
  public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
      ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
      Queue<TreeNode> level = new LinkedList<TreeNode>();
      if (root == null)
          return result;
      level.offer(root);
      while (!level.isEmpty()) {
          int size = level.size();
          TreeNode currentNode;
          ArrayList<Integer> currentLevel = new ArrayList<Integer>();
          for (int i = 0; i < size; i++) {
              currentNode = level.poll();
              currentLevel.add(currentNode.val);
              if (currentNode.left != null)
                  level.offer(currentNode.left);
              if (currentNode.right != null)
                  level.offer(currentNode.right);
          }
          result.add(currentLevel);
      }
      
      
      // reverse the top level order
      int size = result.size();
      for (int i = 0; i < size/2; i++) {
          ArrayList<Integer> temp = result.get(size -i -1);
          result.set(size - i -1, result.get(i));
          result.set(i,temp);
      }
      return result;
  }
}
