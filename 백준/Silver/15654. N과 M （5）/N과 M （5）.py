import sys
input = sys.stdin.readline

N, M = map(int, input().split())
num = list(map(int, input().split()))

num.sort()

v = [[False] for _ in range(N)]
result = [[0] for _ in range(M)]

def perm(cnt) :
    if cnt == M :
        for i in range(M) :
            print(result[i], end=" ")
        print()
        return

    for i in range(N) :
        if v[i] == True :
            continue

        v[i] = True
        result[cnt] = num[i]
        perm(cnt+1)
        v[i] = False

perm(0)