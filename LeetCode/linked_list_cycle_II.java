// Problem: Linked List Cycle II
// Link: https://leetcode.com/problems/linked-list-cycle-ii/

// Approach (Floyd’s Tortoise & Hare):
// 1. Detect cycle using slow/fast pointers.
// 2. If cycle exists, reset one pointer to head.
// 3. Move both 1 step at a time; meeting point = cycle start.
// Time Complexity: O(n)
// Space Complexity: O(1)


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
