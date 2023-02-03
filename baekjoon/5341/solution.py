// [문제 링크]: https://www.acmicpc.net/problem/5341

import sys
input = sys.stdin.readline
​
count = 1
num = [0, 1]
​
while count < 100 :
    count += 1
    num.append(count + num[count-1])
​
A = int(input())
​
while A != 0 :
    print(num[A])
    A = int(input())