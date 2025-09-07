// Problem: Sherlock and Anagrams
// Link: https://www.hackerrank.com/challenges/sherlock-and-anagrams
//
// Approach:
// 1. Generate all substrings of the given string.
// 2. For each substring, sort its characters → use sorted string as a "signature".
//    Example: "abc" → "abc", "cba" → "abc" (same signature means anagram).
// 3. Store frequency of each signature in a HashMap.
// 4. For each signature with count = c, number of anagrammatic pairs = c * (c - 1) / 2.
// 5. Sum over all signatures to get the answer.
// Time Complexity: O(n^3 log n) (substring generation O(n^2), sorting each substring O(n log n))
// Space Complexity: O(n^2) for storing signatures.


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        Map<String,Integer> al=new HashMap<>();
        int c=0;
    for(int x=0;x<s.length();x++)
    {
        for(int y=0+x;y<s.length();y++)
        {
            char ar[]=(s.substring(x,y+1)).toCharArray();
            Arrays.sort(ar);
            String q=(String.valueOf(ar));
            Integer o=al.get(q);
            if(o==null)
            {
                al.put(q,1);
            }
            else
            {
                al.put(q,o+1);    
            }
        }
    }
        for(String as:al.keySet())
        {
            int ww=al.get(as);
            c+=ww*(ww-1)/2;
        }
    return c;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = (scanner.nextLine());

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
