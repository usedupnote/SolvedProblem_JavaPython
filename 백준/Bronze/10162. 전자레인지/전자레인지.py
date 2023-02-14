import sys

N = int(sys.stdin.readline())

num = []

if N % 10 != 0 :
    num.append(-1)
else :
    num.append(N // 300)
    N = N % 300
    num.append(N//60)
    N = N % 60
    num.append(N//10)

print(*num)