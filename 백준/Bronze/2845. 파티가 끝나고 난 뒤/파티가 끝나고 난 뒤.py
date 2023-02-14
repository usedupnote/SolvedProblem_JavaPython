import sys

person = list(map(int, sys.stdin.readline().split()))
num = list(map(int, sys.stdin.readline().split()))

result = []

check = person[0] * person[1]

for i in range(5) :
    result.append(num[i]-check)

print(*result)