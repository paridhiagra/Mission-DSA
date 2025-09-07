// Problem: Insertion Sort List
// Link: https://leetcode.com/problems/insertion-sort-list/

// Approach (Linked List Insertion Sort):
// 1. Use a dummy node before head.
// 2. Traverse list, and for each node not in order, find correct spot in sorted part.
// 3. Insert node at correct position.
// Time Complexity: O(n^2) in worst case.
// Space Complexity: O(1).


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
