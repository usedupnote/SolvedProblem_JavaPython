import sys
input = sys.stdin.readline

cup = [1, 0, 0]

T = int(input())

for i in range(T) :
    num = list(map(int, input().split()))

    result = num[1] - (num[0] + num[2])

    if result > 0 : print("advertise")
    elif result < 0 : print("do not advertise")
    else : print("does not matter")