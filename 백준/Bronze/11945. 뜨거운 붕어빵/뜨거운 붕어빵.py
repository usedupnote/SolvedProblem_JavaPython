import sys
input = sys.stdin.readline

N, M = map(int, input().split())

goldenFish = []

for i in range(N) :
    shape = list(input().strip())

    shape.reverse()

    goldenFish.append(shape)

for i in range(N) :
    print(*goldenFish[i], sep="")