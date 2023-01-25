import sys
input = sys.stdin.readline

N = int(input())

minPoint = 0
maxPoint = N
point = (minPoint + maxPoint) // 2

while minPoint != maxPoint :
    if (minPoint == maxPoint) :
        break
    elif point ** 2 < N :
        minPoint = point + 1
        point = (minPoint + maxPoint) // 2
    else :
        maxPoint = point
        point = (minPoint + maxPoint) // 2

print(point)