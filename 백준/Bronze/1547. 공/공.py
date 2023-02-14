import sys
input = sys.stdin.readline

cup = [1, 0, 0]

T = int(input())

for i in range(T) :
    num = list(map(int, input().split()))

    check = 0
    if cup[num[0] - 1] + cup[num[1]-1] != 0 :
        check = cup[num[0] - 1]
        cup[num[0] - 1] = cup[num[1] - 1]
        cup[num[1] - 1] = check

for i in range(3) :
    if cup[i] == 1 :
        print(i + 1)
        break