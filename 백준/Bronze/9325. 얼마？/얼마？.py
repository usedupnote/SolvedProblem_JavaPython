import sys

T = int(sys.stdin.readline())

for i in range(T):
    result = int(sys.stdin.readline())

    n = int(sys.stdin.readline())

    for j in range(n) :
        count, p = map(int, sys.stdin.readline().split())
        result += count * p
    print(result)