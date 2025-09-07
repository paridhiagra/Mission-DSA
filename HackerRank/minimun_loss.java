// Problem: Minimum Absolute Difference in an Array
// Approach: Using TreeSet for efficient neighbor lookup
//
// 1. Goal: Find the smallest absolute difference between any two elements in the array.
//
// 2. Naive approach (checking all pairs) → O(n²), too slow for large inputs.
//    Optimized approach: maintain a sorted set (TreeSet) to find closest neighbors in O(log n).
//
// 3. Steps:
//    - Insert the first element into the TreeSet.
//    - For each subsequent element:
//        • Use TreeSet.higher(value) → next greater element.
//        • Use TreeSet.lower(value) → next smaller element.
//        • Compute absolute difference with both neighbors (if they exist).
//        • Update the minimum difference.
//        • Insert the current element into the TreeSet.
//    - After processing all elements, print the minimum difference.
//
// 4. Why it works:
//    - The minimum absolute difference must occur between neighbors in the sorted order.
//    - TreeSet allows fast insertion and neighbor lookup.
//
// Time Complexity: O(n log n)  (each insertion + neighbor lookup)
// Space Complexity: O(n)       (storing all elements)


import java.util.*;

public class solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        TreeSet<Long> values = new TreeSet<>();
        values.add(s.nextLong());
        long min = Long.MAX_VALUE;
        for (int i = 1; i <n; i++) {
            long value = s.nextLong();
            Long higher = values.higher(value);
            if (higher != null) {
                min = Math.min(min, Math.abs(higher - value));
            }
            values.add(value);
        }
        System.out.println(min);
    }
}
