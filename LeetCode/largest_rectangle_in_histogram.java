// Problem: Largest Rectangle in Histogram
// Link: https://leetcode.com/problems/largest-rectangle-in-histogram/
//
// Approach (Monotonic Stack):
// 1. Initialize a stack to store indices of histogram bars in increasing order of height.
//    - Push -1 as a sentinel to simplify width calculation.
// 2. Traverse the histogram from left to right:
//    - While the current bar is shorter than the bar at the stack's top:
//        • Pop the index from stack.
//        • Calculate area with popped height: height[popped] * width
//          where width = currentIndex - stack.peek() - 1
//        • Update maxArea if this area is larger.
//    - Push current index onto the stack.
// 3. After traversing all bars, process any remaining bars in the stack:
//    - Pop each index and calculate area as above using width = length - stack.peek() - 1
//    - Update maxArea.
// 4. Return maxArea.
//
// Time Complexity: O(n) (each bar is pushed and popped at most once)
// Space Complexity: O(n) (stack storing indices)


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
