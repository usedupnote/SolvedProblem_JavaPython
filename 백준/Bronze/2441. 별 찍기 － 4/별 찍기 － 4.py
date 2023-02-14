import sys

N = int(sys.stdin.readline())

for i in range(N, 0, -1) :
    print("{}{}".format(" "*(N-i), "*"*i))