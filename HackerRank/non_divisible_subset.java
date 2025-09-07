// Problem: Non-Divisible Subset
// Link: https://www.hackerrank.com/challenges/non-divisible-subset
//
// Approach:
// 1. We want the largest subset such that the sum of any two numbers is NOT divisible by K.
// 2. Key observation (pigeonhole principle):
//    - Any number belongs to a "bucket" based on remainder = num % K.
//    - For any pair of buckets i and K-i, we can only choose numbers from ONE of them
//      (otherwise their sum would be divisible by K).
// 3. Steps:
//    - Count frequencies of numbers in each remainder bucket (0..K-1).
//    - Always take at most 1 number from bucket 0 (since any two from it would sum to K).
//    - If K is even, also take at most 1 number from bucket K/2 (same reasoning).
//    - For each i in [1 .. K/2], pick the larger count between bucket i and bucket K-i.
// 4. Sum these counts to get the size of the maximum subset.
// 
// Time Complexity: O(N + K) (counting + iterating over buckets)
// Space Complexity: O(K)


import java.io.*;
import java.util.*;
import java.lang.Math;

public class Solution {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int K = input.nextInt();
        
        int nonDivisibleSubsetCardinality = 0;
        
        int[] modulusBuckets = new int[K];
        
        //Place the values in buckets based on mod K
        for(int i = 0; i < N; i++)
        {
            int bucket = input.nextInt() % K;
            modulusBuckets[bucket] += 1;
        }
        
        //Adds 1 if there is only 1 element in the 0 bucket or the k/2 bucket because these are edge cases
        nonDivisibleSubsetCardinality += (modulusBuckets[0] >= 1) ? 1 : 0;
        nonDivisibleSubsetCardinality += (K%2 == 0 && modulusBuckets[K/2] >= 1) ? 1 : 0;
        
        //Determine the max buckets we can use
        int maxBuckets = 0;
        if(K%2 == 0)
        {
            maxBuckets = (K/2)-1;
        }
        else
        {
            maxBuckets = K/2;
        }
        
        //Picks the biggest bucket of each pair for each even sum group
        for(int i = 1; i <= maxBuckets; i++)
        {
            nonDivisibleSubsetCardinality += Math.max(modulusBuckets[i], modulusBuckets[K-i]);
        }
        
        System.out.println(nonDivisibleSubsetCardinality);
    }
}
