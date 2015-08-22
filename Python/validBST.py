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
