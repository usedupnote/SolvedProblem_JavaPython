import sys
input = sys.stdin.readline

N = int(input())
checkPoint = int(input())

posX = -1
posY = 0
checkPointPos = [0, 0]
d = 0
count = N * N
map = [[0] * N for _ in range(N)]

dirX = [1, 0, -1, 0] # 하우상좌
dirY = [0, 1, 0, -1]

while count > 0 :
    dx = posX + dirX[d]
    dy = posY + dirY[d]

    if dx < 0 or dx >= N or dy < 0 or dy >= N :
        d = (d + 1) % 4
    elif map[dx][dy] != 0 :
        d = (d + 1) % 4

    posX = posX + dirX[d]
    posY = posY + dirY[d]

    if checkPoint == count :
        checkPointPos = [posX + 1, posY + 1]

    map[posX][posY] = count
    count -= 1

for i in range(N) :
    print(*map[i])

print(*checkPointPos)