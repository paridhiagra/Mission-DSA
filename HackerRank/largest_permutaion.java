// Problem: Largest Permutation
// Link: https://www.hackerrank.com/challenges/largest-permutation

// Approach:
// 1. The largest permutation should be in descending order: n, n-1, ..., 1.
// 2. At each index i, the correct number should be (n - i).
// 3. If it's not already there, find its index using a map (value → index).
// 4. Swap it into position i, update map, and reduce k.
// 5. Stop when k == 0 or array is already largest.
// Time Complexity: O(n)
// Space Complexity: O(n) (for the map)


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scc = new Scanner(System.in);
        int n = scc.nextInt();
        int k = scc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scc.nextInt();
        }
        
        
        for(int i=0; i<k && i<n; i++){
            int j;
            for(j=i; j<n; j++){
                if(arr[j]==n-i){
                    break;
                }
            }
            if(j!=i){
               int temp = arr[j];
               arr[j] = arr[i];
               arr[i] = temp;
            }
            else{
                k++;
            }
        }
        
        for(int i=0; i<n; i++)
            System.out.print(arr[i]+" ");
    }
}
