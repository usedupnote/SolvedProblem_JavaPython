import sys
from itertools import combinations

N, M = map(int, sys.stdin.readline().split())

num = []

house = []
chicken = []

result = 999999999

for i in range(N) :
    num.append(list(map(int, sys.stdin.readline().split())))

for i in range(N) :
    for j in range(N) :
        if num[i][j] == 1 :
            house.append([i, j])
        elif num[i][j] == 2 :
            chicken.append([i, j])

for chi in combinations(chicken, M) :
    temp = 0
    for i in house :
        compare = 999
        for j in range(M) :
            compare = min(compare, abs(i[0] - chi[j][0]) + abs(i[1] - chi[j][1]))
        temp += compare
    result = min(result, temp)
    
print(result)