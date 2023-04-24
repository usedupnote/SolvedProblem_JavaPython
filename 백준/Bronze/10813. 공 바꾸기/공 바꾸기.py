import sys
input = sys.stdin.readline

N, M = map(int, input().split())

basket = [i for i in range(N+1)]

for i in range(M) :
    i, j = map(int, input().split())

    if i == j : continue

    basket[i] += basket[j]
    basket[j] = basket[i] - basket[j]
    basket[i] -= basket[j]

for i in range(1, N+1) :
    print(basket[i], end=" ")