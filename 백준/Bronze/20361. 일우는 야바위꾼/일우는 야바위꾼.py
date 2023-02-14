import sys
input = sys.stdin.readline

N, X, K = map(int, input().split())

cup = []

for i in range(N + 1) :
    if i == X :
        cup.append(1)
    else :
        cup.append(0)

for i in range(K) :
    num = list(map(int, input().split()))

    if cup[num[0]] != cup[num[1]]:
        cup[num[0]], cup[num[1]] = cup[num[1]], cup[num[0]]

for i in range(N + 1) :
    if cup[i] == 1 :
        print(i)
        break