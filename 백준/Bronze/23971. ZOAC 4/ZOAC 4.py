import sys
input = sys.stdin.readline
H,W,N,M = map(int, input().split())
H+=N
W+=M
print((H//(N+1)) * (W//(M+1)))