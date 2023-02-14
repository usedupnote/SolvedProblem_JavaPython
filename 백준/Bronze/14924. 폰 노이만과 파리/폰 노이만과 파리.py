import sys
input = sys.stdin.readline

S, T, D = map(int, input().split())

print(T * (D // (S * 2)))