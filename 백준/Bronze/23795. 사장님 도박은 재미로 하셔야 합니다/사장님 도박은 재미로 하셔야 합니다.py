import sys
input = sys.stdin.readline

X = int(input())

result = 0

while X != -1 :
    result += X
    X = int(input())
print(result)