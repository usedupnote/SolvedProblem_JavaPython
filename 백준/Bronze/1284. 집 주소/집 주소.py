import sys

while True :
    num = list(map(int, sys.stdin.readline().strip()))
    if len(num) == 1 and num[0] == 0 :
        break
    else :
        result = 1

        for i in num :
            if i == 0 :
                result += 5
            elif i == 1 :
                result += 3
            else :
                result += 4

        print(result)