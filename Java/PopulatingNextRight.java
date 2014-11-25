// one pass, but, Math.pow(double a, double b)
public void connect(TreeLinkNode root) {
      if (root == null)
          return;
      // set first level
      root.next = null;
      // level: current depth of the tree, 2^level is the node NO. to set null
      // level = 1 begin from the second level. (first level is 0)
      int level = 1, num;
      TreeLinkNode cursor;
      while (root.left != null) {
          cursor = root;
          num = (int)Math.pow(2, level);
          // set next for all but the last one
          for (int i = 0; i < num - 1; i++) {
              if (i%2 == 0) {
                  cursor.left.next = cursor.right;
              }
              else {
                  cursor.right.next = cursor.next.left;
                  cursor = cursor.next;
              }
          }
          // deal with i = num -1, the last setting
          cursor.right.next = null;
          root = root.left;
          level++;
      }
  }
  
  // changed to another simple logic
      public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        // set first level
        //root.next = null;   // don't set, the default value is null
        TreeLinkNode cursor = null;
        while (root.left != null) {
            cursor = root;
            while (cursor.next != null) {
                cursor.left.next = cursor.right;
                cursor.right.next = cursor.next.left;
                cursor = cursor.next;
            }
            cursor.left.next = cursor.right;
            //cursor.right.next = null;
            root = root.left;
        }
    }
