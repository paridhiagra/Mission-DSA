// Problem: Swap Nodes in Pairs
// Link: https://leetcode.com/problems/swap-nodes-in-pairs/

// Approach (Dummy Node + Iteration):
// 1. Use dummy node to simplify swapping head.
// 2. Iterate while at least 2 nodes remain.
// 3. Swap pairs using pointer re-linking.
// Time Complexity: O(n)
// Space Complexity: O(1)


class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy, cur = head;

        while (cur != null && cur.next != null) {
            ListNode npn = cur.next.next;
            ListNode second = cur.next;

            second.next = cur;
            cur.next = npn;
            prev.next = second;

            prev = cur;
            cur = npn;
        }

        return dummy.next;        
    }
}
