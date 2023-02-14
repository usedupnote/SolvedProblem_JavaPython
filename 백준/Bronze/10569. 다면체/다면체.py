import sys

T = int(sys.stdin.readline())

for i in range(T):
    num = list(map(int, sys.stdin.readline().split()))

    print(2 - num[0] + num[1])