// Problem: Number of Students Unable to Eat Lunch
// Link: https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
//
// Approach (Count & Stop Principle):
// 1. Count the number of students who prefer each type of sandwich:
//      - zeros = number of students preferring type 0
//      - ones  = number of students preferring type 1
// 2. Iterate through the sandwiches array in order:
//      - If the current sandwich is type 0:
//          • If zeros > 0 → serve it (zeros--)
//          • Else → no student wants this sandwich → return remaining hungry students (ones)
//      - If the current sandwich is type 1:
//          • If ones > 0 → serve it (ones--)
//          • Else → no student wants this sandwich → return remaining hungry students (zeros)
// 3. If all sandwiches are served, return 0 (everyone ate).
//
// Why this works:
// - The problem allows rotation until a student takes the sandwich they want.  
// - Once no student wants the current sandwich, the remaining students cannot eat, so we stop.
//
// Time Complexity: O(n) (single pass through students and sandwiches)
// Space Complexity: O(1) (only two counters used)



class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int ones = 0; //count of students who prefer type1
        int zeros = 0; //count of students who prefer type0
		
        for(int stud : students){
            if(stud == 0) zeros++;
            else ones++;
        }
        
        // for each sandwich in sandwiches
        for(int sandwich : sandwiches){
            if(sandwich == 0){  // if sandwich is of type0
                if(zeros == 0){ // if no student want a type0 sandwich
                    return ones;
                }
                zeros--;
            }
            else{  // if sandwich is of type1
                if(ones == 0){  // if no student want a type1 sandwich 
                    return zeros;
                }
                ones--;
            }
        }
        return 0;
    }
}
