import sys
num = list(map(int, sys.stdin.readline().split()))

chess = [1,1,2,2,2,8]

for i in range(6) :
    chess[i] = chess[i] - num[i]

print(*chess)