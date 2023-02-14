import sys

N = int(sys.stdin.readline())

for i in range(N-1, 0, -1):
    print("{}{}{}".format("*" * (N - i), " " * (2 * i), "*" * (N - i)))
for i in range(0, N+1):
    print("{}{}{}".format("*" * (N - i), " " * (2 * i), "*" * (N - i)))