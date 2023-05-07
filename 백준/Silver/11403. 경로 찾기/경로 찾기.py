import sys
input = sys.stdin.readline

N = int(input())

graph = [[] for _ in range(N)]

for i in range(N) :
    graph[i] = list(map(int, input().split()))

for k in range(N) :
    for i in range(N) :
        for j in range(N) :
            if graph[i][j] != 0 :
                continue
            graph[i][j] = graph[i][k] & graph[k][j]

for i in range(N) :
    for j in range(N) :
        print(graph[i][j], end=" ")
    print()