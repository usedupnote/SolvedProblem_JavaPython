import sys
input = sys.stdin.readline

T = int(input())

num = [1, 2, 4]
point = []

for i in range(2, 10):
    num.append(num[i-2] + num[i - 1] + num[i])

for i in range(T):
    point.append(int(input()))

for i in point:
    print(num[i - 1])