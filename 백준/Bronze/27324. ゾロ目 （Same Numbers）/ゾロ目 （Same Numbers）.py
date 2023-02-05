import sys
input = sys.stdin.readline

n = int(input())

if (n // 10) - (n % 10) == 0 :
    print(1)
else :
    print(0)