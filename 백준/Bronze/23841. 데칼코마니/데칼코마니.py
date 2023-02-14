import sys
input = sys.stdin.readline

N, M = map(int, input().split())

painting = []

for i in range(N) :
    painting.append(list(input().strip()))

    for j in range(M) :
        if painting[i][j] != "." :
            painting[i][M - j - 1] = painting[i][j]

    print(*painting[i], sep="")