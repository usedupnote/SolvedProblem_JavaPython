// [문제 링크]: https://www.acmicpc.net/problem/1012

import sys
input = sys.stdin.readline
​
# 상 하 우 좌
dirX = [1, -1, 0, 0]
dirY = [0, 0, 1, -1]
​
def search(x, y):
    ground[x][y] = 0
    for i in range(4):
        gx = x + dirX[i]
        gy = y + dirY[i]
​
        if 0 <= gx < M and 0 <= gy < N:
            if ground[gx][gy] != 0:
                search(gx, gy)
​
T = int(input())
​
for test_case in range(T):
    M, N, K = map(int, input().split())
​
    result = 0
​
    ground = [[0] * N for _ in range(M)]
​
    for i in range(K):
        X, Y = map(int, input().split())
​
        ground[X][Y] = 1
​
    for i in range(M):
        for j in range(N):
            if ground[i][j] != 0:
                result += 1
                search(i, j)
​
    print(result)