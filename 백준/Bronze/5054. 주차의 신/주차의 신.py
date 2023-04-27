import sys
input = sys.stdin.readline

t = int(input())

for TC in range(t) :
    n = int(input())

    x = list(map(int, input().split()))

    x.sort()

    print((x[len(x)-1] - x[0]) * 2)