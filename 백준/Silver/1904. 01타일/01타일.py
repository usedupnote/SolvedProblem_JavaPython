import sys
input = sys.stdin.readline

N = int(input())
tile = [0 for _ in range(N + 1)]

tile[0] = 1
tile[1] = 2

for i in range(2, N) :
    tile[i] = (tile[i-1] + tile[i-2]) % 15746

print(tile[N-1])