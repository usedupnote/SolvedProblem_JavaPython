import sys

while True :
    N = int(sys.stdin.readline())

    if N == -1 : break

    num = [1]

    for i in range(2, N//2 + 1) :
        if N % i == 0 : num.append(i)

    if N == sum(num) :
        print(N,"=",sep=" ", end=" ")
        print(*num, sep=" + ")
    else :
        print("{} is NOT perfect.".format(N))