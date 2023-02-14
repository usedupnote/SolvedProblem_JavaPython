import sys
input = sys.stdin.readline

A, B = map(int, input().split())

C = int(input())

result = A + B - (2 * C)

if result < 0:
    print(A + B)
else :
    print(result)