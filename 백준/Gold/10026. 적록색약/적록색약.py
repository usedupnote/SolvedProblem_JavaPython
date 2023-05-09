dirX = [1,0,-1,0]    #하 좌 상 우 (+ 우회전)
dirY = [0,-1,0,1]

import sys
input = sys.stdin.readline

N = int(input())
drow = [[] for _ in range(N)]

for i in range(N) :
    drow[i] = input()

v1 = [[True for _ in range(N)] for _ in range(N)]
v2 = [[True for _ in range(N)] for _ in range(N)]

cntV1 = 0
cntV2 = 0

def bfsForV1(x, y, color) :
    check = [[x, y]]
    v1[x][y] = False

    while len(check) != 0:
        pop = check.pop()

        for d in range(4) :
            dx = pop[0] + dirX[d]
            dy = pop[1] + dirY[d]

            if 0<=dx and dx<N and 0<=dy and dy<N :
                if v1[dx][dy] and drow[dx][dy] == color :
                    v1[dx][dy] = False
                    check.append([dx,dy])

def bfsForV2(x, y, color) :
    check = [[x, y]]
    v1[x][y] = False

    while len(check) != 0:
        pop = check.pop()

        for d in range(4) :
            dx = pop[0] + dirX[d]
            dy = pop[1] + dirY[d]

            if 0<=dx and dx<N and 0<=dy and dy<N :
                if v2[dx][dy] and drow[dx][dy] == color :
                    v2[dx][dy] = False
                    check.append([dx,dy])

def bfsForV3(x, y) :
    check = [[x, y]]
    v2[x][y] = False

    while len(check) != 0:
        pop = check.pop()

        for d in range(4) :
            dx = pop[0] + dirX[d]
            dy = pop[1] + dirY[d]

            if 0<=dx and dx<N and 0<=dy and dy<N :
                if v2[dx][dy] and drow[dx][dy] != 'B':
                    v2[dx][dy] = False
                    check.append([dx,dy])


for i in range(N) :
    for j in range(N) :
        if v1[i][j] :
            bfsForV1(i, j, drow[i][j])
            cntV1 += 1
        if v2[i][j]:
            if drow[i][j] == 'B' :
                bfsForV2(i, j, drow[i][j])
                cntV2 += 1
            else :
                bfsForV3(i, j)
                cntV2 += 1

print(cntV1, cntV2)