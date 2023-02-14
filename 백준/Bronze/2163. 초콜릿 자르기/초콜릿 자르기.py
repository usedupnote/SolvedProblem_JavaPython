import sys

N, M = map(int, sys.stdin.readline().split())

print(N-1 + (M-1)*N)