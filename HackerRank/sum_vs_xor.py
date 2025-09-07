# Problem: Sum vs XOR
# Link: https://www.hackerrank.com/challenges/sum-vs-xor
#
# Approach:
# 1. We need to count how many values of x satisfy: n + x = n ^ x.
# 2. Observation:
#    - For each bit position:
#      • If n has a 1 → x must have 0 (otherwise carry will break equality).
#      • If n has a 0 → x can be 0 or 1 (both are valid).
# 3. Therefore, the number of valid x values = 2^(count of zero bits in n).
# 4. Special case: if n = 0 → result = 1 (since only x = 0 works).
# Time Complexity: O(log n) (counting bits)
# Space Complexity: O(1)


import math
import os
import random
import re
import sys

def sumXor(n):
    return 2**bin(n)[2:].count('0') if n else 1
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    result = sumXor(n)

    fptr.write(str(result) + '\n')

    fptr.close()
