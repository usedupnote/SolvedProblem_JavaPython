import sys
input = sys.stdin.readline

num = []

for i in range(3) :
    compare = list(map(int, input().split()))
    compare[0] = compare[3] - compare[0]
    compare[1] = compare[4] - compare[1]
    compare[2] = compare[5] - compare[2]
    num.append(compare[:3])

for i in num :
    if i[2] < 0 :
        i[2] += 60
        i[1] -= 1
    if i [1] < 0 :
        i[1] += 60
        i[0] -= 1
    print(*i)