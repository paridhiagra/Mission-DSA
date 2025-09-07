// Problem: Insertion Sort List
// Link: https://leetcode.com/problems/insertion-sort-list/
//
// Approach (Linked List Insertion Sort):
// 1. Create a dummy node before the head to simplify insertion at the beginning.
// 2. Traverse the original list with a pointer `temp`.
// 3. For each node `temp`:
//      - Store the next node (`agla = temp.next`) before modifying links.
//      - Start from the dummy node (`pichla = dummy`) and find the correct position
//        in the sorted part where `pichla.next.val > temp.val`.
//      - Insert `temp` between `pichla` and `pichla.next`.
//      - Move `temp` to the next node (`temp = agla`) and repeat.
// 4. Continue until all nodes are inserted into the sorted part.
//
// Time Complexity: O(n^2) in worst case (already sorted part may need full traversal for each insertion)
// Space Complexity: O(1) (in-place, no extra list or array used)



class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy=new ListNode(-1);
        ListNode temp=head;
        while(temp!=null){
            ListNode agla=temp.next;
            ListNode pichla=dummy;
            while(pichla.next!=null && pichla.next.val<=temp.val)
                pichla=pichla.next;
            temp.next=pichla.next;
            pichla.next=temp;
            temp=agla;
        }
        return dummy.next;
    }
}
