import sys

N = int(sys.stdin.readline())

for i in range(N) :
    for j in range(2) :
        for k in range(N) :
            if (k + j) % 2 == 0 :
                print("*", end="")
            else :
                print(" ", end="")
        print("")