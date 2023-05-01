dirX = [1,0,-1,0]    #하 좌 상 우 (+ 우회전)
dirY = [0,-1,0,1]

import sys
input = sys.stdin.readline

N = int(input())

move = input()
dir = 0

x = 0
y = 0

minX = 0
minY = 0
maxX = 0
maxY = 0

saveGround = [[0, 0]]

for i in range(N) :
    if move[i] == 'R' :
        dir = (dir + 1) % 4
    elif move[i] == 'L' :
        dir = (dir - 1) % 4
    else :
        x += dirX[dir]
        y += dirY[dir]
        minX = min(minX, x)
        minY = min(minY, y)
        maxX = max(maxX, x)
        maxY = max(maxY, y)
        saveGround.append([x, y])

ground = [['#' for _ in range(maxY - minY + 1)]for _ in range(maxX - minX+ 1)]

while len(saveGround) != 0 :
    pop = saveGround.pop()
    ground[pop[0] - minX][pop[1] - minY] = '.'

for i in range(maxX - minX + 1) :
    for j in range(maxY - minY + 1) :
        print(ground[i][j], end="")
    print()