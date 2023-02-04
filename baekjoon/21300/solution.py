// [문제 링크]: https://www.acmicpc.net/problem/21300

import sys
input = sys.stdin.readline
​
num = list(map(int, input().split()))
​
print(sum(num) * 5)