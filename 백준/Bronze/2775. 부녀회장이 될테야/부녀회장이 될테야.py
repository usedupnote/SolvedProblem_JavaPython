T = int(input())

for countTestcase in range(1, T+1) :
    k = int(input())
    n = int(input())

    house = []

    for i in range(1, n+1):
        house.append([i])
    for i in range(k):
        house[0].append(1)

    for i in range(1, n) :
        for j in range(1, k+1) :
            house[i].append(house[i-1][j] + house[i][j-1])

    print(house[n-1][k])