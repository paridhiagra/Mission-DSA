// Problem: Design Circular Queue
// Link: https://leetcode.com/problems/design-circular-queue/

// Approach:
// 1. Use an array of fixed size k to store elements.
// 2. Maintain front, rear, and count.
// 3. Use modulo (%) to wrap indices around in circular fashion.
// Time Complexity: O(1) for all operations
// Space Complexity: O(k)


class MyCircularQueue {
    int[] queue;
    int size;
    int front, rear;

    public MyCircularQueue(int k) {
        size = k;
        queue = new int[k];
        front = rear = -1;
    }

    public boolean enQueue(int value) {
        if ((rear + 1) % size == front) return false; // Queue is full

        if (rear == -1) {
            front = rear = 0; // First element
        } else {
            rear = (rear + 1) % size; // Move to next slot
        }

        queue[rear] = value;
        return true;
    }

    public boolean deQueue() {
        if (front == -1) return false; // Queue is empty

        if (front == rear) {
            front = rear = -1; // Only one element, now removed
        } else {
            front = (front + 1) % size;
        }

        return true;
    }

    public int Front() {
        if (front == -1) return -1;
        return queue[front];
    }

    public int Rear() {
        if (rear == -1) return -1;
        return queue[rear];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }
}
