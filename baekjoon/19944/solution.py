// [문제 링크]: https://www.acmicpc.net/problem/19944

import sys
input = sys.stdin.readline
​
N, M = map(int, input().split())
​
result = ""
​
if M <= 2 :
    result = "NEWBIE!"
elif M <= N :
    result = "OLDBIE!"
else :
    result = "TLE!"
​
print(result)