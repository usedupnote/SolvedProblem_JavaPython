import sys
input = sys.stdin.readline

T = int(input())

num = []
maximum = 0
result = 0

for i in range(T) :
    num.append(int(input()))

for i in range(T-1, -1, -1) :
    if num[i] > maximum :
        maximum = num[i]
        result += 1

print(result)