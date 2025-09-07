// Problem: Swap Nodes in Pairs
// Link: https://leetcode.com/problems/swap-nodes-in-pairs/
//
// Approach (Dummy Node + Iteration):
// 1. Create a dummy node pointing to head to simplify swapping at the head.
// 2. Use two pointers: 
//      - 'prev' → node before the current pair
//      - 'cur'  → first node of the current pair
// 3. While at least two nodes remain (cur != null && cur.next != null):
//      - Store next pair start: npn = cur.next.next
//      - Identify second node of the pair: second = cur.next
//      - Swap pointers:
//          • second.next = cur
//          • cur.next = npn
//          • prev.next = second
//      - Move pointers forward for next iteration:
//          • prev = cur
//          • cur = npn
// 4. Return dummy.next as new head.
//
// Why this works:
// - Using a dummy node avoids special handling of head swaps.
// - Iterative pointer manipulation swaps nodes in pairs efficiently.
//
// Time Complexity: O(n) (traverse each node once)
// Space Complexity: O(1) (in-place, no extra data structures)



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
