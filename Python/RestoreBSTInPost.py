# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        if inorder == None or postorder == None or len(inorder) != len(postorder):
            return None
        return self.helper(inorder,postorder,0,len(inorder)-1,0,len(postorder)-1)

    def helper(self, inorder,postorder,i_start, i_end,p_start, p_end):
        if i_start > i_end or p_start > p_end:
            return None
        root = TreeNode(postorder[p_end])
        partition = inorder.index(postorder[p_end])
        half_size = partition - i_start
        root.left = self.helper(inorder, postorder, i_start, partition - 1, p_start, p_start + half_size - 1)
        root.right = self.helper(inorder, postorder, partition + 1, i_end, p_start + half_size, p_end - 1)
        return root
