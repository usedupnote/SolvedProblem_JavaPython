dirX = [-1,1,0,0]   # 상 하 좌 우
dirY = [0,0,-1,1]

import sys
input = sys.stdin.readline

R,C = map(int, input().split())

m = [[] for _ in range(R)]

posJ = []
posF = []

for i in range(R) :
    m[i] = list(input().strip())
    for j in range(C) :
        if m[i][j] == 'J':
            posJ.append([i,j])
        if m[i][j] == 'F':
            posF.append([i,j])

def miro() :
    cnt = 0
    while len(posJ) != 0:
        cnt+=1

        lenF = len(posF)
        for i in range(lenF):
            popF = posF.pop(0)
            for d in range(4):
                dx = popF[0] + dirX[d]
                dy = popF[1] + dirY[d]

                if 0 <= dx and dx < R and 0 <= dy and dy < C and m[dx][dy] == ".":
                    m[dx][dy] = "F"
                    posF.append([dx, dy])

        lenJ = len(posJ)
        for i in range(lenJ):
            popJ = posJ.pop(0)
            for d in range(4):
                dx = popJ[0] + dirX[d]
                dy = popJ[1] + dirY[d]

                if 0 <= dx and dx < R and 0 <= dy and dy < C:
                    if m[dx][dy] == ".":
                        m[dx][dy] = "J"
                        posJ.append([dx, dy])
                else:
                    return cnt
    return "IMPOSSIBLE"

print(miro())