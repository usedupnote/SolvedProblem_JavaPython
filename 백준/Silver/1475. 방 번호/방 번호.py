import sys
input = sys.stdin.readline

s = list(map(int, input().strip()))

num = [0 for _ in range(9)]
num[6] += 1
for i in s :
    if i == 9 :
        num[6] += 1
    else :
        num[i] += 1
num[6] = num[6] // 2

print(max(num))