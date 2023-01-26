// [문제 링크]: https://www.acmicpc.net/problem/2501

import sys
input = sys.stdin.readline
​
N, K = map(int, input().split())
​
i = 1
result = 0
​
for i in range(1, N//2 + 1) :
    if N % i == 0 :
        K -= 1
​
    if K <= 0 :
        result = i
        break
​
    i += 1
​
if result == 0 :
    if K <= 1 :
        result = N
​
print(result)