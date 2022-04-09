# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import List, Optional
from common.tree_node import TreeNode


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
