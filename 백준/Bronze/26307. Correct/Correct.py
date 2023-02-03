import sys
input = sys.stdin.readline

H, M = map(int, input().split())

print(((H -9) * 60) + M)