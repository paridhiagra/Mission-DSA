// Problem: Validate Stack Sequences
// Link: https://leetcode.com/problems/validate-stack-sequences/
//
// Approach (Simulation of Stack Operations):
// 1. Initialize an empty stack.
// 2. Use a pointer 'j' to track the position in the popped[] array.
// 3. Iterate through each value in pushed[]:
//      - Push the value onto the stack.
//      - After each push, check if the top of the stack matches popped[j]:
//          • While the stack is not empty and st.peek() == popped[j]:
//              - Pop from the stack.
//              - Increment j.
// 4. At the end, if the stack is empty, all elements were popped in correct order → return true.
//    Otherwise → return false.
//
// Why this works:
// - Simulates exactly how a real stack behaves with push and pop operations.
// - Ensures the sequence of pops matches the target popped[] array.
//
// Time Complexity: O(n) (each element pushed/popped at most once)
// Space Complexity: O(n) (stack to store elements)



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
