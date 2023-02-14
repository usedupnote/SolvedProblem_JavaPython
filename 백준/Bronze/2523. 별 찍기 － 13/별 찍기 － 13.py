import sys

N = int(sys.stdin.readline())

for i in range(1,N) :
    print("{}".format("*"*i))

for i in range(N, 0, -1) :
    print("{}".format("*"*i))