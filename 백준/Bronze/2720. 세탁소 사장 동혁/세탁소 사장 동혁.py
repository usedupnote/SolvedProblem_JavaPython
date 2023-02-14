import sys

T = int(sys.stdin.readline())

coin = [25, 10, 5, 1]

for i in range(T) :
    N = int(sys.stdin.readline())

    coinCount = []

    for j in coin :
        coinCount.append(N//j)
        N = N % j
    print(*coinCount)