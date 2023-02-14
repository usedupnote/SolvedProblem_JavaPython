import sys

A, B, C = map(int, sys.stdin.readline().split())

if B > C :
    print(int(A * B / C))
else :
    print(int(A / B * C))