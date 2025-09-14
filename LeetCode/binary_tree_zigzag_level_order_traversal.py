# Problem: Binary Tree Zigzag Level Order Traversal
# Link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
#
# Approach (BFS with direction toggle):
# 1. If the root is None, return an empty list.
# 2. Initialize:
#      - `result` list to store the final zigzag traversal.
#      - `queue` (deque) containing the root node.
#      - `is_left_to_right = True` to track traversal direction.
# 3. While the queue is not empty:
#      - Find number of nodes at current level (`level_size`).
#      - Create an array `current_level` of size `level_size` filled with 0.
#      - For each node in this level (loop i from 0 to level_size-1):
#           - Pop a node from the left of the queue.
#           - Compute index:
#               - If left-to-right → index = i
#               - If right-to-left → index = level_size - 1 - i
#           - Place node’s value at `current_level[index]`.
#           - If node.left exists → append to queue.
#           - If node.right exists → append to queue.
#      - Append `current_level` to `result`.
#      - Flip the `is_left_to_right` flag for the next level.
# 4. After processing all levels, return `result`.
#
# Time Complexity: O(n) → each node visited once.
# Space Complexity: O(n) → queue + result storage.

from collections import deque

class Solution(object):
    def zigzagLevelOrder(self, root):
        if not root:
            return []

        result = []
        queue = deque([root])
        is_left_to_right = True

        while queue:
            level_size = len(queue)
            current_level = [0] * level_size

            for i in range(level_size):
                node = queue.popleft()
                index = i if is_left_to_right else level_size - 1 - i
                current_level[index] = node.val

                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

            result.append(current_level)
            is_left_to_right = not is_left_to_right

        return result
