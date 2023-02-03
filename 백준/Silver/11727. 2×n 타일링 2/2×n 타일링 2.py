import sys
input = sys.stdin.readline

N = int(input())

num = [1, 3]
result = 0

for i in range(2, N):
    num.append((num[i - 2] * 2) + num[i - 1])

print(num[N-1] % 10007)