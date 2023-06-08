import sys
input = sys.stdin.readline

N = int(input())
num = list(map(int, input().split()))

result = -1001
cur = 0

for i in num :
    cur += i
    result = max(result, cur)
    if cur < 0 :
        cur = 0
print(result)