// Problem: Trapping Rain Water
// Link: https://leetcode.com/problems/trapping-rain-water/
//
// Approach (Two Pointers):
// 1. Initialize two pointers, 'left' at start and 'right' at end of the array.
// 2. Keep track of the maximum heights seen so far from both ends:
//      - leftMax = max height from the left up to current left
//      - rightMax = max height from the right up to current right
// 3. While left < right:
//      - Compare leftMax and rightMax:
//          • If leftMax < rightMax:
//              - Move left pointer one step to the right.
//              - Update leftMax.
//              - Water trapped at current left = leftMax - height[left] (if positive).
//          • Else:
//              - Move right pointer one step to the left.
//              - Update rightMax.
//              - Water trapped at current right = rightMax - height[right] (if positive).
// 4. Sum water trapped at each step to get total.
//
// Why this works:
// - Water level at a bar is limited by the shorter of the max heights on its sides.
// - Moving the pointer with smaller max ensures all trapped water is counted correctly.
//
// Time Complexity: O(n) (single pass through array)
// Space Complexity: O(1) (constant extra space)


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
