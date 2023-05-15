dirX = [0,-1,1,0,0]    #무 상 하 좌 우
dirY = [0,0,0,-1,1]

import sys
input = sys.stdin.readline

R, C = map(int, input().split())

ground = [[0 for _ in range(C)]for _ in range(R)]

block = int(input())

for i in range(block) :
    br, bc = map(int, input().split())
    ground[br][bc] = -1

move = list(map(int,input().split()))
dir = list(map(int,input().split()))
dir.append(0)

def order(m, dCnt) :
    while True:

        ground[m[0]][m[1]] = -1
        for d in range(5):
            if d == 4:
                return m

            dx = m[0] + dirX[dir[(dCnt+d)%4]]
            dy = m[1] + dirY[dir[(dCnt+d)%4]]

            if 0 <= dx and dx < R and 0 <= dy and dy < C:
                if ground[dx][dy] == -1:
                    continue
                m = [dx, dy]
                dCnt = (dCnt + d) % 4
                break

result = order(move, 0)

print(result[0], result[1])