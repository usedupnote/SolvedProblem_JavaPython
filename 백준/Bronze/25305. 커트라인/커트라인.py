import sys
input = sys.stdin.readline

scoreSet = [0 for _ in range(10001)]

N, M = map(int, input().split())

score = list(map(int, input().split()))

for i in range(N) :
    scoreSet[score[i]] += 1

result = 0

for i in range(10000, -1, -1) :
    M -= scoreSet[i]
    if(M <= 0) :
        result = i
        break

print(result)