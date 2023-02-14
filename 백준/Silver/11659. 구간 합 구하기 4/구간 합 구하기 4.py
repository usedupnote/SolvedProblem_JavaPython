import sys
input = sys.stdin.readline

N, M = map(int, input().split())

num = list(map(int, input().split()))

checkpoint = []
result = [0]

for _ in range(M) :
    checkpoint.append(list(map(int, input().split())))

for i in range(1, N+1) :
    result.append(result[i-1] + num[i - 1])

for i in range(M) :
    print(result[checkpoint[i][1]] - result[checkpoint[i][0] - 1])