import sys
input = sys.stdin.readline

DIR_X = [0, -1, 0, 1]
DIR_Y = [-1, 0, 1, 0]

M, N, K = map(int, input().split())

result = []
m = [[True] * N for _ in range(M)]

for _ in range(K) :
    cur = list(map(int, input().split()))

    for i in range(cur[1], cur[3]) :
        for j in range(cur[0], cur[2]) :
            m[i][j] = False

def brs(x, y) :
    m[x][y] = False
    cnt = 1

    l = [[x, y]]

    while len(l) != 0 :
        p = l.pop()

        for d in range(0, 4) :
            curX = p[0] + DIR_X[d]
            curY = p[1] + DIR_Y[d]

            if 0<=curX<M and 0<=curY<N and m[curX][curY] :
                m[curX][curY] = False
                cnt+=1
                l.append([curX, curY])
    return cnt

for i in range(M):
    for j in range(N):
        if m[i][j] :
            result.append(brs(i, j))

result.sort()

print(len(result))
print(*result)