// [문제 링크]: https://www.acmicpc.net/problem/1059

import sys
input = sys.stdin.readline
​
L = int(input())
​
S = list(map(int, input().split()))
​
n = int(input())
​
minimum = 0
maximum = 1000
​
for i in S :
​
    if i == n :
        maximum = n
        minimum = n
        break
    elif i < n :
        minimum = max(minimum, i)
    else :
        maximum = min(maximum, i)
​
​
​
if maximum - minimum < 2 :
    print(0)
else :
    minimum = n - (minimum + 1)
    maximum = (maximum - 1) - n
​
    print((minimum * maximum) + (minimum + maximum))