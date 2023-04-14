import sys
input = sys.stdin.readline

dirX = [-1, 1, 0, 0] # 상 하 좌 우
dirY = [0, 0, -1, 1]

M, N = map(int, input().split())

tray = [[] for _ in range(N)]

count = 0
tomato = []

for i in range(N) :
    tray[i] = list(map(int, input().split()))

    for j in range(M) :
        if tray[i][j] == 0 :
            count += 1
        elif tray[i][j] == 1 :
            tomato.append([i,j])

dx = 0
dy = 0
cnt = 0

while len(tomato) != cnt :
    if count == 0:
        break
    pop = tomato[cnt]
    cnt += 1

    for d in range(4) :
        if count == 0 :
            break
        dx = pop[0] + dirX[d]
        dy = pop[1] + dirY[d]

        if 0<=dx and dx<N and 0<=dy and dy<M :
            if tray[dx][dy] != 0 :
                continue
            tray[dx][dy] = tray[pop[0]][pop[1]] + 1
            count -= 1
            tomato.append([dx,dy])

if count != 0 :
    print(-1)
else :
    print(tray[dx][dy] - 1)