import sys

N = int(sys.stdin.readline())

result = 0

for i in range(N) :
    A, B = map(int, sys.stdin.readline().split())
    result += B % A

print(result)