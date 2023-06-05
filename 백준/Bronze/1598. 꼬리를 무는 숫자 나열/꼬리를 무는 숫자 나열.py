import sys
input = sys.stdin.readline

N, M = map(int, input().split())
N-=1
M-=1
result = ((M//4) - (N//4)) + abs((M%4) - (N%4))

print(result)
