import sys
N = int(sys.stdin.readline().strip())

drink = list(map(int, sys.stdin.readline().split()))

drink.sort()

for i in range(N - 1) :
    drink[N-1] += drink[i] / 2

print(drink[N-1])