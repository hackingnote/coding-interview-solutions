from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def __add_nodes(self, stack, node):
        while node:
            stack.append(node)
            node = node.left

    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        stack = []
        self.__add_nodes(stack, root)
        while stack:
            node = stack.pop()
            self.__add_nodes(stack, node.right)
            result.append(node.val)
        return result
