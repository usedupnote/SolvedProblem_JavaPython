import sys
input = sys.stdin.readline

N = int(input())

room = [[] for _ in range(N)]
move = [[[0 for _ in range(3)] for _ in range(N)] for _ in range(N)]

for i in range(N) :
    room[i] = list(map(int, input().split()))

room[0][1] = -1

dirX = [0,-1,-1] # 우 하 우하
dirY = [-1,0,-1]

for i in range(1, N) :
    if room[0][i] == 1 :
        break
    move[0][i][0] = -1

for i in range(1, N) :
    for j in range(2, N):
        if room[i][j] != 1 :
            move[i][j][0] += move[i][j-1][0] + move[i][j-1][2]
            move[i][j][1] += move[i-1][j][1] + move[i-1][j][2]
            if room[i][j-1] != 1 and room[i-1][j] != 1 :
                move[i][j][2] += move[i-1][j-1][0] + move[i-1][j-1][1] + move[i-1][j-1][2]

print(- move[N-1][N-1][0] - move[N-1][N-1][1] - move[N-1][N-1][2])