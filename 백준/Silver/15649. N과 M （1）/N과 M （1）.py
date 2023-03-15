import sys
input = sys.stdin.readline

N, M = map(int, input().split())

result = [0 for _ in range(N + 1)]
v = [0 for _ in range(M)]

def prem(cnt):
    if cnt == M :
        for i in range(M) :
            print(v[i], end=" ")
        print()
        return

    for i in range(1, N+1) :
        if result[i] != 0 :
            continue
        v[cnt] = i
        result[i] = 1
        prem(cnt + 1)
        result[i] = 0

prem(0)