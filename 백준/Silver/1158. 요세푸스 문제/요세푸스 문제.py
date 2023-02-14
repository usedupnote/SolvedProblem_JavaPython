import sys

N, K = map(int, sys.stdin.readline().split())

point = 0

num = []
result = []

for i in range(1, N+1) :
    num.append(i)

for i in range(N) :
    point = (point + K - 1)%(N-i)

    result.append(num.pop(point))

print("<", end="")
print(*result, sep=", ", end="")
print(">")