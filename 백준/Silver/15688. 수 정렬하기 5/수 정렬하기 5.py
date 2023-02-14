import sys

T = int(sys.stdin.readline())

num = []

for i in range(T) :
    num.append(int(sys.stdin.readline()))

num.sort()

print(*num, sep="\n")