// [문제 링크]: https://www.acmicpc.net/problem/1145

import sys
input = sys.stdin.readline
​
num = list(map(int, input().split()))
​
result = 4
while True :
    cnt = 0
​
    for i in range(5) :
        if result % num[i] == 0 :
            cnt += 1
​
    if cnt >= 3 :
        break
​
    result += 1
print(result)