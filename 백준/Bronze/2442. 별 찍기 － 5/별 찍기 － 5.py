import sys

N = int(sys.stdin.readline())

for i in range(1, N+1):
    print("{}{}".format(" " * (N - i), "*" * (2 * i - 1)))