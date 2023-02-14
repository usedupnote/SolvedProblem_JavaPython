import sys
input = sys.stdin.readline

N, M = map(int, input().split())

stringCompose = []
stringOriginal = []

for i in range(N):
    stringCompose.append(list(input().strip()))

for i in range(N):
    stringOriginal.append(list(input().strip()))

    result = "Eyfa"
for i in range(N):
    for j in range(M) :
        if stringOriginal[i][j * 2] != stringCompose[i][j] or stringOriginal[i][(j * 2) + 1] != stringCompose[i][j] :
            result = "Not Eyfa"
            break

print(result)