// [문제 링크]: https://www.acmicpc.net/problem/26123

import sys
input = sys.stdin.readline
​
N, D = map(int, input().split())
height = list(map(int, input().split()))
​
maxHeight = max(height) - D
​
result = 0
​
if maxHeight > 0 :
    for i in height:
        if i > maxHeight:
            result += i - maxHeight
else :
    result = sum(height)
print(result)