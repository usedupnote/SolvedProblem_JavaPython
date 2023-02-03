import sys

N = int(sys.stdin.readline())

result = 0

A = list(map(int, sys.stdin.readline().split()))
B = list(map(int, sys.stdin.readline().split()))

A.sort(reverse=True)
B.sort()

for i in range(N) :
    result += A[i] * B[i]

print(result)