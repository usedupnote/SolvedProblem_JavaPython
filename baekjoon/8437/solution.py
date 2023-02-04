// [문제 링크]: https://www.acmicpc.net/problem/8437

import sys
input = sys.stdin.readline
​
A = int(input())
B = int(input())
​
print((A-B) // 2 + B, "\n", (A-B) // 2, sep="")