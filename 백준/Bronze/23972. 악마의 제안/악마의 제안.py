import sys

K, N = map(int, sys.stdin.readline().split())

if N == 1:
    print(-1)
else:
    result = K * N // (N - 1)
    if (K * N) % (N - 1) : result += 1
    print(result)