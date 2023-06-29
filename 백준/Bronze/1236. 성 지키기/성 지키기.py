import sys
input = sys.stdin.readline

N, M = map(int, input().split())
result = 0
checkRow = [1 for _ in range(N)]
checkCol = [1 for _ in range(M)]
for i in range(N) :
    castle = list(input())
    for j in range(M) :
        if castle[j] == 'X' :
            checkRow[i] = 0
            checkCol[j] = 0

print(max(sum(checkRow), sum(checkCol)))