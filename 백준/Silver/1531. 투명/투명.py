import sys
input = sys.stdin.readline

N, M = map(int, input().split())

box = [[0] * 101 for _ in range(101)]
result = 0

for i in range(N) :
    squr = list(map(int, input().split()))

    for j in range(squr[0], squr[2]+1) :
        for k in range(squr[1], squr[3]+1) :
            box[j][k] += 1

for i in range(101) :
    for j in range(101) :
        if box[i][j] > M :
            result += 1

print(result)