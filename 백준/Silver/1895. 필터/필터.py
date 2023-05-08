import sys
input = sys.stdin.readline

R, C = map(int, input().split())

img = [[] for _ in range(R)]

for i in range(R) :
    img[i] = list(map(int, input().split()))

T = int(input())

result = 0
for i in range(R-2) :
    for j in range(C-2) :
        filter = []
        for x in range(3) :
            for y in range(3) :
                filter.append(img[i+x][j+y])
        filter.sort()
        if filter[4] >= T :
            result += 1
print(result)