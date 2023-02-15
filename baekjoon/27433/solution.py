// [문제 링크]: https://www.acmicpc.net/problem/27433

import sys
input = sys.stdin.readline
​
N = int(input())
result = 1
for i in range(1, N + 1) :
    result *= i
print(result)