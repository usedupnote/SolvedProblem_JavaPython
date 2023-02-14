import sys

A = int(sys.stdin.readline())
B = int(sys.stdin.readline())
C = int(sys.stdin.readline())
D = int(sys.stdin.readline())
E = int(sys.stdin.readline())

print(A - max(B//D+ (1 if B % D != 0 else 0), C//E  + (1 if C % E != 0 else 0)))