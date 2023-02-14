import sys

T = int(sys.stdin.readline())

for i in range(1, T+1) :
    rate = list(map(int, input().split()))

    gap = 0

    count = rate.pop(0)

    rate.sort()

    if count != 1 :
        for j in range(1, count) :
            gap = max(gap, rate[j] - rate[j-1])

    print("Class {}".format(i))
    print("Max {}, Min {}, Largest gap {}".format(rate[count-1], rate[0], gap))