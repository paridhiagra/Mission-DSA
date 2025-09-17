/**
 * Problem 226: Invert Binary Tree
 * 
 * Given the root of a binary tree, invert the tree and return its root.
 */


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
