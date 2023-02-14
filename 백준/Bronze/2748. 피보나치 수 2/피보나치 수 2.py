import sys

N = int(sys.stdin.readline())

result = [0, 1]

for i in range(1, N+1) :
    result.append(result[i] + result[i-1])
print(result[N])