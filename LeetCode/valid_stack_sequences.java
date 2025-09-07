// Problem: Validate Stack Sequences
// Link: https://leetcode.com/problems/validate-stack-sequences/

// Approach:
// 1. Simulate push operations for each element in pushed[].
// 2. After each push, check if the top of stack matches popped[j].
// 3. If yes, pop until they don’t match, then continue.
// 4. At the end, if stack is empty, return true.
// Time Complexity: O(n)
// Space Complexity: O(n)


class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>(); // Create a stack
        
        int j = 0; // Intialise one pointer pointing on popped array
        
        for(int val : pushed){
            st.push(val); // insert the values in stack
            while(!st.isEmpty() && st.peek() == popped[j]){ // if st.peek() values equal to popped[j];
                st.pop(); // then pop out
                j++; // increment j
            }
        }
        return st.isEmpty(); // check if stack is empty return true else false
    }
}
