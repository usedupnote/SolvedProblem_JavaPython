import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T) :
    N = int(input())
    num = [0] + list(map(int, input().split()))
    v = [False for _ in range(N+1)]
    cnt = 0
    for i in range(1, N+1) :
        if v[i] :
            continue
        a = num[i]
        cnt+=1
        while a != i :
            v[a] = True
            a = num[a]
    print(cnt)