import sys
input = sys.stdin.readline

C, K, P = map(int, input().split())

result = 0

for i in range(1, C + 1) :
    result += i * (K + (P * i))

print(result)