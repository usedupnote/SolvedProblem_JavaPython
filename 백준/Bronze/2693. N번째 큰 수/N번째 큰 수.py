import sys
input = sys.stdin.readline

T = int(input())

for i in range(T) :
    num = list(map(int, input().split()))
    num.sort(reverse=True)
    print(num[2])