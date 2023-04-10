import math
import sys
input = sys.stdin.readline

N = int(input())
print(f'{math.pi * (N*N):.6f}', f'{math.pow(N,2) * 2 :.6f}', sep="\n")