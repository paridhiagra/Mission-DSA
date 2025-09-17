/**
 * Problem 897: Increasing Order Search Tree
 * 
 * Given the root of a binary search tree, rearrange the tree so that it is in 
 * increasing order (in-order traversal), where the leftmost node is the root 
 * and every node has only a right child.
 */


class Solution {
    // Dummy node to build the result tree
    TreeNode newRoot = new TreeNode(0);
    TreeNode current = newRoot;

    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        return newRoot.right;  // The actual root of the new tree
    }

    // In-order traversal helper
    public void inOrder(TreeNode node) {
        if (node == null) return;

        inOrder(node.left);

        // Create a new node and attach it
        TreeNode newNode = new TreeNode(node.val);
        current.right = newNode;
        current = current.right;

        inOrder(node.right);
    }
}
