import sys
N = int(sys.stdin.readline())

num = list(map(int, input().split()))
num.sort()

result = 0

for i in range(N) :
    result += num[i] * N
    N -= 1
print(result)