import sys

N = int(input())

num = [0] * 10001

for i in range(N) :
    num[int(sys.stdin.readline())] += 1

for i in range(10001) :
    count = num[i]

    while count > 0 :
        print(i)
        count -= 1
        N -= 1

    if N <= 0 :
        break