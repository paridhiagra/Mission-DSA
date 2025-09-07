// Problem: Design Bounded Queue Using Linked List
// Link: https://leetcode.com/problems/design-circular-queue/
//
// Approach (Linked List version):
// 1. Use a singly linked list (ListNode) to store elements dynamically.
// 2. Maintain 'head' (front), 'tail' (rear), and 'size' to track the current number of elements.
// 3. Maintain 'maxSize' as the maximum allowed capacity.
// 4. enQueue(val):
//      - If queue is full (size == maxSize) → return false.
//      - Otherwise, create a new node and append it to the tail.
//      - Increment size.
// 5. deQueue():
//      - If queue is empty → return false.
//      - Otherwise, move head to the next node and decrement size.
// 6. Front() / Rear():
//      - Return head.val or tail.val respectively; if empty → return -1.
// 7. isEmpty() / isFull():
//      - Check if size == 0 or size == maxSize respectively.
//
// Time Complexity: O(1) for all operations (enQueue, deQueue, Front, Rear, isEmpty, isFull)
// Space Complexity: O(k) for storing up to maxSize nodes



class ListNode {
    int val;
    ListNode next;
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
class MyCircularQueue {
    int maxSize, size = 0;
    ListNode head = null, tail = null;
    public MyCircularQueue(int k) {
        maxSize = k;
    }
    public boolean enQueue(int val) {
        if (isFull()) return false;
        ListNode newNode = new ListNode(val, null);
        if (isEmpty()) head = tail = newNode;
        else {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
        return true;
    }
    public boolean deQueue() {
        if (isEmpty()) return false;
        head = head.next;
        size--;
        return true;
    }
    public int Front() {
        return isEmpty() ? -1 : head.val;
    }
    public int Rear() {
        return isEmpty() ? -1 : tail.val;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size == maxSize;
    }
}
