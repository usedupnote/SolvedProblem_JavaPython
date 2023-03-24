import sys
input = sys.stdin.readline

N, M = map(int, input().split())

mapping = [[] for _ in range(N)]

for i in range(N) :
    mapping[i] = list(input())

v = [[0]* M for _ in range(N)]

dirx = [-1, 0, 1, 0] # 상 우 하 좌
diry = [0, 1, 0, -1]

visit = []

visit.append([0, 0])
mapping[0][0] = 1

while True:
    pop = visit.pop(0)

    if pop[0] == N-1 and pop[1] == M-1 :
        print(mapping[N-1][M-1])
        break

    for i in range(4) :
        di = pop[0] + dirx[i]
        dj = pop[1] + diry[i]

        if (0<=di<N) and (0<=dj<M) :
            if mapping[di][dj] == '1' :
                mapping[di][dj] = mapping[pop[0]][pop[1]] + 1
                visit.append([di, dj])