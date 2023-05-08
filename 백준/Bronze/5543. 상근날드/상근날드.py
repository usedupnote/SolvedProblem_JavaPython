import sys
input = sys.stdin.readline

N = 2000
M = 2000

for i in range(3) :
    N = min(N, int(input()))
for i in range(2) :
    M = min(M, int(input()))

print(N + M - 50)