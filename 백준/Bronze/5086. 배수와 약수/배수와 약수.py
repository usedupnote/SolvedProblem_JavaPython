import sys

N, M = map(int, sys.stdin.readline().split())

while N + M != 0:
    if N % M == 0 : print("multiple")
    elif M % N == 0 : print("factor")
    else : print("neither")

    N, M = map(int, sys.stdin.readline().split())