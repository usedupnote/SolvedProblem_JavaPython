import sys
T = int(sys.stdin.readline().strip())

for i in range(T) :
    num = list(map(int, sys.stdin.readline().split()))

    num.sort()

    GCD = 0

    if num[1] % num[0] == 0:
        print(num[1])
    else :
        for i in range(num[0] // 2 + 1, 0, -1) :
            if num[0] % i == 0 :
                if num[1] % i == 0 :
                    GCD = i
                    break
        print(num[1]*num[0] // i)