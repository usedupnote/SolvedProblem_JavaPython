import sys

M, N = map(int, sys.stdin.readline().split())

num = [1] * (N + 1)

num[0] = 0
num[1] = 0

for i in range(2, N+1) :
    if num[i] == 1 :
        check = i * 2
        while check <= N :
            num[check] = 0
            check += i

for i in range(M, N + 1) :
    if num[i] == 1 :
        print(i)