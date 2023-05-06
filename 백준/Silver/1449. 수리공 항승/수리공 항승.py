import sys
input = sys.stdin.readline

N, M = map(int, input().split())

repare = list(map(int, input().split()))
repare.sort()

pos = 0
result = 0

for i in range(N) :
    if pos <= repare[i] :
        result += 1
        pos = repare[i] + M

print(result)