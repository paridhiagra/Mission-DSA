// Problem: Priyanka and Toys
// Link: https://www.hackerrank.com/challenges/priyanka-and-toys
//
// Approach:
// 1. Priyanka buys toys in groups where each toy's weight is within 4 units
//    of the minimum weight in that group.
// 2. Sort the toy weights.
// 3. Start with the first toy's weight as the base (minWeight).
// 4. For each toy:
//      - If its weight ≤ minWeight + 4, it belongs to the current group.
//      - Otherwise, start a new group with this toy as new base.
// 5. Count the number of groups = number of containers needed.
// Time Complexity: O(n log n) (due to sorting)
// Space Complexity: O(1)


import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int units = 1;
        
        //Initialize the array of toys
        int[] toys = new int[n];
        for(int i = 0; i < n; i++)
            toys[i] = input.nextInt();
        
        Arrays.sort(toys); //Sort the toys ascending by weight
        
        int currentWeight = toys[0];
        for(int weight : toys)
        {
            if(!(weight <= currentWeight+4))
            {
                units++;
                currentWeight = weight;
            }
        }
        
        System.out.println(units);
    }
}
