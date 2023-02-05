// [문제 링크]: https://www.acmicpc.net/problem/27328

import sys
input = sys.stdin.readline
​
A = int(input())
B = int(input())
​
if A < B :
    print(-1)
elif A > B :
    print(1)
else :
    print(0)