import sys

T = int(sys.stdin.readline())
num = list(map(int, sys.stdin.readline().split()))

for i in range(1, T) :
    if (num[i-1] * num[i]) != 0 :
        num[i] = num[i-1] + 1
print(sum(num))