dirX = [-1,1,0,0]
dirY = [0,0,-1,1]

import sys
input = sys.stdin.readline

N, M = map(int, input().split())

drow = [[] for _ in range(N)]

for i in range(N) :
    drow[i] = list(map(int, input().split()))

maximum = 0

def bfs(x, y) :
    drow[x][y] = -1

    pos = [[x, y]]

    compare = 1

    while len(pos) > 0 :
        pop = pos.pop()

        for i in range(4) :
            dx = pop[0] + dirX[i]
            dy = pop[1] + dirY[i]

            if 0<=dx and dx<N and 0<=dy and dy <M :
                if drow[dx][dy] == 1 :
                    drow[dx][dy] = 0
                    compare += 1
                    pos.append([dx,dy])
    return compare

cnt = 0

for i in range(N) :
    for j in range(M) :
        if drow[i][j] == 1 :
            cnt += 1
            maximum = max(maximum, bfs(i, j))

print(cnt, maximum, sep="\n")