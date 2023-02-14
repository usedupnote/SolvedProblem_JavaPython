import sys
N, K = map(int, sys.stdin.readline().split())

num = []
result = 0

for i in range(N) :
    num.append(int(input()))

num.sort(reverse=True)

for i in num :
    result += K // i
    K = K % i

print(result)