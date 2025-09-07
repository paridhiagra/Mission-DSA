// Problem: Linked List Cycle II
// Link: https://leetcode.com/problems/linked-list-cycle-ii/
//
// Approach (Floyd’s Tortoise & Hare):
// 1. Use two pointers, 'slow' and 'fast', both starting at head.
// 2. Move 'slow' by 1 step and 'fast' by 2 steps in a loop.
//    - If 'fast' or 'fast.next' becomes null → no cycle → return null.
//    - If 'slow' == 'fast' → cycle detected; break the loop.
// 3. To find the start of the cycle:
//    - Reset 'fast' to head.
//    - Move 'slow' and 'fast' one step at a time.
//    - When 'slow' == 'fast', that node is the start of the cycle.
// 4. Return the node where the cycle begins.
//
// Why this works:
// - The meeting point inside the cycle and the distance from head satisfy the property
//   that moving both pointers at same speed from head and meeting point leads to cycle start.
//
// Time Complexity: O(n) (traverse the list at most twice)
// Space Complexity: O(1) (no extra space)



public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) break;
        }

        if (fast == null || fast.next == null) return null;

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;        
    }
}
