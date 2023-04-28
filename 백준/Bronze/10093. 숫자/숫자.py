import sys
input = sys.stdin.readline

N, M = map(int, input().split())

if N == M :
    print(0)
else :
    if N > M :
        N += M
        M = N - M
        N -= M

    print(M - N - 1)
    for TC in range(N+1, M) :
        print(TC, end=" ")