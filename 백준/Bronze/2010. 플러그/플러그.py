import sys

T = int(sys.stdin.readline())

result = 0

for i in range(T) :
    result += int(sys.stdin.readline()) - 1

result += 1

print(result)