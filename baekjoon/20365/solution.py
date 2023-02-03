// [문제 링크]: https://www.acmicpc.net/problem/20365

import sys
input = sys.stdin.readline
​
N = int(input())
post = list(input().strip())
​
count = {"R" : 0, "B" : 0}
​
result = 0
​
count[post[0]] += 1
​
for i in range(1, N):
    if post[i - 1] != post[i]:
        count[post[i]] += 1
​
result = min(count["R"], count["B"]) + 1
​
print(result)