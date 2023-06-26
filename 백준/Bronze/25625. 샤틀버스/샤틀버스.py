import sys
input = sys.stdin.readline

N,M = map(int, input().split())

if N > M :
    print(M+N)
else :
    print(M-N)