// Problem: Multiple of 9 and 0
// Link: https://www.hackerrank.com/challenges/constructing-a-number  (related variant)
//
// Approach (BFS with Remainder Tracking):
// 1. We need to find the smallest number (in decimal form) composed only of digits {0, 9} 
//    that is divisible by N.
// 2. Brute force (generate numbers and check divisibility) will not work 
//    because the answer can be very large.
// 3. Instead, use BFS to construct numbers digit by digit (only 0 and 9):
//    - Start with 0.
//    - At each step, append either '0' or '9' to the current number.
//    - Represent each candidate as BigInteger (since result can be huge).
// 4. To avoid cycles, keep track of visited remainders modulo N:
//    - If remainder == 0 → we found the answer.
//    - Else, mark remainder visited and continue BFS.
// 5. BFS guarantees the first valid number found is the smallest one.
// 
// Time Complexity: O(N) (each remainder visited once)
// Space Complexity: O(N) (visited array and queue)


import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static final int LIMIT = 500;
	static final int[] DIGITS = { 0, 9 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			System.out.println(solve(N));
		}

		sc.close();
	}

	static BigInteger solve(int N) {
		boolean[] visited = new boolean[N];

		Queue<BigInteger> queue = new LinkedList<BigInteger>();
		queue.offer(BigInteger.valueOf(DIGITS[0]));
		while (true) {
			BigInteger head = queue.poll();

			for (int digit : DIGITS) {
				if (head.equals(BigInteger.ZERO) && digit == 0) {
					continue;
				}

				BigInteger next = head.multiply(BigInteger.TEN).add(BigInteger.valueOf(digit));

				int remainder = next.mod(BigInteger.valueOf(N)).intValue();
				if (remainder == 0) {
					return next;
				} else if (!visited[remainder]) {
					visited[remainder] = true;
					queue.offer(next);
				}
			}
		}
	}
}
