// Problem: Highest Value Palindrome (Richie Rich)
// Link: https://www.hackerrank.com/challenges/richie-rich
//
// Approach:
// 1. We are given a numeric string and can change at most K digits.
//    Goal: Make the string a palindrome with the highest possible value.
//
// 2. Steps:
//    - First pass: Count mismatched pairs (i, n-1-i).
//      These mismatches MUST be fixed to form a palindrome, so each one consumes changes.
//    - If mismatches > K → impossible → return "-1".
//
//    - Second pass (greedy):
//      • If both digits in a pair are not '9':
//         - If we have spare changes after ensuring palindrome, upgrade both to '9' 
//           (cost: 2 changes, or 1 if one side already needed a change).
//      • If digits mismatch but one is bigger → copy the larger to the smaller (cost: 1 change).
//      • Track how many changes are left.
//
//    - Handle the middle digit (if string length is odd):
//      • If we still have ≥1 change left, turn it into '9'.
//
// 3. Result is the highest value palindrome achievable within K changes.
//
// Time Complexity: O(N) (two passes over string)
// Space Complexity: O(N) (mutable StringBuilder)



import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		int numberOfDigits = reader.nextInt();
		int maximumDigitsToBeAltered = reader.nextInt();
		String inputString = reader.next();
		String result = richieRich(inputString, numberOfDigits, maximumDigitsToBeAltered);
		System.out.println(result);
	}

	static String richieRich(String inputString, int numberOfDigits, int maximumDigitsToBeAltered) {
		String palindrome = "";
		int allDigitsWithoutNine = inputString.replaceAll("9", "").length();
		if (allDigitsWithoutNine <= maximumDigitsToBeAltered) {
			String regex = "[0-8]";
			palindrome = inputString.replaceAll(regex, "9");
			return palindrome;
		}
		StringBuilder strBuilder = new StringBuilder(inputString);
		int nonMatches = 0;
	
		for (int i = 0; i < numberOfDigits / 2; i++) {
			int mirrorIndex = numberOfDigits - 1 - i;
			if (strBuilder.charAt(i) != strBuilder.charAt(mirrorIndex)) {
				nonMatches++;
			}
		}

		int indexOfTransition = 0;
		if (nonMatches < maximumDigitsToBeAltered) {

			for (int i = 0; i < numberOfDigits / 2; i++) {
				int mirrorIndex = numberOfDigits - 1 - i;
				if (strBuilder.charAt(i) != '9' && strBuilder.charAt(mirrorIndex) != '9') {
					if (strBuilder.charAt(i) != strBuilder.charAt(mirrorIndex)) {
						nonMatches--;
					}
					if (nonMatches > maximumDigitsToBeAltered - 2) {
						indexOfTransition = i;
						break;
					}

					strBuilder.setCharAt(i, '9');
					strBuilder.setCharAt(mirrorIndex, '9');
					maximumDigitsToBeAltered -= 2;

					if (nonMatches == maximumDigitsToBeAltered) {
						indexOfTransition = i + 1;
						break;
					}

				} else if (strBuilder.charAt(i) != strBuilder.charAt(mirrorIndex)) {

					if (Character.getNumericValue(strBuilder.charAt(i)) > Character
							.getNumericValue(strBuilder.charAt(mirrorIndex))) {
						strBuilder.setCharAt(mirrorIndex, strBuilder.charAt(i));
						maximumDigitsToBeAltered--;
						nonMatches--;
					} else {
						strBuilder.setCharAt(i, strBuilder.charAt(mirrorIndex));
						maximumDigitsToBeAltered--;
						nonMatches--;
					}
				}
			}
		}

		for (int i = indexOfTransition; i < numberOfDigits / 2; i++) {
			int mirrorIndex = numberOfDigits - 1 - i;
			if (strBuilder.charAt(i) != strBuilder.charAt(mirrorIndex)) {
				if (Character.getNumericValue(strBuilder.charAt(i)) > Character
						.getNumericValue(strBuilder.charAt(mirrorIndex))) {
					strBuilder.setCharAt(mirrorIndex, strBuilder.charAt(i));
					maximumDigitsToBeAltered--;
					if (maximumDigitsToBeAltered == 0) {
						break;
					}
				} else {
					strBuilder.setCharAt(i, strBuilder.charAt(mirrorIndex));
					maximumDigitsToBeAltered--;
					if (maximumDigitsToBeAltered == 0) {
						break;
					}
				}
			}
		}
		if (!isPalindrome(strBuilder.toString())) {
			return "-1";
		}
		if (strBuilder.toString().length() % 2 != 0
				&& maximumDigitsToBeAltered>0) {
			int midIndex = strBuilder.toString().length() / 2;
			if (strBuilder.charAt(midIndex) != '9') {
				strBuilder.setCharAt(midIndex, '9');
			}
		}
		palindrome = strBuilder.toString();
		return palindrome;
	}

	public static boolean isPalindrome(String inputString) {
		StringBuilder strBuilder = new StringBuilder(inputString);
		if (strBuilder.reverse().toString().equals(inputString)) {
			return true;
		}
		return false;
	}
}
