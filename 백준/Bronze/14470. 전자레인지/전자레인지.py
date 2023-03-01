import sys
input = sys.stdin.readline

A = int(input())
B = int(input())
C = int(input())
D = int(input())
E = int(input())

result = 0

if A < 0:
    result = C * (-A)
    result += D
    A = 0

result += E * (B - A)

print(result)