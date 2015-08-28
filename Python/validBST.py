class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root == None:
            return True
        if root.left != None:
            runner = root.left
            while runner.right != None:
                runner = runner.right
            if runner.val >= root.val:
                return False
        if root.right != None:
            runner = root.right
            while runner.left != None:
                runner = runner.left
            if runner.val <= root.val:
                return False
        return self.isValidBST(root.left) and self.isValidBST(root.right)
import sys
class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root == None:
            return True
        return self.helper(root, -sys.maxint - 1, sys.maxint)

    def helper(self, root, mini, maxm):
        if root == None:
            return True
        return root.val > mini and root.val < maxm and self.helper(root.left,mini,root.val) 
        and self.helper(root.right,root.val,maxm)
