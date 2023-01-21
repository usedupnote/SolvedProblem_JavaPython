import sys
input = sys.stdin.readline

T = int(input())

for test_case in range(T) :
    positon = list(map(int, input().split()))

    result = 0

    if positon[0] == positon[3] and positon[1] == positon[4] and positon[2] != positon[5] :
        result = 0
    elif positon[0] == positon[3] and positon[1] == positon[4] and positon[2] == positon[5] :
        result = -1
    else :
        compare = (((positon[0] - positon[3])**2) + ((positon[1] - positon[4])**2))

        checkOutterCircle = (positon[2] + positon[5]) ** 2
        checkInnerCircle = (positon[2] - positon[5]) ** 2

        if compare > checkOutterCircle or compare < checkInnerCircle:
            result = 0
        elif compare == checkOutterCircle or compare == checkInnerCircle:
            result = 1
        else :
            result = 2

    print(result)