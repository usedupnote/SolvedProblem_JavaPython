import sys

N = int(sys.stdin.readline())

num = 0

for i in range(1, N+1) :
    num += i
    if num == N :
        print(i)
        break
    elif num > N :
        print(i-1)
        break