import sys
input = sys.stdin.readline

N, M = map(int, input().split())

num = [0] * N

for _ in range(M) :
    i, j, k = map(int, input().split())

    for n in range(i-1, j) :
        num[n] = k

print(str(num).replace("[", "").replace(",", "").replace("]", ""))