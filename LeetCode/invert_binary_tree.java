// Problem: Invert Binary Tree
// Link: https://leetcode.com/problems/invert-binary-tree/
//
// Approach (Recursive Swap):
// 1. If the root is null → return null (empty tree).
// 2. Swap the left and right children of the current node.
// 3. Recursively call invertTree on the left child (which is originally the right).
// 4. Recursively call invertTree on the right child (which is originally the left).
// 5. Return the root after both subtrees are inverted.
//
// Time Complexity: O(n) 
//    → Each node is visited exactly once.
// Space Complexity: O(h) 
//    → Recursion stack height, where h is the height of the tree 
//      (O(log n) for balanced, O(n) for skewed).
//

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;  // Base case: empty tree
        }

        // Swap left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert left and right subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
