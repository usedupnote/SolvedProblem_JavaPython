import sys

T = int(sys.stdin.readline())

for i in range(T) :
    case = list(map(int, sys.stdin.readline().split()))

    count = 0
    check = sum(case[1:]) / case[0]

    for j in case[1:] :
        if j > check :
            count += 1

    print("{}%".format(format(count/case[0]*100, "0.3f")))