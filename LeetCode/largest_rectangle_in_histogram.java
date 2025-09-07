// Problem: Largest Rectangle in Histogram
// Link: https://leetcode.com/problems/largest-rectangle-in-histogram/

// Approach (Monotonic Stack):
// 1. Use a stack to store indices of bars in increasing order of height.
// 2. When we find a bar shorter than the stack’s top, we pop and calculate area.
// 3. Area = height[popped] * width, where width = currentIndex - previousSmallerIndex - 1.
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int height = heights[stack.pop()];
            int width = heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}
