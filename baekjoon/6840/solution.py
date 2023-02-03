// [문제 링크]: https://www.acmicpc.net/problem/6840

import sys
input = sys.stdin.readline
​
num = []
​
for i in range(3) :
    num.append(int(input()))
    
num.sort()
​
print(num[1])