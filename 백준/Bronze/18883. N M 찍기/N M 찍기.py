import sys
input = sys.stdin.readline

N, M = map(int, input().split())
cnt = 1
for i in range(N) :
    for j in range(1, M) :
        print(cnt, end=" ")
        cnt += 1

    print(cnt)
    cnt += 1