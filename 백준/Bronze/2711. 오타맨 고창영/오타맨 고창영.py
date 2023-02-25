import sys
input = sys.stdin.readline

T = int(input())

for i in range(T) :
    N, str = input().split()
    N = int(N)
    print(str[:N - 1], str[N:], sep="")