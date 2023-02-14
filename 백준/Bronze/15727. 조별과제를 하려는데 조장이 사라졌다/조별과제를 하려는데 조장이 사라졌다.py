import sys

N = int(sys.stdin.readline())

print((N//5) + (0 if N%5 == 0 else 1))