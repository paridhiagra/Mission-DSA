// Problem: Number of Students Unable to Eat Lunch
// Link: https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/

// Approach (Count & Stop Principle):
// 1. Count preferences (0s and 1s).
// 2. Iterate through sandwiches:
//    - If someone wants current sandwich, serve it (decrement).
//    - Else stop and return remaining hungry students.
// Time Complexity: O(n)
// Space Complexity: O(1)


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
