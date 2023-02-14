import sys

T = int(sys.stdin.readline())

for i in range(T) :
    data = list(input())
    count = len(data)
    check = -1

    if count % 2 == 0 :
        check = 0
        for j in data :
            if j == "(" :
                check += 1
            else :
                check -= 1
            if check < 0 :
                break

    if check == 0 :
        print("YES")
    else :
        print("NO")