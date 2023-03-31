import sys
input = sys.stdin.readline

N, M, V = map(int, input().split())
V -= 1

graphMap = [[True for _ in range(N)] for _ in range(N)]

for i in range(M) :
    start, end = map(int, input().split())

    start -= 1
    end -= 1

    graphMap[start][end] = False
    graphMap[end][start] = False

v = [False for _ in range(N)]

def DFS(cnt, to) :
    if cnt == N : return
    v[to] = True

    print(to + 1, end=" ")

    for i in range(N) :
        if graphMap[to][i] or v[i] : continue
        DFS(cnt+1, i)

def BFS(cnt, to) :
    q = []
    q.append(to)

    v = [False for _ in range(N)]
    v[to] = True

    print(to + 1, end=" ")

    while len(q) != 0 :
        remove = q.pop(0)

        for i in range(N) :
            if graphMap[remove][i] or v[i] : continue
            v[i] = True
            print(i + 1, end=" ")
            q.append(i)

DFS(0, V)
print()
BFS(0, V)