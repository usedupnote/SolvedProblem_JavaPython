// [문제 링크]: https://www.acmicpc.net/problem/27324

import sys
input = sys.stdin.readline
​
n = int(input())
​
if (n // 10) - (n % 10) == 0 :
    print(1)
else :
    print(0)