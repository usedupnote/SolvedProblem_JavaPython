import sys
input = sys.stdin.readline

N = int(input())
num = list(map(int, input().split()))

result = 0
for i in range(N) :
    result = max(result, num[i] + i - N)

print(result)