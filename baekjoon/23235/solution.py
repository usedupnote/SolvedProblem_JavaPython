// [문제 링크]: https://www.acmicpc.net/problem/23235

import sys
input = sys.stdin.readline
T = 0
​
while True :
    num = list(map(int, input().split()))
    if (num[0] == 0) : break
    T += 1
    print("Case ", T, ": Sorting... done!", sep="")