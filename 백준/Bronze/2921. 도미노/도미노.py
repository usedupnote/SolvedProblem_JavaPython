import sys
input = sys.stdin.readline

N = int(input())

result = 0

for i in range(N + 1) :
    for j in range(i + 1) :
        result += j + i

print(result)