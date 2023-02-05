// [문제 링크]: https://www.acmicpc.net/problem/26545

import sys
input = sys.stdin.readline
​
N = int(input())
result = 0
​
for i in range(N) :
    result += int(input())
    
print(result)