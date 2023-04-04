dirX = [-1,-1,0,1,1,1,0,-1]   # 상 상우 우 우하 하 하좌 좌 좌상
dirY = [0,1,1,1,0,-1,-1,-1]

import sys
input = sys.stdin.readline

N, M = map(int, input().split())

banner = [[] for _ in range(N)]

for i in range(N) :
    banner[i] = list(map(int,input().split()))

def bfs(i, j) :
    q = []
    q.append([i, j])

    while len(q) != 0 :
        pop = q.pop()

        for d in range(8) :
            dx = pop[0] + dirX[d]
            dy = pop[1] + dirY[d]

            if 0<=dx and dx<N and 0<=dy and dy<M :
                if banner[dx][dy] == 0 :
                    continue
                banner[dx][dy] = 0
                q.append([dx,dy])

cnt = 0

for i in range(N) :
    for j in range(M) :
        if banner[i][j] == 1 :
            bfs(i,j)
            cnt += 1

print(cnt)