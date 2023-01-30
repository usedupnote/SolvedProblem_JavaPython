import sys
input = sys.stdin.readline

T = int(input())

housePaintintPrice = [list(map(int, input().split()))]

for i in range(T-1):
    house = list(map(int, input().split()))

    house[0] += min(housePaintintPrice[i][1], housePaintintPrice[i][2])
    house[1] += min(housePaintintPrice[i][0], housePaintintPrice[i][2])
    house[2] += min(housePaintintPrice[i][0], housePaintintPrice[i][1])

    housePaintintPrice.append(house)

print(min(housePaintintPrice[T-1]))