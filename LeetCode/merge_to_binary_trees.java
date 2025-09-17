// Problem: Merge Two Binary Trees
// Link: https://leetcode.com/problems/merge-two-binary-trees/
//
// Approach (Recursive Merge):
// 1. If both nodes are null → return null.
// 2. If one of the nodes is null → return the other node (no merging needed).
// 3. Otherwise, create a new node whose value = sum of root1.val + root2.val.
// 4. Recursively merge the left children: n.left = mergeTrees(root1.left, root2.left).
// 5. Recursively merge the right children: n.right = mergeTrees(root1.right, root2.right).
// 6. Return the newly created merged node.
//
// Time Complexity: O(n) 
//    → Every node from both trees is visited once.
// Space Complexity: O(h) 
//    → Recursion stack height, where h is the height of the tree 
//      (O(log n) for balanced trees, O(n) for skewed trees).
//

class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null; // Both empty
        }
        if (root1 == null) {
            return root2; // Take the other tree
        }
        if (root2 == null) {
            return root1;
        }

        // Create new node with summed value
        TreeNode n = new TreeNode(root1.val + root2.val);

        // Recursively merge children
        n.left = mergeTrees(root1.left, root2.left);
        n.right = mergeTrees(root1.right, root2.right);

        return n;
    }
}
