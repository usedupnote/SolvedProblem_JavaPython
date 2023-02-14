import sys

A, B = map(int, sys.stdin.readline().split())

num = []

count = 1
result = 0

maxLen = 0

while maxLen <= 1000 :
    maxLen += count
    count += 1

for i in range(1, count) :
    for j in range(i) :
        num.append(i)

print(sum(num[A-1:B]))