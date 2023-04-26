dirX = [-1,1,0,0]
dirY = [0,0,-1,1]

import sys
input = sys.stdin.readline

N = int(input())

town = []

for i in range(N) :
    town.append(list(map(int, str(input().strip()))))

result = []

def bfs(x, y) :
    pos = []
    pos.append([x, y])
    town[x][y] = 0
    compare = 1

    while len(pos) > 0 :
        pop = pos.pop()

        for i in range(4) :
            dx = pop[0] + dirX[i]
            dy = pop[1] + dirY[i]

            if 0<=dx and dx<N and 0<=dy and dy<N :
                if town[dx][dy] == 1 :
                    town[dx][dy] = 0
                    compare += 1
                    pos.append([dx, dy])

    return compare

for i in range(N) :
    for j in range(N) :
        if town[i][j] == 1 :
            result.append(bfs(i, j))

result.sort()

size = len(result)
print(size)
for i in range(size) :
    print(result[i])