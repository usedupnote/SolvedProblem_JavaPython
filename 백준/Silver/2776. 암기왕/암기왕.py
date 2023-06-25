import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T) :
    N = int(input())
    num1 = set(input().split())
    M = int(input())
    num2 = list(input().split())
    for i in num2 :
        print(1 if (i in num1) else 0)