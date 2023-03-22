import sys
input = sys.stdin.readline

N, M = map(int, input().split())
num = list(map(int, input().split()))

num.sort()

v = [[False] for _ in range(N)]
result = [[0] for _ in range(M)]

def comb(cnt, start) :
    if cnt == M :
        for i in range(M) :
            print(result[i], end=" ")
        print()
        return

    for i in range(start, N) :
        result[cnt] = num[i]
        comb(cnt+1, i)

comb(0, 0)