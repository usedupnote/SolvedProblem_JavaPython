import sys
input = sys.stdin.readline

score = [6, 3, 2, 1, 2]

result = [0, 0]

for i in range(2) :
    N = list(map(int, input().split()))
    for j in range(5) :
        result[i] += score[j] * N[j]

print(*result)