import sys

stack = []
compare = {}

M = int(sys.stdin.readline())
stack = list(map(int, sys.stdin.readline().split()))
N = int(sys.stdin.readline())
num = list(map(int, sys.stdin.readline().split()))

for i in stack:
    if i in compare :
        compare[i] += 1
    else :
        compare[i] = 1

for i in num :
    print(compare[i] if (i in compare) else 0, end=" ")