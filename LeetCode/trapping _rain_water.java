// Problem: Trapping Rain Water
// Link: https://leetcode.com/problems/trapping-rain-water/

// Approach (Two Pointers):
// 1. Use two pointers (left, right) starting from both ends.
// 2. Track leftMax and rightMax heights.
// 3. Water trapped at a bar = min(leftMax, rightMax) - height[i].
// 4. Move the pointer which has the smaller height.
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int water = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
            }
        }

        return water;        
    }
}
