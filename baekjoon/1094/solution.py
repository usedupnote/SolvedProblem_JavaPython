// [문제 링크]: https://www.acmicpc.net/problem/1094

import sys
input = sys.stdin.readline
​
N = int(input())
​
bar = 64
count = 1
​
while True :
    if N == bar :
        print(count)
        break
    elif N > bar :
        N -= bar
        count += 1
    else :
        bar /= 2