import sys
from itertools import permutations

dirX = [0, 1, 0, -1]
dirY = [1, 0, -1, 0]

input = sys.stdin.readline

result = -1

H, W = map(int, input().split());

Map = []
pos = []
rains = []

for i in range(H) :
    Map.append(list(input().strip()))
    for j in range(W) :
        if Map[i][j] == "W" :
            pos = [i, j]
        elif Map[i][j] == "*" :
            rains.append([i, j])

# 비어있는 칸은 ‘.’
# 소나기는 ‘*’
# 강은 ‘X’
# 태범이의 집은 ‘H’
# 태범이가 처음있던 세차장의 위치는 ‘W’

posList = [pos]
cnt = 0

while len(posList) != 0:
    cnt += 1
    curList = posList.copy()
    posList.clear()

    for cur in curList:
        if Map[cur[0]][cur[1]] == "*":
            continue

        for i in range(4):
            curX = cur[0] + dirX[i]
            curY = cur[1] + dirY[i]
            if curX < H and curY < W and curX >= 0 and curY >= 0:
                if Map[curX][curY] == "H":
                    result = cnt
                    break
                elif Map[curX][curY] == ".":
                    Map[curX][curY] = "W"
                    posList.append([curX, curY])

    if result != -1 :
        break

    curRains = rains.copy()
    rains.clear()

    for rain in curRains:
        for i in range(4):
            curX = rain[0] + dirX[i]
            curY = rain[1] + dirY[i]
            if curX < H and curY < W and curX >= 0 and curY >= 0:
                if Map[curX][curY] == ".":
                    Map[curX][curY] = "*"
                    rains.append([curX,curY])
                elif Map[curX][curY] == "W":
                    Map[curX][curY] = "*"
                    rains.append([curX,curY])

if result == -1 :
    print("FAIL")
else :
    print(result)