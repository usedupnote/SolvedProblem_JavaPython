import sys
from itertools import permutations

input = sys.stdin.readline

result = 0

N, M, K = map(int, input().split());
rails = list(map(int, input().split()))

minWeight = 1_000_000
railsPer = permutations(rails, N)

def work(rail, N, M, K):
    cnt = 0
    weights = 0
    sumWeights = 0

    for i in range(K):
        while True:
            weights += rail[cnt]
            if (weights > M):
                weights -= rail[cnt]
                sumWeights += weights
                weights = 0
                break
            cnt = (cnt + 1) % N
    return sumWeights

for rail in railsPer:
    minWeight = min(minWeight, work(rail, N, M, K))

print(minWeight)