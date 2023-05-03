import sys
input = sys.stdin.readline

N = int(input())

num = [[0, 0] for _ in range(N)]
num[0] = [1, 0]

for i in range(1, N) :
    num[i] = [num[i-1][1], num[i-1][0] + num[i-1][1]]

print(num[N-1][0] + num[N-1][1])