import sys
input = sys.stdin.readline

compare = 0
result = 0

for i in range(10) :
    station = list(map(int, input().split()))
    compare += station[1] - station[0]
    result = max(compare, result)

print(result)