import sys
input = sys.stdin.readline

T = int(input())

num = []

for i in range(T) :
    num.append(float(input()))

num.sort()

for i in range(7) :
    print(format(num[i], ".3f"))