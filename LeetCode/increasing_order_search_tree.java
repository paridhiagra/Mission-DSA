// Problem: Increasing Order Search Tree
// Link: https://leetcode.com/problems/increasing-order-search-tree/
//
// Approach (In-order Traversal with Dummy Node):
// 1. Create a dummy node (`newRoot`) and a pointer (`current`) to help build the result tree.
// 2. Perform an in-order traversal of the original BST.
//      - First, recurse into the left subtree.
//      - Process the current node:
//          * Create a new node with the current node’s value.
//          * Attach it to `current.right`.
//          * Move `current` forward to this new node.
//      - Then, recurse into the right subtree.
// 3. At the end, the dummy node’s right child (`newRoot.right`) will be the actual root of the 
//    new increasing order search tree.
// 4. Return `newRoot.right`.
//
// Time Complexity: O(n) 
//    → Each node is visited exactly once during in-order traversal.
// Space Complexity: O(h) 
//    → Recursion stack height, where h is the height of the BST 
//      (O(log n) for balanced, O(n) for skewed).
//

class Solution {
    // Dummy node to build the result tree
    TreeNode newRoot = new TreeNode(0);
    TreeNode current = newRoot;

    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        return newRoot.right;  // Skip dummy and return the actual root
    }

    // In-order traversal helper
    public void inOrder(TreeNode node) {
        if (node == null) return;

        inOrder(node.left);

        // Create a new node and attach it to the right
        TreeNode newNode = new TreeNode(node.val);
        current.right = newNode;
        current = current.right;

        inOrder(node.right);
    }
}
