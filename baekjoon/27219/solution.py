// [문제 링크]: https://www.acmicpc.net/problem/27219

import sys
input = sys.stdin.readline
​
n = int(input())
​
print('V'* (n // 5), 'I'* (n % 5), sep="")